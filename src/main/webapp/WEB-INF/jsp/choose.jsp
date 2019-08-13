<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/choose.css"/>
</head>
<body>
<h3 id="header"><span style="color: red; font-size: 65px">Witaj w programie... ${nameLogin}</span></h3>
<div id="containerLeft">
    <div id="startingBtn">
        <form action="/mainContent" method="post">
            <div id="radioBtn">
                <p id="headerParagraph">Wybierz tekst do wyzwania</p>
                <c:forEach items="${txt}" var="userElement">
                    <div><input type="radio"  value="${userElement.getId()}" name="id" checked>${userElement.getTittle()} (${userElement.getText().length()} litery)</div>
                </c:forEach>
            </div>
            <input type="submit" value="Rozpocznij">
        </form>
    </div>
</div>

<div id="containerRight">
    <div id="rightInside">
    <p>Wklej swój tekst z którym bedziesz pracował...</p>

    <form method="post" action="/extraContent">
        <div>
            <h3>Podaj wytuł wiersza...(max 60 znakow)</h3>
            <input type="text" name="tittle" placeholder="tittle"/>
        </div>
        <div>
            <h3>Podaj tekst właściwy...(max 1000 znakow)</h3>
            <input type="text" name="text" placeholder="text"/>
        </div>
    <input id="rightBtn" type="submit" value="Wybierz i przejdz dalej">
    </form>
    </div>
</div>
<div style="clear: both"></div>


</body>
<script src="js/javaScript.js"></script>
</html>
