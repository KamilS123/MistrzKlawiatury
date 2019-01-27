<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">

<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/loginForm.css" type="text/css">
</head>
<body>
<div id="header">
    <h1>Witaj w <span style="color: red">Mistrzu Klawiatury!!!</span></h1>
</div>
<div id="logForm">
    <form method="post" action="/checkData">
        <input type="text" name="nameLogin" placeholder="Name">
        <input type="text" name="surmaneLogin" placeholder="Surname">
        <input type="password" name="passwordLogin" placeholder="Password">
        <input type="submit" value="Sign in">
    </form>

    <form method="post" action="/registry">
        <input type="submit" value="Registry">
    </form>
</div>
</body>
</html>
