package com.alwozniak.resttutorial.domain;

// NOTE: Extending Spring HATEOAS Identifiable which provides getId() method.
public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {
    public void setId(Long id);
}
