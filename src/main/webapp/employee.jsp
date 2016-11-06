<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              type="text/css">
</head>
<body style="padding: 25px;">
<div class="container">
        <form action="/waiter" method="post" name="newUser"
              style="max-width: 320px; margin: 0 auto; font-size: larger;">
                <h3 class="form-signin-heading" align="center">Employee:</h3>
                <div class="form-group">
                        <input type="text" readonly="readonly" name="id" title="ID" size="10"
                               value="<c:out value="${waiter.id}"/>">
                </div>
                <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" id="name" class="form-control" placeholder=""
                               name="name" value="<c:out value="${waiter.name}"/>"
                               required autofocus style="z-index: 2;">
                </div>
                <div class="form-group">
                        <label for="dob">DOB</label>
                        <input type="text" id="dob" class="form-control" placeholder=""
                               name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${waiter.dob}"/>"
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" class="form-control" placeholder=""
                               name="phone" value="<c:out value="${waiter.phone}"/>"
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <label for="position">Position</label>
                        <select id="position" name="position" class="form-control">
                                <option value="1">Manager</option>
                                <option value="2">Chef</option>
                                <option value="3">Waiter</option>
                        </select>
                </div>

                <script>document.getElementById("position").value = '${position}';</script>

                <div class="form-group">
                        <label for="salary">Salary</label>
                        <input type="text" id="salary" class="form-control" placeholder=""
                               name="salary" value="<c:out value="${waiter.salary}"/>"
                               required autofocus style="z-index: 2;">
                </div>

                <div class="form-group">
                        <button class="btn btn-primary btn-block" type="submit">Save</button>
                </div>

                <div class="form-group">
                        <div class="row">
                                <div class="col-md-6">
                                        <a class="hyperlink" href="/employees">See all</a>
                                </div>
                                <div class="col-md-6" align="right">
                                        <a class="hyperlink" href="/index.jsp">Menu</a>
                                </div>
                        </div>
                </div>
        </form>
</div>
</body>
</html>
