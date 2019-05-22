/**
 * Created by Alander on 2017/8/2.
 */

let user = JSON.parse(localStorage.getItem("user")),
    sex = '男',
    year = '',
    month = '',
    nation = '',      //民族
    birthPlace = '',     //籍贯
    politicalStatus = '群众',
    isContinue = 1,
    isRender = 1,
    finance = '0000000',
    workAndStudy = '无',
    socialActivity = '无',
    otherFinance = '无',
    financeNumber = 0,
    reason = '';
initInfo();
initSelectListening();
initInputListening();
initSubmit();

console.log(user);

function initInfo () {
    $('.name-input').val(user.name);
    $('.academy-input').val(user.academy);
    $('.major-input').val(user.major);
    $('.class-input').val(user.className);
    $('.id-input').val(user.userId);
    // $('.phone-input').val(user.phone);
}
function initSelectListening () {
    $('.birth-input').unbind().on('change', () => {
        let dateObj = $('.birth-input').val().split('-')
        console.log(dateObj)
        year = dateObj[0];
        month = dateObj[1];

    })

    $('.stipend-face').unbind().on('change', () => {
        politicalStatus = $('.stipend-face').val();
    });

    $("input[name='stipend_sex']").unbind().on('change', (e) => {
        sex = $(e.currentTarget).val();
    })

    $("input[name='stipend_apply']").unbind().on('change', (e) => {
        isContinue = $(e.currentTarget).val() === "是" ? 1 : 0;
    })

    $("input[name='stipend_renting']").unbind().on('change', (e) => {
        isRender = $(e.currentTarget).val() === "是" ? 1 : 0;
    })

    $("input[name='imburse']").unbind().on('change', (e) => {
        finance = '';
        $("input[name=imburse]").each((index, item) => {
            finance += $(item)[0].checked ? 1 : 0;
        });
    })

}
function initInputListening () {
    $('input, textarea').on('change', (e) => {
       let value = $(e.currentTarget).val();
       if ($(e.currentTarget).hasClass('stipend_nation')) {
           nation = value;
       }
       else if ($(e.currentTarget).hasClass('birth-place')) {
           birthPlace = value;
       }
       else if ($(e.currentTarget).hasClass('work-study')) {
           workAndStudy = value;
       }
       else if ($(e.currentTarget).hasClass('social-activity')) {
           socialActivity = value;
       }
       else if ($(e.currentTarget).hasClass('other-finance')) {
           otherFinance = value;
       }
       else if ($(e.currentTarget).hasClass('admit_imburse')) {
           financeNumber = value;
       }
       else if ($(e.currentTarget).hasClass('reason')) {
           reason = value;
       }
    });
}
function initSubmit () {
    $('input.submit').unbind().on('click', () => {
        $('span.warn').remove();
       if ('' === year || '' === month) {
            $('.sel-month').parent('td').append(`<span class="warn">请选择出生年月</span>`);
            return;
       }
       else if ('' === nation) {
            $('.stipend_nation').parent('td').append(`<span class="warn">请输入民族信息</span>`);
            return;
       }
       else if ('' === birthPlace) {
           console.log('warn');
           $('.birth-place').parent('td').append(`<span class="warn">请输入籍贯信息</span>`);
           return;
       }
       else if ('' === reason) {
           console.log('warn');
           $('.reason').parent('form').append(`<span class="warn">请输入申请理由</span>`);
           return;
       }
       else {
           let date = new Date();
           let tableYear = date.getFullYear() + '-' + (parseInt(date.getFullYear()) + 1);
           let data = {
               studentId: user.userId,
               tableYear: tableYear,
               sex: sex,
               birthYear: year,
               birthMonth: month,
               nation: nation,
               politicalStatus: politicalStatus,
               birthPlace: birthPlace,
               phone: user.phone,
               isContinue: isContinue,
               isRender: isRender,
               workAndStudy: workAndStudy,
               socialActivity: socialActivity,
               finance: finance,
               otherFinance: otherFinance,
               financeNumber: financeNumber,
               reason: reason,
               teacherResult: -1,
               adminResult: -1
           };
           $.ajax({
               type: 'POST',
               url: '/admitapplytable',
               data: JSON.stringify(data),
               contentType: 'application/json;charset=utf-8',
               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   if(data.code == -200) {
                       swal("失败",data.result,"error");
                   }
                   else if (resdata.code == 200)
                   {
                       swal("成功","操作成功","success");
                       setTimeout(function(){
                           window.close();
                       },2000);

                   }
                   // downloadadmitapplytable();
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

function downloadadmitapplytable() {
    let data = {
        name: user.name,
        sex: sex,
        birthYM: year+'.'+month,
        birthPlace: birthPlace,
        nation: nation,
        politicalStatus: politicalStatus,
        academy:user.academy,
        userId:user.userId,
        major:user.major,
        className:user.className,
        phone: user.phone,
        workAndStudy: workAndStudy,
        socialActivity: socialActivity,
        financeNumber: financeNumber,
        reason: reason
    };
    console.log(data);
    /**
     * AJAX无法下载文件 所以伪装一个form
     */
    // $.ajax({
    //     type: 'POST',
    //     url: '/admitapplytablesave',
    //     data: JSON.stringify(data),
    //     contentType: 'application/json;charset=utf-8',
    //     success: function (data, textStatus, jqXHR) {
    //         console.log(data);
    //     },
    //     error: function (jqXHR, textStatus, errorThrown) {
    //         console.log(jqXHR);
    //         console.log(textStatus);
    //         console.log(errorThrown);
    //     }
    // });

    let form = $('<form id="downloadwordword" style="display:none" target="" method="post" action="/admitapplytablesave"></form>');
    $('body').append(form);
    form.append(`<input type="hidden" name="name" value=${data.name}/>`);
    form.append(`<input type="hidden" name="sex" value=${data.sex}/>`);
    form.append(`<input type="hidden" name="birthYM" value=${data.birthYM}/>`);
    form.append(`<input type="hidden" name="birthPlace" value=${data.birthPlace}/>`);
    form.append(`<input type="hidden" name="nation" value=${data.nation}/>`);
    form.append(`<input type="hidden" name="politicalStatus" value=${data.politicalStatus}/>`);
    form.append(`<input type="hidden" name="academy" value=${data.academy}/>`);
    form.append(`<input type="hidden" name="userId" value=${data.userId}/>`);
    form.append(`<input type="hidden" name="major" value=${data.major}/>`);
    form.append(`<input type="hidden" name="className" value=${data.className}/>`);
    form.append(`<input type="hidden" name="phone" value=${data.phone}/>`);
    form.append(`<input type="hidden" name="workAndStudy" value=${data.workAndStudy}/>`);
    form.append(`<input type="hidden" name="socialActivity" value=${data.socialActivity}/>`);
    form.append(`<input type="hidden" name="financeNumber" value=${data.financeNumber}/>`);
    form.append(`<input type="hidden" name="reason" value=${data.reason}/>`);
    form.submit();
    $('#downloadwordword').remove();
}
