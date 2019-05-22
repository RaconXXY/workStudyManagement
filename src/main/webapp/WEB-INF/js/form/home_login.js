function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}
function randomColor(min, max) {
    var _r = randomNum(min, max);
    var _g = randomNum(min, max);
    var _b = randomNum(min, max);
    return "rgb(" + _r + "," + _g + "," + _b + ")";
}
document.getElementById("mycanvas").onclick = function (e) {
    e.preventDefault();
    realcode = drawPic();
};
function drawPic() {
    var $canvas = document.getElementById("mycanvas");
    var _str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    var _picTxt = "";
    var _num = 4;
    var _width = $canvas.width;
    var _height = $canvas.height;
    var ctx = $canvas.getContext("2d");
    ctx.textBaseline = "bottom";
    ctx.fillStyle = randomColor(180, 240);
    ctx.fillRect(0, 0, _width, _height);
    for (var i = 0; i < _num; i++) {
        var x = (_width - 10) / _num * i + 10;
        var y = randomNum(_height / 2, _height);
        var deg = randomNum(-45, 45);
        var txt = _str[randomNum(0, _str.length)];
        _picTxt += txt;
        ctx.fillStyle = randomColor(10, 100);
        ctx.font = randomNum(70, 140) + "px SimHei";
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI / 180);
        ctx.fillText(txt, 0, 0);
        ctx.rotate(-deg * Math.PI / 180);
        ctx.translate(-x, -y);
    }
    for (var i = 0; i < _num; i++) {
        ctx.strokeStyle = randomColor(90, 180);
        ctx.beginPath();
        ctx.moveTo(randomNum(0, _width), randomNum(0, _height));
        ctx.lineTo(randomNum(0, _width), randomNum(0, _height));
        ctx.stroke();
    }
    for (var i = 0; i < _num * 10; i++) {
        ctx.fillStyle = randomColor(0, 255);
        ctx.beginPath();
        ctx.arc(randomNum(0, _width), randomNum(0, _height), 1, 0, 2 * Math.PI);
        ctx.fill();
    }
    return _picTxt;
}

var realcode = drawPic();

$("#login").click(function () {
    var input = document.getElementById("code");
    var name = input.value;
    realcode = realcode.toLowerCase();
    name = name.toLowerCase();
    if (realcode == name) {
        window.location.href = 'stipend_form.html';//后台.html
        console.log(name);
    }
    else {
        document.getElementById('code').value = "";
        // document.getElementById('code').placeholder = "输入错误！请重新输入";
        alert("验证码输入错误！请重新输入！");
        console.log(name);
        realcode = drawPic();
    }
});