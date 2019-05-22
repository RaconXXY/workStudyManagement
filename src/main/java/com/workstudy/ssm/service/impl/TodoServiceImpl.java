package com.workstudy.ssm.service.impl;

import com.workstudy.ssm.dao.TodoDao;
import com.workstudy.ssm.model.Todo;
import com.workstudy.ssm.service.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class TodoServiceImpl implements TodoService {

    @Resource
    private TodoDao TodoDao;

    public List<Todo> getAllTodo() {
        return TodoDao.selectAllTodo();
    }

    public Todo getTodoById(Long TodoId) {
        return TodoDao.selectTodoById(TodoId);
    }

    public void addTodo(Todo todo) {
        TodoDao.addTodo(todo);
    }

    public void deleteTodoById(Long todoId) {
        TodoDao.deleteTodoById(todoId);
    }

    public void updateTodo(Todo todo) {
        TodoDao.updateTodo(todo);
    }
}
