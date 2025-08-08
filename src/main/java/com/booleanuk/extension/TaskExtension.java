package com.booleanuk.extension;

import java.time.LocalDateTime;

public class TaskExtension {
    private Boolean isComplete;
    private String description;
    private final int id;
    private LocalDateTime timeCreated;

    public TaskExtension(int id, String description) {
        this.id = id;
        this.isComplete = false;
        this.description = description;
        timeCreated = LocalDateTime.now();
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getTimeCreated() {
        return this.timeCreated;
    }

    public Boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete() {
        this.isComplete = true;
    }

    public void setIncomplete() {
        this.isComplete = false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Task " + description;
        if (isComplete) {
            str += ": Complete.";
            return str;
        }
        str += ": Incomplete.";
        return str;
    }
}
