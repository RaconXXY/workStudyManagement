/**
 * Created by Alander on 2017/8/4.
 */
let user = JSON.parse(localStorage.getItem("user")),
    sex = '男',
    year = '',
    month = '',
    nation = '',      //民族
    politicalStatus = '群众',
    residence = 0,
    incomeSource = '',
    incomePerMonth = -1,
    peopleNumber = -1,
    address = '',
    isLoan = 1,
    reason = '',
    award = [],
    help = [];

initInfo();
initSubmit();
initNormalBtnListening();

function isEmptyObject(e) {
    var t;
    for (t in e) {

        if (!e[t])
            return !0;

    }
    return !1
}

function initInfo() {
    $('.name-input').val(user.name);
    $('.academy-input').val(user.academy);
    $('.major-input').val(user.major);
    $('.class-input').val(user.className);
    $('.id-input').val(user.userId);
    $('.start-input').val(user.userId.toString().substring(0,4) + '-09');
    // $('.stipend_tel').val(user.phone);
}

function initSubmit() {

    $('.final-submit').unbind().on('click', () => {
        startMonth = 9;
        startYear = $('.start-input').val().split('-')[0];
        //将奖励和资助情况的表格信息转数组数据
        help = [];
        award = [];
        var head = $('.form_main03 form table th')
        $('.form_main03 form table tr.member-item').each(function () {
            var obj = {},
                helpObj = {};
            $(this).find("td").each(function (i) {
                if (i < 2) {
                    obj[head.eq(i).attr('data-name')] = $(this).children().eq(0).val();
                }
                else {
                    helpObj[head.eq(i).attr('data-name')] = $(this).children().eq(0).val();
                }
            });
            if (!isEmptyObject(obj)) {
                obj.studentId = user.userId;
                award.push(obj)
            }
            if (!isEmptyObject(helpObj)) {
                helpObj.studentId = user.userId;
                help.push(helpObj)
            }
        });
        console.log(award, help);
        $('span.warn').remove();
        sex = $('input[name="stipend_sex"]:checked').val();
        year = $('.birth-input').val().split('-')[0];
        month = $('.birth-input').val().split('-')[1];
        console.log(year, month)
        if (0 == year || 0 == month) {
            displayWarn($('.birth-month'));
            return;
        }
        nation = $('.stipend_nation').val();
        if (!nation) {
            displayWarn($('.stipend_nation'));
            return;
        }
        politicalStatus = $('.stipend_face').val();
        residence = $('input[name="stipend_household"]:checked').val() == "城镇" ? 0 : 1;
        incomeSource = $('.income-source').val();
        if (!incomeSource) {
            displayWarn($('.income-source'));
            return;
        }
        incomePerMonth = $('.income-month').val();
        if (!incomePerMonth) {
            displayWarn($('.income-month'));
            return;
        }
        peopleNumber = $('.people-num').val();
        if (!peopleNumber) {
            displayWarn($('.people-num'));
            return;
        }
        isLoan = "是" == $('.loan-radio:checked').val() ? 1 : 0;
        reason = $('.apply_reason').val();
        if (!reason) {
            $('.apply_reason').after(`<span class="warn">请输入信息</span>`);
            return;
        }
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
            phone: user.phone,
            residence: residence,
            incomeSource: incomeSource,
            incomePerMonth: incomePerMonth,
            peopleNumber: peopleNumber,
            isLoan: isLoan,
            reason: reason,
            teacherResult: -1,
            adminResult: -1,
            awards: award,
            helps: help
        }
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/discountfeetable',
            data: JSON.stringify(data),
            contentType: 'application/json;charset=utf-8',
            success: function (resdata, textStatus, jqXHR) {
                console.log(resdata);
                downloaddiscountfeetable(data);
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
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    });
}

function displayWarn(obj) {
    $(obj).parent('td').append(`<span class="warn">请输入信息</span>`);
}

// 参数是对象数组,data和字段名数组，吧对象数组的key-value分别赋值给data并补齐4或者5个
function objUtil(objarr, data, strarr) {
    let sum = 4;
    for (let i = 0; i < objarr.length; i++) {
        sum--;
        if (sum < 0) return;
        let obj = objarr[i];
        for (let j in obj) {
            if (j === 'awardNumber' || j === 'helpNumber')
                data[j + '' + (i + 1)] = obj[j] + '元';
            else
                data[j + '' + (i + 1)] = obj[j];
        }
    }

    for (let i = 0; i < sum; i++) {
        for (let j in strarr) {
            data[strarr[j] + '' + (4 - sum + i + 1)] = '';
        }
    }
}

// 测试
// downloaddiscountfeetable();
// let data = {};
// let awards = [{awardName: "aaa", awardNumber: 1000}, {awardName: "bbb", awardNumber: 2000}];
// let helps = [{helpName: "ccc", helpNumber: 3000}, {helpName: "ddd", helpNumber: 4000}];
// objUtil(awards, data, ["awardName", "awardNumber"]);
// objUtil(helps, data, ["helpName", "helpNumber"]);
// console.log(data);

function downloaddiscountfeetable(mydata) {
    let date = new Date();
    let data = {
        startYear: date.getFullYear(),
        endYear: (parseInt(date.getFullYear()) + 1),
        academy: user.academy,
        major: user.major,
        className: user.className,
        name: user.name,
        sex: sex,
        birthYM: year + '年' + month + '月',
        userId: user.userId,
        nation: nation,
        startYM: mydata.startYear + '年' + mydata.startMonth + '月',
        politicalStatus: politicalStatus,
        phone: user.phone,
        incomeSource: mydata.incomeSource,
        incomePerMonth: mydata.incomePerMonth,
        peopleNumber: mydata.peopleNumber,
        reason: mydata.reason,
    };

    // let data = {
    //     startYear: date.getFullYear(),
    //     endYear: (parseInt(date.getFullYear()) + 1),
    //     academy: '杭州国际服务工程学院',
    //     major: '软件工程',
    //     className: '152',
    //     name: '傅凯琪',
    //     sex: '男',
    //     birthYM: '1996' + '年' + '12' + '月',
    //     userId: '2015210405075',
    //     nation: '汉族',
    //     startYM: '2015' + '年' + '09' + '月',
    //     politicalStatus: '共青团员',
    //     phone: '18212345678',
    //     incomeSource: '一二三四',
    //     incomePerMonth: '1234',
    //     peopleNumber: '3',
    //     reason: '一二三四一二三四一二三四一二三四',
    // };
    // let awards = [{awardName: "aaa", awardNumber: 1000}, {awardName: "bbb", awardNumber: 2000}];
    // let helps = [{helpName: "ccc", helpNumber: 3000}, {helpName: "ddd", helpNumber: 4000}];

    let awards = mydata.awards;
    let helps = mydata.helps;
    objUtil(awards, data, ["awardName", "awardNumber"]);
    objUtil(helps, data, ["helpName", "helpNumber"]);

    console.log(data);

    let form = $('<form id="downloadwordword" style="display:none" target="" method="post" action="/discountfeetablesave"></form>');
    $('body').append(form);
    // form.append(`<input type="hidden" name="startYear" value=${data.startYear}/>`);
    // form.append(`<input type="hidden" name="endYear" value=${data.endYear}/>`);
    // form.append(`<input type="hidden" name="academy" value=${data.academy}/>`);
    // form.append(`<input type="hidden" name="major" value=${data.major}/>`);
    // form.append(`<input type="hidden" name="className" value=${data.className}/>`);
    // form.append(`<input type="hidden" name="name" value=${data.name}/>`);
    // form.append(`<input type="hidden" name="sex" value=${data.sex}/>`);
    // form.append(`<input type="hidden" name="birthYM" value=${data.birthYM}/>`);
    // form.append(`<input type="hidden" name="userId" value=${data.userId}/>`);
    // form.append(`<input type="hidden" name="nation" value=${data.nation}/>`);
    // form.append(`<input type="hidden" name="startYM" value=${data.startYM}/>`);
    // form.append(`<input type="hidden" name="politicalStatus" value=${data.politicalStatus}/>`);
    // form.append(`<input type="hidden" name="phone" value=${data.phone}/>`);
    // form.append(`<input type="hidden" name="incomeSource" value=${data.incomeSource}/>`);
    // form.append(`<input type="hidden" name="incomePerMonth" value=${data.incomePerMonth}/>`);
    // form.append(`<input type="hidden" name="peopleNumber" value=${data.peopleNumber}/>`);
    // form.append(`<input type="hidden" name="reason" value=${data.reason}/>`);
    // form.append(`<input type="hidden" name="awards" value=${data.awards}/>`);
    // form.append(`<input type="hidden" name="helps" value=${data.helps}/>`);
    for (let i in data) {
        let str = `<input type="hidden" name="${i}" value="${data[i]}"/>`;
        console.log(str);
        form.append(str);
    }
    form.submit();
    $('#downloadwordword').remove();
}

function initNormalBtnListening() {
    $('input.addAwardInfo').unbind().on('click', () => {
        var $table = $('.form_main03 form table');
        if ($table.children().length > 5) {
            alert('最多只能添加4条奖励资助情况信息');
            return;
        }
        if (!$table.children().length) {//没有子节点
            $table.html(`
                    <tr id="stipend_origin">
                        <td class="table_left">是否申请助学贷款（含生源地贷款）：</td>
                        <td class="table_right">
                            <input type="radio" value="是" name="loan-radio" class="loan-radio" checked="checked"/>是
                            <input type="radio" value="否" name="loan-radio" class="loan-radio"/>否
                        </td>
                    </tr>
                    <tr>
                        <th data-name="awardName">奖励项目名称</th>
                        <th data-name="awardNumber">获奖金额</th>
                        <th data-name="helpName">资助项目名称</th>
                        <th data-name="helpNumber">资助金额</th>
                    </tr>
            `)
        }
        $table.append(`
                    <tr class='member-item'>
                        <td><input type="text" name="awardName"></td>
                        <td><input type="text" name="awardNumber"></td>
                        <td><input type="text" name="helpName"></td>
                        <td><input type="text" name="helpNumber"></td>
                    </tr>
        `);
    })
}
