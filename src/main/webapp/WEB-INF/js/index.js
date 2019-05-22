
/**
 * Created by Alander on 2017/7/30.
 */

$(() => {
    doLogin();
    doReg();
    doLogout();
    keyEvent();
    $('.yun_u2').hide()
    $('#imgVerify').unbind().on('click', () => {
        let imgVerifySrc = $('#imgVerify').attr("src");
        let index = imgVerifySrc.indexOf('?');
        imgVerifySrc = index > 0 ? imgVerifySrc.substring(0, index) : imgVerifySrc;
        $('#imgVerify').attr("src", imgVerifySrc + '?' + Math.random());
    });
    let userId = getCookie("userId");
    if (userId) {
        console.log('已登录！userId: ' + userId);
        confirmLogin();
    } else {
        console.log('未登录！');
    }
});

function confirmLogin() {
    $('.yun_u1').hide();
    $('.yun_u2').show();
    let user = JSON.parse(localStorage.user);
    let type = user.type;
    if (type === 0) {
        $('.yun_u2 .success_left').eq(0).text('学号：');
    }
    else {
        $('.yun_u2 .success_left').eq(0).text('工号： ');
    }
    $('.idNumber').text(user.userId);
    $('.userName').text(user.name);
    $('.character').text(type === 0 ? '学生' : type === 1 ? '老师' : '管理员');
}

function doLogin() {
    $('#loginSubmit').unbind().on('click', () => {
        let accountId = $('#UserName').val(),
            password = $('#Password').val(),
            ValidateCode = $('#ValidateCode').val(),
            type = $('input[name="character"]:checked').val();
        if ("student" == type) {
            type = 0;
        }
        else if ("teacher" === type) {
            type = 1;
        }
        else {
            type = 2;
        }

        let user = {
            accountId: accountId,
            password: password,
            ValidateCode: ValidateCode,
            type: type
        };
        //前端对密码进行sha512 hash
        const shaObj = new jsSHA("SHA-512", "TEXT");
        shaObj.update(user.password);
        const pwdhash = shaObj.getHash("HEX");
        user.password = pwdhash;
        $.ajax({
            type: 'POST',
            url: '/login',
            data: JSON.stringify(user),
            contentType: 'application/json;charset=utf-8',
            success: function (data, textStatus, jqXHR) {
                DATA = data;
                console.log(data)
                if (data.code === 200) {
                    delete data.user.password;
                    localStorage.setItem("user", JSON.stringify(data.user));
                }

                if (data.code !== 200) {
                    let imgVerifySrc = $('#imgVerify').attr("src");
                    let index = imgVerifySrc.indexOf('?');
                    imgVerifySrc = index > 0 ? imgVerifySrc.substring(0, index) : imgVerifySrc;
                    $('#imgVerify').attr("src", imgVerifySrc + '?' + Math.random());

                    $('#Password').val('');
                    $('#ValidateCode').val('');
                    swal('登录失败', '请重新确认您的账户和密码，并正确填写验证码', 'error');
                } else {
                    confirmLogin();
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    });
    $('#enter_space').on('click', () => {
        let type = JSON.parse(localStorage.user).type;
        if (type === 0) {
            window.location.href = "/student"
        } else if (type === 1) {
            window.location.href = "/teacher"
        } else {
            window.location.href = "/admin"
        }
    });
    $('#change_password').on('click',() => {
        window.location.href = '/resetpwd'
    })

}

function doReg() {
    $('#registerSubmit').on('click', () => {
        window.location.href = "/register";
    });
}

function doLogout() {
    $('#logout').on('click', function () {
        $.post('/logout', (resdata, status, xhr) => {
            console.log(status);
            if (status === 'success' && resdata.code === 200) {
                localStorage.clear();
                clearAllCookie();
                $('#UserName').val('');
                $('#Password').val('');
                $('#ValidateCode').val('');
                $('input[name="character"]').eq(0).attr('checked', 'checked');
                $('#imgVerify').trigger('click');
                $('.yun_u2').hide();
                $('.yun_u1').show();
            } else {
                console.log(resdata);
                console.log(xhr);
            }
        });
    })
}

//设置cookie
function setCookie(cname, cvalue, exdays) {
    let date = new Date();
    date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + date.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

//获取cookie
function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}

//清除cookie
function clearCookie(name) {
    setCookie(name, "", -1);
}

//清空cookie
function clearAllCookie() {
    let ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        c.replace(/(^\s*)|(\s*$)/g, "");
        clearCookie(c.substring(0, c.indexOf('=')));
    }
}

//测试代码
function checkCookie() {
    let user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}

// checkCookie();


//键盘事件
function keyEvent() {
    $(document).keydown(function (e) {
        var key = e.which;
        if (key === 13) {
            $('#loginSubmit').trigger('click')
        }
    })

}