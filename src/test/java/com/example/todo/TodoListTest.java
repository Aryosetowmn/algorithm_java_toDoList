package com.example.todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    @Test
    void testAddTask() {
        TodoList list = new TodoList();
        list.addTask("Belajar Git");
        assertEquals(1, list.getTasks().size());
        assertEquals("Belajar Git", list.getTasks().get(0).getDescription());
    }

    @Test
    void testCompleteTask() {
        TodoList list = new TodoList();
        list.addTask("Push ke GitHub");
        boolean done = list.completeTask(0);
        assertTrue(done, "Task harus dapat diselesaikan");
        assertTrue(list.getTasks().get(0).isDone());
    }

    @Test
    void testRemoveTask() {
        TodoList list = new TodoList();
        list.addTask("Pull request");
        boolean removed = list.removeTask(0);
        assertTrue(removed, "Task harus terhapus");
        assertEquals(0, list.getTasks().size());
    }

    @Test
    void testRemoveInvalidTask() {
        TodoList list = new TodoList();
        boolean removed = list.removeTask(0);
        assertFalse(removed, "Tidak ada task, remove harus gagal");
    }
}
