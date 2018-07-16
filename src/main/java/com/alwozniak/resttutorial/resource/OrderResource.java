package com.alwozniak.resttutorial.resource;

import com.alwozniak.resttutorial.domain.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * A resource class for Order. Extending ResourceSupport allows for automatically attaching HATEOAS links.
 *
 * The reason for separating Order class from its Resource is that we do not want to add any presentation layer details
 * (eg. links) to the entity.
 */
public class OrderResource extends ResourceSupport {

    private final long id;
    private final String description;
    private final long costInCents;
    private final boolean isComplete;

    public OrderResource(Order order) {
        this.id = order.getId();
        this.description = order.getDescription();
        this.costInCents = order.getCostInCents();
        this.isComplete = order.isComplete();
    }

    @JsonProperty("id")
    public long getResourceId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public boolean isComplete() {
        return isComplete;
    }
}
