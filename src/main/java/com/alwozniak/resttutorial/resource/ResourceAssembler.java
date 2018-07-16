package com.alwozniak.resttutorial.resource;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * An abstract base class for resoure assemblers. Implementing classes need to provide a method for constructing
 * a resource from a domain object.
 *
 * @param <DomainType> type of a domain object to be converted to a resource
 * @param <ResourceType> type of created resource
 */
public abstract class ResourceAssembler<DomainType, ResourceType> {

    public abstract ResourceType toResource(DomainType domainObject);

    public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {
        return domainObjects
                .stream()
                .map(object -> toResource(object))
                .collect(Collectors.toList());
    }
}
