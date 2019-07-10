<%--
  Created by IntelliJ IDEA.
  User: Kamil
  Date: 2019-04-02
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/summaryPage.css">
<head>
    <title>SummaryPage</title>
</head>
<body>
<form method="post" action="/main">
<div id="summaryWindow">
    <div class="result" id="counter">${counter}</div>
    <div class="result" id="endTime">${endTime}</div>
    <input type="submit" id="link" value="Go to Menu"></input>
</div>
</form>
</body>
</html>
