<%--
  Created by IntelliJ IDEA.
  User: zfz
  Date: 2018/4/19
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@page pageEncoding="utf-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.common.collect.Maps" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
    <script src="${pageContext.request.contextPath}/scripts/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/scripts/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="panel panel-info">
        <!--<form method="post" id="addForm" name="addForm" action="insert">-->
        <div class="panel-heading">
            <h4>用户修改</h4>
        </div>
        <form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/editusers">
            <div class="panel-body">
                <form:hidden path="id"/>
                <form:hidden path="loginName"/>
                <input type="hidden" name="_method" value="PUT"/>
                <div class="form-group">
                    <span>用户名</span>
                    <form:input path="loginName" cssClass="form-control" disabled="true"/>
                </div>

                <div class="form-group">
                    <span>密码</span>
                    <!--<input type="number" class="form-control" id="newId" name="newId" readonly="readonly">-->
                    <form:password path="password" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    <span>姓名</span>
                    <!--<input type="text" class="form-control" id="newTitle" name="newTitle" placeholder="题目">-->
                    <form:input path="name" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <span>性别</span>
                    <!--<%
                        Map<String, String> genders = Maps.newConcurrentMap();
                        genders.put("女", "女");
                        genders.put("男", "男");
                        request.setAttribute("genders", genders);
                        %>-->
                    <!--选择性别-->
                    <br/>
                    <form:radiobuttons path="sex" items="${genders}"/>
                </div>


                <div class="form-group">
                    <span>年龄</span>
                    <form:input path="age" cssClass="form-control"/>
                </div>
                <div class="form-group">
                    用户类型
                    <!--<%
                        Map<String, String> role = Maps.newConcurrentMap();
                        role.put("1", "管理员");
                        role.put("0", "普通用户");
                        request.setAttribute("role", role);
                        %>-->
                    <!--选择性别-->
                    <br/>
                    <form:radiobuttons path="role" items="${role}"/>
                </div>
                <div class="form-group">
                    <span>地址</span>
                    <!--<input type="text" class="form-control" id="newTitle" name="newTitle" placeholder="题目">-->
                    <form:input path="address" cssClass="form-control"/>
                </div>
            </div>
            <%-- <div class="modal-footer">
                 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
            <button type="submit" class="btn btn-primary">保存</button>
            <a href="/editusers">返回列表页</a>>
        </form:form>
    </div>

</div>
</body>
</html>