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
    <input type="submit" id="link" value="Go to Menu">
</div>
</form>
</body>
</html>
