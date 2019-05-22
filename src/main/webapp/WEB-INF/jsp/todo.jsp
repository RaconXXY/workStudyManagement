<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" href="/css/todo.css">
</head>
<body>
<%@include file="common/nav.jsp" %>

<h1>我是测试</h1>
<div class="todolist">
    <div class="items" id="items">
        <c:if test="${!empty todoList}">
            <c:forEach var="todo" items="${todoList}">
                <div class="item" id="todo${todo.id}">
                    <div class="index">${todo.id}</div>
                    <input class="content" value="${todo.content}" onblur="updateTodo(${todo.id})"/>
                    <div class="mybtn delete" onclick="deleteTodo(${todo.id})">Delete</div>
                        <%--<div>${todo.isfinish}</div>--%>
                </div>
            </c:forEach>
        </c:if>

    </div>
    <div class="end">
        <button class="mybtn add" onclick="addTodo()">添加</button>
    </div>
</div>


<%@include file="common/footer.jsp" %>
<%@include file="common/jslib.jsp" %>

<script src="/js/todo.js"></script>
</body>
</html>
