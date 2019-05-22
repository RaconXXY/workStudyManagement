$(init)
let id = '',
    name = '',
    pwd = '',
    checkPwd = '',
    email = '',
    phone = '',
    identify = '学生',
    academy = 'none',
    major = 'none',
    className = 'none';
function init() {
    $("#optionsRadios2").click(function () {
        $("#class-belonging").hide();
    })
    $("#optionsRadios1").click(function () {
        $("#class-belonging").show();
    });
    initInput();
    initSubmit();
    //初始化学院专业班级的选择信息
    $.ajax({
        type: 'GET',
        url: '/getClassInfo',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            initClassSelect(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
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
        else if ($(item).hasClass('name')) {
            $(item).siblings('span').remove();
            name = $(item).val();
            if ('' === name) {
                $(item).after(`<span class="warn">*请输入真实姓名</span>`)
            }
        }
        else if ($(item).hasClass('pwd')) {
            $(item).siblings('span').remove();
            pwd = $(item).val();
            if ('' === pwd) {
                $(item).after(`<span class="warn">*请输入密码</span>`)
            }
        }
        else if ($(item).hasClass('check-pwd')) {
            $(item).siblings('span').remove();
            checkPwd = $(item).val();
            if ('' === checkPwd) {
                $(item).after(`<span class="warn">*请再次输入密码</span>`)
            }
            else if (pwd !== checkPwd) {
                $(item).after(`<span class="warn">*两次输入密码不一致</span>`)
            }
        }
        else if ($(item).hasClass('e-mail')) {
            $(item).siblings('span').remove();
            email = $(item).val();
            if ('' === email) {
                $(item).after(`<span class="warn">*请输入邮箱</span>`)
            }
        }
        else if ($(item).hasClass('phone')) {
            $(item).siblings('span').remove();
            phone = $(item).val();
            if ('' === phone) {
                $(item).after(`<span class="warn">*请输入联系电话</span>`)
            }
        }
    });
    $("input[name='optionsRadios']").unbind().on('change', e => {
        identify = $("input[name='optionsRadios']:checked").val();
    })
}

function initSubmit () {
    $('.submit-button').unbind().on('click', () => {
        // console.log(id, name, pwd, checkPwd, email, phone, academy, major, className);
        console.log(academy, major, className);
        $('select').css('color', 'black');
        $('span.warn').remove();
        if ("" === id) {
            $('input.id').after(`<span class="warn">*请输入校内学号或工号</span>`)
            return;
        }
        else if ("" === name) {
            $('input.name').after(`<span class="warn">*请输入真实姓名</span>`)
            return;
        }
        else if ("" === pwd) {
            $('input.pwd').after(`<span class="warn">*请输入密码</span>`)
            return;
        }
        else if ("" === checkPwd) {
            $('input.checkPwd').after(`<span class="warn">*请再次输入密码</span.warn>`)
            return;
        }
        else if (pwd !== checkPwd) {
            $('input.checkPwd').after(`<span class="warn">*两次输入密码不一致</span.warn>`)
            return;
        }
        else if ("" === email) {
            $('input.email').after(`<span class="warn">*请输入邮箱</span.warn>`)
            return;
        }
        else if ("" === phone) {
            $('input.phone').after(`<span class="warn">*请输入联系电话</span.warn>`)
            return;
        }
        else if ("none" == academy) {
            console.log('kong')
            $('#academy-select').css("color", "red");
            return;
        }
        else if ("none" == major) {
            console.log('kong')
            $('#major-select').css("color", "red");
            return;
        }
        else if ("none" == className) {
            console.log('kong')
            $('#class-select').css("color", "red");
            return;
        }
        else {
            let type = "student" === identify ? 0 : 1;
            let data = {
                userId: id,
                name: name,
                password: pwd,
                email: email,
                phone: phone,
                academy: academy,
                major: major,
                class: className,
                type: type
            };
            //前端对密码进行sha512 hash
            const shaObj = new jsSHA("SHA-512", "TEXT");
            shaObj.update(data.password);
            const pwdhash = shaObj.getHash("HEX");
            data.password = pwdhash;
            $.ajax({
                type: 'POST',
                url: '/register',
                data: JSON.stringify(data),
                contentType: 'application/json;charset=utf-8',
                success: function (data, textStatus, jqXHR) {

                    console.log(data);
                    if(data.code === 200) {//注册成功
                        swal('注册成功','请妥善保管好自己的帐号和密码','success');
                        window.history.back(-1);
                    } else {
                        swal('注册失败','该帐号已被注册','error');
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

function initClassSelect (data) {
    let academy = ``,
        dataObj = [],
        displayData = [];
    //学院筛选
    data.data.forEach( ele => dataObj.push(ele.academy));
    dataObj.forEach( (ele, index) => {
       if (index === dataObj.indexOf(ele)) {
           displayData.push(ele);
       }
    });
    displayData.forEach( ele => academy += `<option value="${ele}">${ele}</option>`);
    $('#academy-select').append(academy);
    academyListening(data);
}

function academyListening (data) {
    $('#academy-select').on('change', () => {
       academy = $('#academy-select').val();
       let originData = [];
       data.data.forEach(ele => {
           if (ele.academy == academy) {
               let obj = new Object();
               obj.major = ele.major;
               obj.className = ele.className;
               originData.push(obj);
           }
       });
       initMajor(originData);
    });
}

function initMajor (data) {
    let major = `<option value="none">请选择专业</option>`,
        dataObj = [],
        displayData = [];
    //专业筛选
    data.forEach( ele => dataObj.push(ele.major));
    dataObj.forEach( (ele, index) => {
        if (index === dataObj.indexOf(ele)) {
            displayData.push(ele);
        }
    });
    displayData.forEach( ele => major += `<option value="${ele}">${ele}</option>`);
    $('#major-select').html(major);
    majorListening(data);
}

function majorListening (data) {
    $('#major-select').on('change', () => {
        major = $('#major-select').val();
        let originData = [];
        data.forEach(ele => {
            if (ele.major == major) {
                originData.push(ele.className);
            }
        });
        initClass(originData);
    });
}

function initClass (data) {
    let className = `<option value="none">请选择班级</option>`;
    data.forEach(ele => className += `<option value="${ele}">${ele}</option>`);
    $('#class-select').html(className);
    classListening();
}

function classListening() {
    $('#class-select').on('change', () => className = $('#class-select').val());
}

