package com.booleanuk.core;

public class Task {
    Boolean isComplete;
    String description;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public Boolean isComplete() {
        return this.isComplete;
    }

    void setComplete() {
        this.isComplete = true;
    }

    void setIncomplete() {
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
