package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class TodoListExtensionTest {

    @Test
    public void shouldGetId() {
        TaskExtension task = new TaskExtension(0, " ");
        Assertions.assertEquals(0, task.getId());
    }
    @Test
    public void shouldBeIncomplete() {
        TaskExtension task = new TaskExtension(0, " ");
        Assertions.assertEquals(false, task.isComplete());
    }

    @Test
    public void shouldMakeComplete() {
        TaskExtension task = new TaskExtension(0, " ");
        task.setComplete();
        Assertions.assertEquals(true, task.isComplete());
    }

    @Test
    public void shouldMakeCompleteById() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        todo.allTasks.add(t1);
        todo.allTasks.add(t2);
        todo.setTaskCompleteById(1);
        Assertions.assertTrue(t2.isComplete());
    }

    @Test
    public void shouldMakeIncompleteById() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        todo.allTasks.add(t1);
        todo.allTasks.add(t2);
        todo.setTaskCompleteById(1);
        todo.setTaskIncompleteById(1);
        Assertions.assertFalse(t2.isComplete());
    }


    @Test
    public void shouldMakeIncomplete() {
        TaskExtension task = new TaskExtension(0, " ");
        task.setComplete();
        task.setIncomplete();
        Assertions.assertEquals(false, task.isComplete());
    }

    @Test
    public void shouldGetTaskById() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        todo.allTasks.add(t1);
        todo.allTasks.add(t2);
        Assertions.assertEquals(t2, todo.getTaskById(1));
    }
    @Test
    public void shouldAddTask() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t = new TaskExtension(0, " ");
        todo.addTask(t);
        Assertions.assertTrue(todo.allTasks.contains(t));
    }

    @Test
    public void shouldPrintAll() {
        TodoListExtension todo1 = new TodoListExtension();
        TodoListExtension todo2 = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        todo1.allTasks.add(t1);
        todo1.allTasks.add(t2);
        todo2.allTasks.add(t1);
        todo2.allTasks.add(t2);
        Assertions.assertEquals(todo1.allTasks, todo2.allTasks);
    }

    @Test
    public void shouldGetAllComplete() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        TaskExtension t3 = new TaskExtension(2, " ");
        TaskExtension t4 = new TaskExtension(3, " ");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        t4.setComplete();
        Assertions.assertEquals(List.of(t4), todo.getCompleteTasks());
    }

    @Test
    public void shouldGetAllIncomplete() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, " ");
        TaskExtension t2 = new TaskExtension(1, " ");
        TaskExtension t3 = new TaskExtension(2, " ");
        TaskExtension t4 = new TaskExtension(3, " ");
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
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0, "clean");
        TaskExtension t2 = new TaskExtension(1, "laundry");
        TaskExtension t3 = new TaskExtension(2, "cook");
        TaskExtension t4 = new TaskExtension(3, "work");
        todo.addTask(t1);
        todo.addTask(t2);
        todo.addTask(t3);
        todo.addTask(t4);
        t4.setComplete(); t3.setComplete();
        Assertions.assertEquals(todo.noSuchTask(), todo.searchForTask("relax"));
    }

    @Test
    public void shouldRemoveTask() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension t1 = new TaskExtension(0," ");
        todo.addTask(t1);
        TaskExtension removed = todo.removeTask(t1);
        Assertions.assertFalse(todo.allTasks.contains(t1));
        Assertions.assertEquals(removed, t1);
    }

    @Test
    public void shouldShowAscending() {
        // a-z
        // a < b
        // b > a
        TodoListExtension todo = new TodoListExtension();
        TaskExtension a = new TaskExtension(0,"a");
        TaskExtension b = new TaskExtension(1, "b");
        TaskExtension c = new TaskExtension(2, "c");
        TaskExtension d = new TaskExtension(3, "d");
        todo.addTask(a);
        todo.addTask(b);
        todo.addTask(c);
        todo.addTask(d);
        Assertions.assertEquals(a, todo.ascendingView().getFirst());
    }

    @Test
    public void shouldShowDescending() {
        // z-a
        TodoListExtension todo = new TodoListExtension();
        TaskExtension a = new TaskExtension(0,"a");
        TaskExtension b = new TaskExtension(1, "b");
        TaskExtension c = new TaskExtension(2, "c");
        TaskExtension d = new TaskExtension(3, "d");
        todo.addTask(a);
        todo.addTask(b);
        todo.addTask(c);
        todo.addTask(d);
        Assertions.assertEquals(d, todo.descendingView().getFirst());
    }

    @Test
    public void shouldReturnLocalDateTime() {
        TodoListExtension todo = new TodoListExtension();
        TaskExtension a = new TaskExtension(0,"a");
        todo.addTask(a);
        Assertions.assertInstanceOf(LocalDateTime.class, todo.getTaskTimeCreated(0));
    }
}
