package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.Todo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoDao {

    List<Todo> selectAllTodo();

    Todo selectTodoById(@Param("todoId") Long todoId);

    void addTodo(@Param("todo") Todo todo);

    void deleteTodoById(@Param("todoId") Long todoId);

    void updateTodo(@Param("todo") Todo todo);


}
