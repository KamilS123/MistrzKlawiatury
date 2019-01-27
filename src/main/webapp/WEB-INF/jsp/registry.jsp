<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registry</title>
    <link rel="stylesheet" href="css/registry.css">
</head>
<body>
<h2>Please fill form to registry....</h2>
<div id="forms">
    <form action="/addUser" method="post">
        <input path="name" type="text" name="registryName" placeholder="Name"/>
        <input path="surname" type="text" name="registrySurname" placeholder="Surname"/>
        <input path="password" type="password" name="registryPassword" placeholder="Password"/>
        <input type="submit" name="registryBtn" value="Registry"/>
    </form>
        <%--<form:form method = "post" action = "/login" modelAttribute = "add">
            <table>
                <tr>
                    <td><form:label path = "username">Name</form:label></td>
                    <td><form:input path = "username" /></td>
                </tr>
                <tr>
                    <td><form:label path = "surname">Age</form:label></td>
                    <td><form:input path = "surname" /></td>
                </tr>
                <tr>
                    <td><form:label path = "password">id</form:label></td>
                    <td><form:input path = "password" /></td>
                </tr>
                <tr>
                    <td colspan = "2">
                        <input type = "submit" value = "Submit"/>
                    </td>
                </tr>
            </table>
        </form:form>--%>

    <form method="post" action="/login">
        <input type="submit" name="gotologin" value="Go back"/>
    </form>
</div>
</body>
</html>
