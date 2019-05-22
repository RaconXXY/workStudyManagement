package com.workstudy.ssm.controller;

import com.workstudy.ssm.model.Todo;
import com.workstudy.ssm.service.TodoService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private Logger log = Logger.getLogger(TodoController.class);
    @Resource
    private TodoService todoService;

    @GetMapping("/allTodo")
    public String allTodo(HttpServletRequest request, Model model) {
        log.info("查询所有Todo信息");
        List<Todo> todoList = todoService.getAllTodo();
        model.addAttribute("todoList", todoList);
        return "todo";
    }

    @PostMapping("/addTodo")
    @ResponseBody
//    public Todo addTodo(@RequestBody Todo todo) {
//        log.info("增加todo");
//        log.info(todo);
//        todoService.addTodo(todo);
//        return todo;
//    }
    public Map addTodo(@RequestBody Map map) {
        log.info("前后端交流任意json字段测试");
        log.info("前端ajax请求的全部key-value：");
        for(Object ley : map.keySet()){
            Object value = map.get(ley);
            log.info(ley);
            log.info(value);
        }
        Todo todo = new Todo();
        todo.setId(11111L);
        todo.setContent("content");
        todo.setIsfinish(false);
        map.put("todo",todo);
        map.put("string","string");
        return map;
    }

    @PostMapping("/deleteTodo")
    @ResponseBody
    public void deleteTodo(HttpServletRequest request) {
        String todoId = request.getParameter("todoId");
        log.info("删除Todo");
        log.info(todoId);
        Long id = Long.parseLong(todoId);
        log.info(id);
        todoService.deleteTodoById(id);
    }

    @PostMapping("/updateTodo")
    @ResponseBody
    public void updateTodo(@RequestBody Todo todo) {
        log.info("更新Todo");
        log.info(todo);
        todoService.updateTodo(todo);
    }
}
