package com.example.todo;

import java.util.*;

public class TodoList {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public boolean completeTask(int index) {
        if (index < 0 || index >= tasks.size()) return false;
        tasks.get(index).setDone(true);
        return true;
    }

    public boolean removeTask(int index) {
        if (index < 0 || index >= tasks.size()) return false;
        tasks.remove(index);
        return true;
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public static class Task {
        private final String description;
        private boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getDescription() { return description; }
        public boolean isDone() { return isDone; }

        public void setDone(boolean done) { isDone = done; }
    }
}