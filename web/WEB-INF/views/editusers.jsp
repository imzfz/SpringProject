<%@ page import="java.util.Map" %>
<%@ page import="com.google.common.collect.Maps" %><%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2017/11/16
  Time: 下午2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户管理</title>
    <script src="${pageContext.request.contextPath}/scripts/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/scripts/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/scripts/js/question.js" type="text/javascript"></script>
</head>
<body onload="beforeDelorUpdate()">
<!-- 弹窗 -->
<%@include file="modal.jsp" %>
<%--REST方式发送的DELETE请求--%>
<form action="" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>
<!--==================================================================================================-->
<div class="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h4>用户管理</h4>
            <%--退出还没做！！！！！！！--%>
            <%--<a href="${pageContext.request.contextPath}/logout" class="btn btn-link" role="button">退出</a>--%>
        </div>
        <div class="panel-body">
            <button class="btn btn-default" type="button" data-toggle="modal" data-target="#addModal">添加
            </button>
            <button class="btn btn-default" id="updateButton" type="button" data-toggle="modal"
                    data-target="#updateModal">修改
            </button>

            <button class="btn btn-default" id="delButton" type="button">删除</button>
            <%--
                        <form id="doDel" name="doDel" method="post" action="delete">
            --%>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th></th>
                    <th>用户名</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>用户类型</th>
                    <th>地址</th>
                </tr>
                </thead>
                <c:if test="${empty requestScope.users}">
                    <tr>
                        <td>没有任何用户信息</td>
                    </tr>
                </c:if>
                <c:if test="${!empty requestScope.users}">
                    <c:forEach items="${requestScope.users}" var="user" varStatus="status">
                        <c:choose>
                            <c:when test="${user.role == '0'}">
                                <c:set var="type" value="普通用户"/>
                            </c:when>
                            <c:when test="${user.role == '1'}">
                                <c:set var="type" value="管理员"/>
                            </c:when>
                            <%--<c:when test="${question.value.type == 'select'}">
                                <c:set var="type" value="选择"/>
                                <c:set var="id" value="${question.value.id}"/>
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceA}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceB}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceC}">
                                <input type="hidden" name="getChoice_${question.value.id}"
                                       value="${requestScope.cho[id].choiceD}">
                            </c:when>

                            <c:otherwise>
                                <c:set var="type" value=""/>
                            </c:otherwise>--%>
                        </c:choose>
                        <tr>
                            <td><input type="checkbox" id="checkbox_${status.index}" name="checkbox"
                                       value="${user.id}"
                                       onchange="beforeDelorUpdate()"></td>
                                <%-- <td id="showId_${user.id}">${user.id}</td>--%>
                            <td id="showLoginName_${user.id}">${user.loginName}</td>
                            <td id="showName_${user.id}">${user.name}</td>
                            <td id="showSex_${user.id}">${user.sex}</td>
                            <td id="showAge_${user.id}">${user.age}</td>
                            <td id="showRole_${user.id}">${type}</td>
                            <td id="showAddr_${user.id}">${user.address}</td>
                        </tr>
                        <%--<c:if test="${status.last}">
                            <input type="hidden" id="getId" value="${status.index + 2}">
                        </c:if>--%>
                    </c:forEach>
                </c:if>
            </table>
            <%--
                        </form>
            --%>
        </div>
    </div>
</div>
</body>
</html>
