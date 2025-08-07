package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    List<Task> allTasks;

    public TodoList() {
        allTasks = new ArrayList<>();
    }

    public void addTask(Task t) {
        if (!(allTasks.contains(t))) {
            allTasks.add(t);
        }
    }

    public void seeTasks() {
        if (allTasks.isEmpty()) {
            return;
        }
        for (Task t : allTasks) {
            t.toString();
        }
    }

    public List<Task> getCompleteTasks() {
        List<Task> completed = new ArrayList<>();
        for (Task t : allTasks) {
            if (t.isComplete()) {
                completed.add(t);
            }
        }
        return completed;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> incomplete = new ArrayList<>();

        for (Task t : allTasks) {
            if (!t.isComplete()) {
                incomplete.add(t);
            }
        }
        return incomplete;
    }

    public Task searchForTask(String description) {
        for (Task t : allTasks) {

            if (t.description.equals(description)) {
                return t;
            }
        }
        noSuchTask();
        return null;
    }

    public Task removeTask(Task t) {
        allTasks.remove(t);
        return t;
    }

    public List<Task> ascendingView() {
        Task[] toBeSorted = new Task[allTasks.size()];
        Task temp;

        for (int i = 0; i < toBeSorted.length; i ++) {
            toBeSorted[i] = allTasks.get(i);
        }

        for (int i = 0; i < allTasks.size(); i ++) {
            for (int j = i + 1; j < allTasks.size(); j ++) {

                if (toBeSorted[i].description.compareTo(toBeSorted[j].description) > 0) {
                    temp = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[j];
                    toBeSorted[j] = temp;
                }
            }
        }
        List<Task> ascending = new ArrayList<>();
        ascending.addAll(List.of(toBeSorted));
        return ascending;
    }

    public List<Task> descendingView() {
        Task[] toBeSorted = new Task[allTasks.size()];
        Task temp;

        for (int i = 0; i < toBeSorted.length; i ++) {
            toBeSorted[i] = allTasks.get(i);
        }

        for (int i = 0; i < allTasks.size(); i ++) {
            for (int j = i + 1; j < allTasks.size(); j ++) {

                if (toBeSorted[i].description.compareTo(toBeSorted[j].description) < 0) {
                    temp = toBeSorted[i];
                    toBeSorted[i] = toBeSorted[j];
                    toBeSorted[j] = temp;
                }
            }
        }
        List<Task> descending = new ArrayList<>();
        descending.addAll(List.of(toBeSorted));
        return descending;
    }

    public Task noSuchTask() {
        System.out.println("There is no such task in the todo-list.");
        return null;
    }
}
