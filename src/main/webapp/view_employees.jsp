<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10/18/2016
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
        <title>Employees</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
</head>
<body>

<div class="col-md-10" align="center">
        <h3 class="form-signin-heading" align="center">Employees</h3>
                <div class="col-md-6" align="left">
                        <a class="hyperlink" href="/waiter.jsp">New Employee</a>
                </div>
        <table class="table table-bordered">
                <thead>
                <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Phone</th>
                        <th>Position</th>
                        <th>Salary</th>
                        <th>Edit</th>
                        <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.employeeList}" var="waiter">
                        <tr>
                                <td><c:out value="${waiter.id}"/></td>
                                <td><c:out value="${waiter.name}"/></td>
                                <td><c:out value="${waiter.dob}"/></td>
                                <td><c:out value="${waiter.phone}"/></td>
                                <td><c:out value="${waiter.position.name}"/></td>
                                <td><c:out value="${waiter.salary}"/></td>
                                <td><a href="waiter?action=edit&id=<c:out value="${waiter.id}"/>">Edit</a></td>
                                <td><a href="waiter?action=delete&id=<c:out value="${waiter.id}"/>">Delete</a></td>
                        </tr>
                </c:forEach>
                </tbody>
        </table>
        <div align="left">
                <form action="/employees" method="post" name="search">
                        <h3 align="left">Filter:</h3>
                        <div align="left">
                                <label for="name">Search by name: </label>
                                <input type="text" id="name" placeholder="" size="15"
                                       name="name" value="<c:out value="${waiter.name}"/>"
                                       required autofocus style="z-index: 2;">
                        </div>
                        <div class="form-group">
                                <button type="submit">Search</button>
                                <button type="button" onclick="location.href='/employees'">Reset</button>
                        </div>
                </form>
        </div>
</div>
</body>
</html>
