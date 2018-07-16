package com.alwozniak.resttutorial.repository;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * An IdGenerator is required for in-memory data source layer.
 *
 * Prototype scope of this bean ensures that each data source has its own IdGenerator instance.
 */
@Component      // This annotation IdGenerator is injectable.
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

    // NOTE: use of AtomicLong prevents race conditions.
    private AtomicLong nextId = new AtomicLong(1);

    public long getNextId() {
        return nextId.getAndIncrement();
    }
}
