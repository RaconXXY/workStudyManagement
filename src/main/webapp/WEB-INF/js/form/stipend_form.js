/**
 * Created by Alander on 2017/8/4.
 */
let user = JSON.parse(localStorage.getItem("user")),
    sex = '男',
    year = '',
    month = '',
    nation = '',      //民族
    startYear = '',
    startMonth = '',
    politicalStatus = '群众',
    identityCardId = '',
    residence = 0,
    incomeSource = '',
    incomePerMonth = -1,
    peopleNumber = -1,
    address = '',
    postcode = '',
    reason = '',

    familyInfo = [];//家庭情况信息


initInfo();
initSelectListening();
initInputListening();
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
}

function initSelectListening() {
    $('.birth-input').unbind().on('change', () => {
        let dateObj = $('.birth-input').val().split('-')
        console.log(dateObj)
        year = dateObj[0];
        month = dateObj[1];

    })

    $('.start-input').unbind().on('change', () => {
        let dateObj = $('.start-input').val().split('-')
        console.log(dateObj)
        startYear = dateObj[0];
        startMonth = dateObj[1];

    });

    $('.stipend_face').unbind().on('change', () => {
        politicalStatus = $('.stipend_face').val();
        console.log('politicalStatus', politicalStatus);
    });

    $("input[name='stipend_sex']").unbind().on('change', (e) => {
        sex = $(e.currentTarget).val();
        console.log('sex', sex);
    })

    $("input[name='stipend_household']").unbind().on('change', (e) => {
        residence = $(e.currentTarget).val() === "农村" ? 1 : 0;
        console.log("residence", residence)
    })
}

function initInputListening() {
    $('input, textarea').on('change', (e) => {
        let value = $(e.currentTarget).val();
        if ($(e.currentTarget).hasClass('stipend_nation')) {
            nation = value;
            console.log("nation", nation);
        }
        else if ($(e.currentTarget).hasClass('stipend_identity')) {
            identityCardId = value;
            console.log("identityCardId", identityCardId);
        }
        else if ($(e.currentTarget).hasClass('income-source')) {
            incomeSource = value;
            console.log("incomeSource", incomeSource);
        }
        else if ($(e.currentTarget).hasClass('income-month')) {
            incomePerMonth = value;
            console.log("incomePerMonth", incomePerMonth);
        }
        else if ($(e.currentTarget).hasClass('people-num')) {
            peopleNumber = value;
            console.log("peopleNumber", peopleNumber);
        }
        else if ($(e.currentTarget).hasClass('stipend_address')) {
            address = value;
            console.log("address", address);
        }
        else if ($(e.currentTarget).hasClass('stipend_code')) {
            postcode = value;
            console.log("postcode", postcode);
        }
        else if ($(e.currentTarget).hasClass('apply_reason')) {
            reason = value;
            console.log("reason", reason);
        }
    });
}

function initSubmit() {
    $('input.final-submit').unbind().on('click', () => {
        startMonth = 9;
        startYear = $('.start-input').val().split('-')[0];
        console.log(startYear, startMonth);
        //将家庭成员信息的表格信息转数组数据
        familyInfo = [];
        var head = $('.form_main03 form table th')
        $('.form_main03 form table tr.member-item').each(function () {
            var obj = {};
            $(this).find("td").each(function (i) {
                obj[head.eq(i).attr('data-name')] = $(this).children().eq(0).val();
            });
            if (!isEmptyObject(obj)) {
                obj.studentId = user.userId;
                familyInfo.push(obj)
            }
        });
        $('span.warn').remove();
        if ('' === year || '' === month) {
            $('.birth-month').parent('td').append(`<span class="warn">请选择出生年月</span>`);
            return;
        }
        else if ('' === startYear || '' === startMonth) {
            $('.start-month').parent('td').append(`<span class="warn">请选择入学年月</span>`);
            return;
        }
        else if (!nation || !identityCardId || !incomeSource || -1 == incomePerMonth || -1 == peopleNumber || !address || !postcode || !reason) {
            $('.final-submit').after(`<span class="warn">信息输入不完全</span>`)
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
                startYear: startYear,
                startMonth: startMonth,
                politicalStatus: politicalStatus,
                phone: user.phone,
                identityCardId: identityCardId,
                residence: residence,
                incomeSource: incomeSource,
                incomePerMonth: incomePerMonth,
                peopleNumber: peopleNumber,
                address: address,
                postcode: postcode,
                reason: reason,
                teacherResult: -1,
                adminResult: -1,
                familyMembers: familyInfo
            };
            $.ajax({
                type: 'POST',
                url: '/stipendtable',
                data: JSON.stringify(data),
                contentType: 'application/json;charset=utf-8',
                success: function (resdata, textStatus, jqXHR) {
                    // downloadstipendtable(data)

                    if(resdata.code == -200) {
                        swal("失败",resdata.result,"error");
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
        }

    });

}

function initNormalBtnListening() {
    $('input.addFamilyInfo').unbind().on('click', () => {
        var $table = $('.form_main03 form table');
        if ($table.children().length > 5) {
            alert('最多只能添加5条家庭成员信息');
            return;
        }
        if (!$table.children().length) {//没有子节点
            $table.html(`
                    <tr>
                        <th data-name="name">姓名</th>
                        <th data-name="age">年龄</th>
                        <th data-name="appellation">称谓</th>
                        <th data-name="workCeremony">工作（学习）单位</th>
                        <th data-name="health">健康情况</th>
                        <th data-name="study">当前学历（未在学请勿勾选）</th>
                    </tr>
            `)
        }
        $table.append(`
                    <tr class='member-item'>
                        <td><input type="text" name="name"></td>
                        <td><input type="text" name="age"></td>
                        <td><input type="text" name="appellation"></td>
                        <td><input type="text" name="workCeremorny"></td>
                        <td>
                            <select name="health" id="family_health">
                                <option value="0">大病/重残</option>
                                <option value="1">小病/轻残</option>
                                <option value="2" selected>健康</option>
                            </select>
                        </td>
                        <td>
                            <select name="study" id="family_study">
                                <option value="0">未在学</option>
                                <option value="1">小学</option>
                                <option value="2">初中</option>
                                <option value="3">高中</option>
                                <option value="4">大学(含研究生)</option>
                            </select>
                        </td>
                    </tr>
        `);

    })
}


// 参数是对象数组,data和字段名数组，吧对象数组的key-value分别赋值给data并补齐4或者5个
function objUtil(objarr, data, strarr) {
    const COUNT = 5;
    let sum = COUNT;
    for (let i = 0; i < objarr.length; i++) {
        sum--;
        if (sum < 0) return;
        let obj = objarr[i];
        for (let j in obj) {
            data[j + '' + (i + 1)] = obj[j];
        }
    }

    for (let i = 0; i < sum; i++) {
        for (let j in strarr) {
            data[strarr[j] + '' + (COUNT - sum + i + 1)] = '';
        }
    }
}

// 测试
// downloadstipendtable();

function downloadstipendtable(mydata) {
    let date = new Date();
    let data = {
        startYear: date.getFullYear(),
        endYear: (parseInt(date.getFullYear()) + 1),
        academy:user.academy,
        major:user.major,
        className:user.className,
        name: user.name,
        sex: sex,
        birthYM: year + '年' + month + '月',
        userId: user.userId,
        nation: nation,
        startYM: mydata.startYear + '年' + mydata.startMonth + '月',
        politicalStatus: politicalStatus,
        phone: user.phone,
        identityCardId: mydata.identityCardId,
        incomeSource: mydata.incomeSource,
        incomePerMonth: mydata.incomePerMonth,
        peopleNumber: mydata.peopleNumber,
        address: mydata.address,
        postcode: mydata.postcode,
        reason: mydata.reason,
    };

    // let data = {
    //     startYear: date.getFullYear(),
    //     endYear: (parseInt(date.getFullYear()) + 1),
    //     academy: '杭州国际服务工程学院',
    //     major: '软件工程',
    //     className: user.className,
    //     name: '傅凯琪',
    //     sex: '男',
    //     birthYM: '1996' + '年' + '12' + '月',
    //     userId: '2015210405075',
    //     nation: '汉族',
    //     startYM: '2015' + '年' + '09' + '月',
    //     politicalStatus: '共青团员',
    //     phone: '18212345678',
    //     identityCardId: '330902199612317412',
    //     incomeSource: 12321,
    //     incomePerMonth: 32131,
    //     peopleNumber: 3,
    //     address: '而我打的啥接口的话外大三大三大大娃儿',
    //     postcode: 12313,
    //     reason: '一二三四一二三四一二三四一二三四',
    // };
    //
    // let familyMembers = [
    //     {name: "XXX", age: '40', appellation: '爸爸', workCeremony: '单位'},
    //     {name: "XXX", age: '40', appellation: '妈妈', workCeremony: '单位'},
    //     {name: "XXX", age: '70', appellation: '爷爷', workCeremony: '退休'},
    //     {name: "XXX", age: '70', appellation: '奶奶', workCeremony: '退休'},
    // ];

    let familyMembers = mydata.familyMembers;
    objUtil(familyMembers, data, ['name', 'age', 'appellation', 'workCeremony']);
    console.log(data);

    let form = $('<form id="downloadwordword" style="display:none" target="" method="post" action="/stipendtablesave"></form>');
    $('body').append(form);
    // form.append(`<input type="hidden" name="startYear" value=${data.startYear}/>`);
    // form.append(`<input type="hidden" name="endYear" value=${data.endYear}/>`);
    // form.append(`<input type="hidden" name="name" value=${data.name}/>`);
    // form.append(`<input type="hidden" name="sex" value=${data.sex}/>`);
    // form.append(`<input type="hidden" name="birthYM" value=${data.birthYM}/>`);
    // form.append(`<input type="hidden" name="userId" value=${data.userId}/>`);
    // form.append(`<input type="hidden" name="nation" value=${data.nation}/>`);
    // form.append(`<input type="hidden" name="startYM" value=${data.startYM}/>`);
    // form.append(`<input type="hidden" name="politicalStatus" value=${data.politicalStatus}/>`);
    // form.append(`<input type="hidden" name="phone" value=${data.phone}/>`);
    // form.append(`<input type="hidden" name="identityCardId" value=${data.identityCardId}/>`);
    // form.append(`<input type="hidden" name="incomeSource" value=${data.incomeSource}/>`);
    // form.append(`<input type="hidden" name="incomePerMonth" value=${data.incomePerMonth}/>`);
    // form.append(`<input type="hidden" name="peopleNumber" value=${data.peopleNumber}/>`);
    // form.append(`<input type="hidden" name="address" value=${data.address}/>`);
    // form.append(`<input type="hidden" name="postcode" value=${data.postcode}/>`);
    // form.append(`<input type="hidden" name="reason" value=${data.reason}/>`);
    for (let i in data) {
        let str = `<input type="hidden" name="${i}" value="${data[i]}"/>`;
        console.log(str);
        form.append(str);
    }
    form.submit();
    $('#downloadwordword').remove();
}
