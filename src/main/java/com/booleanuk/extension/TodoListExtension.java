package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoListExtension {
    List<TaskExtension> allTasks;

    public TodoListExtension() {
        allTasks = new ArrayList<>();
    }

    public void addTask(TaskExtension t) {
        if (!(allTasks.contains(t))) {
            allTasks.add(t);
        }
    }

    public void setTaskCompleteById(int otherId) {
        for (TaskExtension t : allTasks) {
            if (t.getId() == otherId) {
                t.setComplete();
            }
        }
    }

    public void setTaskIncompleteById(int otherId) {
        for (TaskExtension t : allTasks) {
            if (t.getId() == otherId) {
                t.setIncomplete();
            }
        }
    }

    public TaskExtension getTaskById(int id) {

        for (TaskExtension t : allTasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void getTasks() {
        // tests by comparing two TodoLists, is that ok?
        if (allTasks.isEmpty()) {
            return;
        }

        for (TaskExtension t : allTasks) {
            t.toString();
        }
    }

    public LocalDateTime getTaskTimeCreated(int id) {
        if (allTasks.isEmpty()) {
            return null;
        }
        return getTaskById(id).getTimeCreated();
    }

    public List<TaskExtension> getCompleteTasks() {

        List<TaskExtension> completed = new ArrayList<>();
        for (TaskExtension t : allTasks) {
            if (t.isComplete()) {
                completed.add(t);
            }
        }
        return completed;
    }

    public List<TaskExtension> getIncompleteTasks() {

        List<TaskExtension> incomplete = new ArrayList<>();

        for (TaskExtension t : allTasks) {
            if (!t.isComplete()) {
                incomplete.add(t);
            }
        }
        return incomplete;
    }

    public TaskExtension searchForTask(String description) {

        for (TaskExtension t : allTasks) {

            if (t.getDescription().equals(description)) {
                return t;
            }
        }

        noSuchTask();
        return null;
    }

    public TaskExtension removeTask(TaskExtension t) {
        allTasks.remove(t);
        return t;
    }

    public List<TaskExtension> ascendingView() {
        TaskExtension[] toBeSorted = new TaskExtension[allTasks.size()];
        TaskExtension temp;

        for (int i = 0; i < toBeSorted.length; i ++) {
            toBeSorted[i] = allTasks.get(i);
        }

        for (int i = 0; i < allTasks.size(); i ++) {
            for (int j = i + 1; j < allTasks.size(); j ++) {

                if (toBeSorted[i].getDescription().compareTo(toBeSorted[j].getDescription()) > 0) {
                    temp = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[j];
                    toBeSorted[j] = temp;
                }
            }
        }
        List<TaskExtension> ascending = new ArrayList<>();
        ascending.addAll(List.of(toBeSorted));
        return ascending;
    }

    public List<TaskExtension> descendingView() {
        TaskExtension[] toBeSorted = new TaskExtension[allTasks.size()];
        TaskExtension temp;

        for (int i = 0; i < toBeSorted.length; i ++) {
            toBeSorted[i] = allTasks.get(i);
        }

        for (int i = 0; i < allTasks.size(); i ++) {
            for (int j = i + 1; j < allTasks.size(); j ++) {

                if (toBeSorted[i].getDescription().compareTo(toBeSorted[j].getDescription()) < 0) {
                    temp = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[j];
                    toBeSorted[j] = temp;
                }
            }
        }
        List<TaskExtension> descending = new ArrayList<>();
        descending.addAll(List.of(toBeSorted));
        return descending;
    }

    public TaskExtension noSuchTask() {
        System.out.println("There is no such task in the todo-list.");
        return null;
    }
}
