$(init)
let id = '',
    email = '',
    phone = '',
    academy = 'none',
    major = 'none',
    className = 'none';

function init() {
    initInput();
    initSubmit();
    //初始化学院专业班级的选择信息
    $.ajax({
        type: 'GET',
        url: '/getClassInfo',
        success: function (data, textStatus, jqXHR) {
            initClassSelect(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function initInput() {
    $('.ui-form-container input').unbind().on('change, blur', e => {
        let item = e.currentTarget;
        if ($(item).hasClass('id')) {
            $(item).siblings('span').remove();
            id = $(item).val();
            if ('' === id) {
                $(item).after(`<span class="warn">*请输入校内学号或工号</span>`)
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

function initSubmit() {
    $('.submit-button').unbind().on('click', () => {
        // console.log(id, name, pwd, checkPwd, email, phone, academy, major, className);
        console.log(academy, major, className);
        $('select').css('color', 'black');
        $('span.warn').remove();
        if ("" === id) {
            $('input.id').after(`<span class="warn">*请输入校内学号或工号</span>`)
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
            // let type = "student" === identify ? 0 : 1;
            let data = {
                userId: id,
                name: name,
                // password: pwd,
                email: email,
                phone: phone,
                academy: academy,
                major: major,
                className: className,
                // type: type
            };

            $.ajax({
                type: 'POST',
                url: '/forgetPwd',
                data: JSON.stringify(data),
                contentType: 'application/json;charset=utf-8',
                success: function (data, textStatus, jqXHR) {
                    if (data.code === 200) {
                        swal('成功!', '密码重置为123456，请登陆后尽快修改!', 'success');
                        setTimeout(() => {
                            window.location = '/index';
                        }, 1000);

                    } else {
                        swal('失败!', data.description, 'error');
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

function initClassSelect(data) {
    let academy = ``,
        dataObj = [],
        displayData = [];
    //学院筛选
    data.data.forEach(ele => dataObj.push(ele.academy));
    dataObj.forEach((ele, index) => {
        if (index === dataObj.indexOf(ele)) {
            displayData.push(ele);
        }
    });
    displayData.forEach(ele => academy += `<option value="${ele}">${ele}</option>`);
    $('#academy-select').append(academy);
    academyListening(data);
}

function academyListening(data) {
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

function initMajor(data) {
    let major = `<option value="none">请选择专业</option>`,
        dataObj = [],
        displayData = [];
    //专业筛选
    data.forEach(ele => dataObj.push(ele.major));
    dataObj.forEach((ele, index) => {
        if (index === dataObj.indexOf(ele)) {
            displayData.push(ele);
        }
    });
    displayData.forEach(ele => major += `<option value="${ele}">${ele}</option>`);
    $('#major-select').html(major);
    majorListening(data);
}

function majorListening(data) {
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

function initClass(data) {
    let className = `<option value="none">请选择班级</option>`;
    data.forEach(ele => className += `<option value="${ele}">${ele}</option>`);
    $('#class-select').html(className);
    classListening();
}

function classListening() {
    $('#class-select').on('change', () => className = $('#class-select').val());
}

