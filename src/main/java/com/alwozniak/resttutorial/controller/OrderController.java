package com.alwozniak.resttutorial.controller;

import com.alwozniak.resttutorial.domain.Order;
import com.alwozniak.resttutorial.repository.OrderRepository;
import com.alwozniak.resttutorial.resource.OrderResource;
import com.alwozniak.resttutorial.resource.OrderResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")     // Enabling cross-origin resource sharing
@RestController                 // Telling Spring that this class is a controller and includes REST endpoints.
@ExposesResourceFor(Order.class)
@RequestMapping(value = "/order", produces = "application/json")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderResourceAssembler orderResourceAssembler;

    /**
     * Responding to a GET request to /orders: retrieving a list of all orders.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<OrderResource>> findAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return new ResponseEntity<>(orderResourceAssembler.toResourceCollection(orders), HttpStatus.OK);
    }

    /**
     * Responding to a GET request to /orders/{id}: retrieving a single order by id.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<OrderResource> findOrderById(@PathVariable Long id) {
        Optional<Order> maybeOrder = orderRepository.findById(id);
        if (maybeOrder.isPresent()) {
            return new ResponseEntity<>(orderResourceAssembler.toResource(maybeOrder.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<OrderResource> createResource(@RequestBody Order order) {
        Order createdOrder = orderRepository.create(order);
        return new ResponseEntity<>(orderResourceAssembler.toResource(createdOrder), HttpStatus.CREATED);
    }

    /**
     * Responding to a DELETE request to /orders/{id}: deleting a resource with a given id.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean isDeleted = orderRepository.delete(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Responding to a PUT request to /orders/{id}: updating an existing order.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<OrderResource> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        boolean isUpdated = orderRepository.update(id, updatedOrder);
        if (isUpdated) {
            return findOrderById(id);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
