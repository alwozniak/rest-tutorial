package com.alwozniak.resttutorial.domain;

public class Order implements Identifiable {

    private long id;
    private String description;
    private long costInCents;
    private boolean isComplete;

    public long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(long costInCents) {
        this.costInCents = costInCents;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public void markComplete() {
        setComplete(true);
    }

    public void markIncomplete() {
        setComplete(false);
    }
}
