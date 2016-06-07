
function startTime() {
    var today = new Date();
    var hour = today.getHours();
    var min = format(today.getMinutes());
    var sec = format(today.getSeconds());
    document.getElementById('clock-__PARAGRAPH_ID__').innerHTML = hour + ":" + min + ":" + sec;
    setTimeout(startTime, 500);
}

function format(i) {
    if (i < 10) {
        i = "0" + i
    }
    return i;
}

startTime();
