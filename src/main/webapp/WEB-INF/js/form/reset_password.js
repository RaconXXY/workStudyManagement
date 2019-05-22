$(init)
let id = '',
    pwd = '',
    npwd= '',
    checkNpwd = '';

function init() {
    initInput();
    initSubmit();
}

function initInput () {
    $('.ui-form-container input').unbind().on('change, blur', e => {
        let item = e.currentTarget;
        if ($(item).hasClass('id')) {
            $(item).siblings('span').remove();
            id = $(item).val();
            if ('' === id) {
                $(item).after(`<span class="warn">*请输入校内学号或工号</span>`)
            }
        }
        else if ($(item).hasClass('pwd')) {
            $(item).siblings('span').remove();
            pwd = $(item).val();
            if ('' === pwd) {
                $(item).after(`<span class="warn">*请输入原密码</span>`)
            }
        }
        else if ($(item).hasClass('npwd')) {
            $(item).siblings('span').remove();
            npwd = $(item).val();
            if ('' === npwd) {
                $(item).after(`<span class="warn">*请输入新密码</span>`)
            }
        }
        else if ($(item).hasClass('check-pwd')) {
            $(item).siblings('span').remove();
            checkNpwd = $(item).val();
            if ('' === checkNpwd) {
                $(item).after(`<span class="warn">*请再次输入密码</span>`)
            }
            else if (npwd !== checkNpwd) {
                $(item).after(`<span class="warn">*两次输入密码不一致</span>`)
            }
        }
    });

}

function initSubmit () {
    $('.submit-button').unbind().on('click', () => {
        // console.log(id, pwd, checkNpwd);
        // $('select').css('color', 'black');
        $('span.warn').remove();
        if ("" === id) {
            $('input.id').after(`<span class="warn">*请输入校内学号或工号</span>`)
            return;
        }
        else if ("" === pwd) {
            $('input.pwd').after(`<span class="warn">*请输入原密码</span>`)
            return;
        }
        else if ("" === npwd) {
            $('input.npwd').after(`<span class="warn">*请输入新密码</span>`)
            return;
        }
        else if ("" === checkNpwd) {
            $('input.checkNpwd').after(`<span class="warn">*请再次输入新密码</span.warn>`)
            return;
        }
        else if (npwd !== checkNpwd) {
            $('input.checkNpwd').after(`<span class="warn">*两次输入密码不一致</span.warn>`)
            return;
        }
        else {
            let data = {
                userId: id,
                oldpwd: hash(pwd),
                newpwd: hash(checkNpwd),
            };
            $.ajax({
                type: 'POST',
                url: '/resetpwd',
                data: JSON.stringify(data),
                contentType: 'application/json;charset=utf-8',
                success: function (data, textStatus, jqXHR) {
                    if(data.code===200){
                        swal('成功!','修改成功!','success');
                        setTimeout(() => {
                            window.location = '/index';
                        }, 1000);
                    }else{
                        swal('失败!',data.description,'error');
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR);
                    console.log(textStatus);
                    console.log(errorThrown);
                }
            });
        }
    });
}

function hash(str) {
    const shaObj = new jsSHA("SHA-512", "TEXT");
    shaObj.update(str);
    return shaObj.getHash("HEX");
}


