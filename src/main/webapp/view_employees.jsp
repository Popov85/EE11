<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10/18/2016
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Employees</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="col-md-10" align="center">
        <table class="table table-bordered">
                <thead>
                <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Phone</th>
                        <th>Position</th>
                        <th>Salary</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.employeeList}" var="contact">
                        <tr>
                                <td><c:out value="${employee.ID}"/></td>
                                <td><c:out value="${employee.name}"/></td>
                                <td><c:out value="${employee.phone}"/></td>
                                <td><c:out value="${employee.position}"/></td>
                                <td><c:out value="${employee.salary}"/></td>
                        </tr>
                </c:forEach>
                </tbody>
        </table>
</div>
<div class="form-group">
        <div class="row">
                <div class="col-md-6">
                        <a class="hyperlink" href="/employee.jsp">New Employee</a>
                </div>
        </div>
</div>
</body>
</html>
