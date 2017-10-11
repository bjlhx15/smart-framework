<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/9
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>客户名称</td>
        <td>联系人</td>
        <td>电话</td>
        <td>邮件</td>
        <td>操作</td>
    </tr>
    <c:forEach var="item" items="${customerlist}">
        <tr>
            <td>${item.name}</td>
            <td>${item.contact}</td>
            <td>${item.telephone}</td>
            <td>${item.email}</td>
            <td>
                <a href="${base}/customer_edit?id=${item.id}">编辑</a>
                <a href="${base}/customer_delete?id=${item.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
