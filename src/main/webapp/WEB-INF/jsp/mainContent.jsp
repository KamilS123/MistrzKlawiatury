<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/mainContent.css"/>
</head>
<body onload="timer()">
<script>

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

    <h3>Wybrany tytul: <span
            style="color: red; font-size: 30px; font-weight: bold; background-color: lightslategrey; padding: 20px">${wybranyTytul}${tittle}</span>
    </h3>
    <form method="post" action="summary">
        <div id="polaTextowe">
            <div id="wiersz">
                <textarea id="textarea1" name="tarea1" placeholder="Twoj wiersz">${wybranyWiersz}${text}</textarea>
            </div>
            <button type="button" id="startButton"
                    style="margin: 50px auto auto 270px; width: 150px; height: 150px; font-weight: bold"
                    onclick="timeStart(),changeDisplay()">START
            </button>
            <input type="hidden" id="hiddenTimer" name="hiddenTimer">

            <div id="pisanie">
                <textarea id="textarea2" name="tarea2" placeholder="Pole do pisania" style="visibility: hidden"
                          onkeypress="countLetterFunction()"></textarea>
                <input type="hidden" id="hiddenCounter" name="hiddenCounter">
            </div>
        </div>
        <p>${counter}${endTime}</p>
        <input type="hidden" id="userSummmary" name="userSummmary">
        <input type="submit" value="Zakończ i zobacz wynik" onclick="summaryDisplay()"/>
    </form>

</div>
<script>

</script>
</body>
<script src="js/javaScript.js"></script>
</html>
