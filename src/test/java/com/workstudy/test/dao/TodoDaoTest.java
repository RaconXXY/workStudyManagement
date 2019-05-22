package com.workstudy.test.dao;

import com.workstudy.ssm.dao.TodoDao;
import com.workstudy.ssm.model.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/11 0011
 * Time: 14:13
 */

// 指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
// 指定Spring的配置文件 路径相对classpath而言
@ContextConfiguration(locations = {"file:src/main/resources/spring-mvc.xml", "file:src/main/resources/spring-mybatis.xml"})
// 如果在类上面使用该注解，这样所有的测试方案都会自动的 rollback
// @Transactional
public class TodoDaoTest {

    @Resource
    private TodoDao todoDao;

    @Test
    // 使用事务
    @Transactional
    // 执行完以后回滚事务，如果设置为false，则不回滚
    @Rollback(true)
    public void addTodo() {
        Todo todo = new Todo();
        todo.setId(10L);
        todo.setContent("test");
        todo.setIsfinish(false);
        todoDao.addTodo(todo);

        Todo newtodo = todoDao.selectTodoById(todo.getId());
        Assert.assertNotNull(newtodo);
    }
}

