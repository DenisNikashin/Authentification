<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ADMIN</title>
</head>
    <body>
        <h1>Hello ADMIN!</h1>
        <a href="${pageContext.servletContext.contextPath}/views/user/CreateUser.jsp"> Add User </a>
        <table border="1">
            <tr>
                <td>Login</td>
                <td>  Email</td>
                <td> Действия </td>
            </tr>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr valign="top">
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/user/edit?id=${user.id}"> Edit </a>
                        <a href="${pageContext.servletContext.contextPath}/user/delete?id=${user.id}"> Delete </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/logout">Logout</a>
    </body>
</html>
