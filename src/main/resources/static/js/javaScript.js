function countLetterFunction() {
    let wierszWybrany = document.getElementById("textarea1").value;
    let pisanyWiersz = document.getElementById("textarea2").value + "" + event.key;
    let c = pisanyWiersz.slice(0, pisanyWiersz.length - 2);
    let len = pisanyWiersz.length;
    let counter = document.getElementById("hiddenCounter").value;


    if (wierszWybrany.charAt(len - 1) !== event.key) {
     if (event.key === "Enter") {
         c = pisanyWiersz.slice(0,pisanyWiersz.length-5);
         counter--;
     }
        document.getElementById("textarea2").value = c;
        counter++;
        document.getElementById("hiddenCounter").value = counter;
        document.getElementById("userSummmary").value = counter;

        console.log("liter---" + event.key + "--- sie nie zgadza z--" + wierszWybrany.charAt(len - 1) + "--  które jest pod numerem " + wierszWybrany.indexOf(wierszWybrany.charAt(len - 1)));
        console.log("count length-----" + counter);
        document.getElementById("textarea2").style.backgroundColor = "red";
    } else {
        console.log("litera ---" + event.key + "----zgadza sie z " + wierszWybrany.charAt(len - 1) + " które jest pod numerem " + wierszWybrany.indexOf(wierszWybrany.charAt(len - 1)));
        document.getElementById("textarea2").style.backgroundColor = "white";
    }
}

function timeStart() {
    document.getElementById("hiddenTimer").value = new Date().getTime();
}

function changeDisplay() {
    document.getElementById("textarea2").style.visibility = "visible";
    document.getElementById("startButton").style.display = "none";
}

function summaryDisplay() {
    document.getElementById("polaTextowe").style.display = "none";
}

function timer() {
    var data = new Date();

    var day = data.getDate();
    var month = data.getMonth() + 1;
    if (month < 10) month = "0" + month;
    var year = data.getFullYear();

    var hour = data.getHours();
    if (hour < 10) hour = "0" + hour;
    var minutes = data.getMinutes();
    if (minutes < 10) minutes = "0" + minutes;
    var seconds = data.getSeconds();
    if (seconds < 10) seconds = "0" + seconds;

    document.getElementById("zegar").innerHTML = hour + ":" + minutes + ":" + seconds;

    setTimeout("timer()", 1000);
}