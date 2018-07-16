package com.alwozniak.resttutorial.repository;

import com.alwozniak.resttutorial.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * An in-memory repository of Orders.
 */
@Repository
public class OrderRepository extends InMemoryRepository<Order> {

    @Override
    protected void updateIfExists(Order original, Order updated) {
        original.setDescription(updated.getDescription());
        original.setComplete(updated.isComplete());
        original.setCostInCents(updated.getCostInCents());
    }
}
