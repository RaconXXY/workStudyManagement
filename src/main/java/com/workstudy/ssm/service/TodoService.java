package com.workstudy.ssm.service;

import com.workstudy.ssm.model.Todo;

import java.util.List;


public interface TodoService {

    List<Todo> getAllTodo();

    Todo getTodoById(Long todoId);

    void addTodo(Todo todo);

    void deleteTodoById(Long todoId);

    void updateTodo(Todo todo);
}
