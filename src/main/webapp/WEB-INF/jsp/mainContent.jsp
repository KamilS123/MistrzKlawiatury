<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/mainContent.css"/>
</head>
<body onload="timer()">
<script>
    function timer(){
        var data = new Date();

        var day = data.getDate();
        var month = data.getMonth()+1;
        if(month<10)month = "0"+month;
        var year = data.getFullYear();

        var hour = data.getHours();
        if(hour<10)hour = "0"+hour;
        var minutes = data.getMinutes();
        if(minutes<10)minutes = "0"+minutes;
        var seconds = data.getSeconds();
        if(seconds<10)seconds ="0"+seconds;

        document.getElementById("zegar").innerHTML = hour+":"+minutes+":"+seconds;

        setTimeout("timer()",1000);
    }
</script>
<div id="container">
    <div id="header">
        <div id="logo">
            <p>Mistrz Klawiatury</p>
        </div>
        <div id="zegarek">
            <p id="zegar">00:00:00</p>
        </div>
        <div style="clear: both"></div>
    </div>

    <h3>Wybrany tytul: <span style="color: red; font-size: 30px; font-weight: bold; background-color: lightslategrey; padding: 20px"><%--${tittle}--%> ${wybranyTytul} ${tittle}</span></h3>

    <div id="polaTextowe">
        <div id="wiersz">
            <textarea id="textarea1" name="tarea" placeholder="Twoj wiersz"><%--${text}--%> ${wybranyWiersz} ${text}</textarea>
        </div>
        <div id="pisanie">
            <textarea id="textarea2" name="tarea" placeholder="Pole do pisania"></textarea>
        </div>
    </div>
    <form>
        <input type="submit" value="Zakończ i zobacz wynik"/>
    </form>
</div>

</body>
</html>
