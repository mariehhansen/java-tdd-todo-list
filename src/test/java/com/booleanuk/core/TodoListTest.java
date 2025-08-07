package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TodoListTest {
    @Test
    public void shouldBeIncomplete() {
        Task task = new Task(" ");
        Assertions.assertEquals(false, task.isComplete());
    }

    @Test
    public void shouldMakeComplete() {
        Task task = new Task(" ");
        task.setComplete();
        Assertions.assertEquals(true, task.isComplete());
    }

    @Test
    public void shouldMakeIncomplete() {
        Task task = new Task(" ");
        task.setComplete();
        task.setIncomplete();
        Assertions.assertEquals(false, task.isComplete());
    }

    @Test
    public void shouldAddTask() {
        TodoList todo = new TodoList();
        Task t = new Task(" ");
        todo.addTask(t);
        Assertions.assertTrue(todo.allTasks.contains(t));
    }

    @Test
    public void shouldPrintAll() {
        TodoList todo1 = new TodoList();
        TodoList todo2 = new TodoList();
        Task t1 = new Task("a");
        Task t2 = new Task("b");
        todo1.allTasks.add(t1);
        todo1.allTasks.add(t2);
        todo2.allTasks.add(t1);
        todo2.allTasks.add(t2);
        Assertions.assertEquals(todo1.allTasks, todo2.allTasks);
    }

    @Test
    public void shouldGetAllComplete() {
        TodoList todo = new TodoList();
        Task t1 = new Task("1");
        Task t2 = new Task("2");
        Task t3 = new Task("3");
        Task t4 = new Task("4");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        t4.setComplete();
        Assertions.assertEquals(List.of(t4), todo.getCompleteTasks());

    }

    @Test
    public void shouldGetAllIncomplete() {
        TodoList todo = new TodoList();
        Task t1 = new Task("1");
        Task t2 = new Task("2");
        Task t3 = new Task("3");
        Task t4 = new Task("4");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        t3.setComplete();
        t4.setComplete();
        Assertions.assertEquals(List.of(t1, t2), todo.getIncompleteTasks());
    }

    @Test
    public void shouldSearchForTask() {
        TodoList todo = new TodoList();
        Task t1 = new Task("cook");
        Task t2 = new Task("work");
        Task t3 = new Task("shop");
        Task t4 = new Task("clean");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        t4.setComplete(); t3.setComplete();
        Assertions.assertEquals(todo.noSuchTask(), todo.searchForTask("relax"));
    }

    @Test
    public void shouldRemoveTask() {
        TodoList todo = new TodoList();
        Task t1 = new Task(" ");
        todo.addTask(t1);
        Task removed = todo.removeTask(t1);
        Assertions.assertTrue(!todo.allTasks.contains(t1));
        Assertions.assertTrue(removed.equals(t1));
    }

    @Test
    public void shouldShowAscending() {
        // a-z
        // a < b
        // b > a
        TodoList todo = new TodoList();
        Task a = new Task("a");
        Task b = new Task("b");
        Task c = new Task("c");
        Task d = new Task("d");
        todo.addTask(a);
        todo.addTask(b);
        todo.addTask(c);
        todo.addTask(d);
        Assertions.assertEquals(a, todo.ascendingView().getFirst());
    }

    @Test
    public void shouldShowDescending() {
        // z-a
        TodoList todo = new TodoList();
        Task a = new Task("a");
        Task b = new Task("b");
        Task c = new Task("c");
        Task d = new Task("d");
        todo.addTask(a);
        todo.addTask(b);
        todo.addTask(c);
        todo.addTask(d);
        Assertions.assertEquals(d, todo.descendingView().getFirst());
    }

}
