<!DOCTYPE html>
<%@page pageEncoding="utf-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.common.collect.Maps" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/scripts/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/scripts/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModal">
    <div class="modal-dialog" role="document">
        <!--<form method="post" id="addForm" name="addForm" action="insert">-->
        <form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/insert">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">添加题目</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <span>用户名</span>
                        <!--<input type="number" class="form-control" id="newId" name="newId" readonly="readonly">-->
                        <form:input path="loginName" cssClass="form-control"/><form:errors path="loginName" />
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
                        genders.put("1", "女");
                        genders.put("0", "男");
                        request.setAttribute("genders", genders);
                        %>-->
                        <!--选择性别-->
                        <br />
                        <form:radiobuttons path="sex" items="${genders}"/>
                        <!--<select class="form-control" id="question_type" name="question_type" onchange="loadjs()">
                            <option value="select">选择题</option>
                            <option value="tf">判断题</option>
                        </select>-->
                    </div>

                    <!--<div class="form-group" id="addSelect">
                        <label>选中单选按钮作为答案</label><br/>
                        <label><input type="radio" name="answer" value="a">
                            选项A.</label><input type="text" class="form-control" id="newA" name="newA"
                                               placeholder="选项A">
                        <label><input type="radio" name="answer" value="b">
                            选项B.</label><input type="text" class="form-control" id="newB" name="newB"
                                               placeholder="选项B">
                        <label><input type="radio" name="answer" value="c">
                            选项C.</label><input type="text" class="form-control" id="newC" name="newC"
                                               placeholder="选项C">

                        <label><input type="radio" name="answer" value="d">
                            选项D.</label><input type="text" class="form-control" id="newD" name="newD"
                                               placeholder="选项D">
                    </div>-->

                    <!--<div class="form-group" id="addTf">
                        <label>选中单选按钮作为答案</label><br/>
                        <label><input type="radio" name="answer" value="yes">
                            正确</label>
                        <label><input type="radio" name="answer" value="no">
                            错误</label>
                    </div>-->

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
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" >保存</button>
                </div>
            </div>
        </form:form>
    </div>
</div>


<%--
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="addModal">
    <div class="modal-dialog" role="document">
        <form method="post" id="updateForm" name="updateForm" action="update">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">修改题目</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <span>题号</span>
                        <!--题号自动生成，不允许修改-->
                        <input type="number" class="form-control" id="updateId" name="newId" readonly="readonly">
                    </div>

                    <div class="form-group">
                        <span>题目</span>
                        <input type="text" class="form-control" id="updateTitle" name="newTitle" placeholder="题目">
                    </div>

                    <div class="form-group">
                        题目类型
                        <!--根据题目类型显示/隐藏-->
                        <select class="form-control" id="update_question_type" name="question_type"
                                onchange="getChange_update()">
                            <option value="select">选择题</option>
                            <option value="tf">判断题</option>
                        </select>
                    </div>

                    <div class="form-group" id="updateSelect">
                        <label>选中单选按钮作为答案</label><br/>
                        <label><input type="radio" id="answer_a" name="answer" value="a">
                            选项A.</label><input type="text" class="form-control" id="updateA" name="newA"
                                               placeholder="选项A">
                        <label><input type="radio" id="answer_b" name="answer" value="b">
                            选项B.</label><input type="text" class="form-control" id="updateB" name="newB"
                                               placeholder="选项B">
                        <label><input type="radio" id="answer_c" name="answer" value="c">
                            选项C.</label><input type="text" class="form-control" id="updateC" name="newC"
                                               placeholder="选项C">

                        <label><input type="radio" id="answer_d" name="answer" value="d">
                            选项D.</label><input type="text" class="form-control" id="updateD" name="newD"
                                               placeholder="选项D">
                    </div>

                    <div class="form-group" id="updateTf">
                        <label>选中单选按钮作为答案</label><br/>
                        <label><input type="radio" id="answer_yes" name="answer" value="yes">
                            正确</label>
                        <label><input type="radio" id="answer_no" name="answer" value="no">
                            错误</label>
                    </div>

                    <div class="form-group">
                        分值
                        <input type="number" class="form-control" id="updateScore" name="score">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="subUpdate();">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>
--%>

</body>
</html>