package com.workstudy.test.controller;

/**
 * Created with IntelliJ IDEA
 * Created By fukaiqi
 * Date: 2017/8/11 0011
 * Time: 14:13
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/resources/spring-mvc.xml", "file:src/main/resources/spring-mybatis.xml"})
public class TodoControllerTest {
    @Resource
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;

    @Before
    public void init() {
        this.mockMvc = webAppContextSetup(this.wac).build();//获取mockMvc实例

        this.session = new MockHttpSession();
        this.session.setAttribute("userId", "123");
        // 这是一个5年有效期的token 0.0
        this.session.setAttribute("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjAxMTY5MTA2ODksInBheWxvYWQiOiJ7XCJ1c2VySWRcIjpcIjEyM1wiLFwibmFtZVwiOm51bGwsXCJwYXNzd29yZFwiOlwiMTIzXCIsXCJlbWFpbFwiOm51bGwsXCJwaG9uZVwiOm51bGwsXCJhY2FkZW15XCI6bnVsbCxcIm1ham9yXCI6bnVsbCxcImNsYXNzTmFtZVwiOm51bGwsXCJ0eXBlXCI6MH0ifQ.gHyRixVOGLT3xhgACWrc_83OEHJAX4jfE8GytgcwfQ8");
    }

    @Test
    public void testTodo() throws Exception {
        mockMvc.perform(get("/todo/allTodo").session(this.session))
                .andDo(print())
                .andReturn();
    }
}