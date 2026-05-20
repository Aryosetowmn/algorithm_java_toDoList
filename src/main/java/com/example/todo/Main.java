package com.example.todo;

public class Main {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.addTask("Ngoding Java");
        System.out.println(list.getTasks().get(0).getDescription());
    }
}