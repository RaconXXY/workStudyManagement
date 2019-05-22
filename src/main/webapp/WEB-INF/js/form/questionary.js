/**
 * Created by Alander on 2017/8/4.
 */
let user = JSON.parse(localStorage.getItem("user")),
    sex = '男',
    year = '',
    month = '',
    nation = '',      //民族
    identityCardId = '',
    startYear = '',
    startMonth = '',
    politicalStatus = '群众',
    residence = 0,
    incomeSource = '',
    incomePerMonth = -1,
    address = '',
    postcode = '',
    reason = '',
    isOrphan,               //是否孤儿 0为否 1为是
    isDeformity,            //是否残疾
    isSingleFamily,         //是否单亲
    isMartyr,               //是否烈士或优抚对象子女
    isDiffFamily,           //是否农村贫困户或城市低保户

    salaryPerYear,
    indiOperPerYear,
    assetsIncome,
    agricultureIncome,
    sidelineIncome,
    otherIncome,
    peopleNumber,
    totalIncomePerYear,
    yearIncomePerPerson,
    workPeople,

    illnessFee,
    tuition,
    accommodation,
    naturalLoss,
    other,

    familyInfo = [];//家庭情况信息
initNormalBtnListening();
initInfo();
initSubmit();

function displayWarn(obj) {
    $(obj).parent('td').append(`<span class="warn">请输入信息</span>`);
}

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

}

function initSubmit() {
    $('.final-submit').unbind().on('click', () => {
        //将家庭成员信息的表格信息转数组数据
        familyInfo = [];
        var head = $('.form_main02 form table th')
        $('.form_main02 form table tr.member-item').each(function () {
            var obj = {};
            $(this).find("td").each(function (i) {
                obj[head.eq(i).attr('data-name')] = $(this).children().eq(0).val();
            });
            obj.studentId = user.userId;
            console.log(obj)
            if (!isEmptyObject(obj)) {
                familyInfo.push(obj)
            }
        });

        $('span.warn').remove();
        sex = $('input[name="stipend_sex"]:checked').val();
        year = $('.birth-input').val().split('-')[0];
        month = $('.birth-input').val().split('-')[1];
        console.log(year, month);
        if (0 == year || 0 == month) {
            displayWarn($('.birth-month'));
            return;
        }
        nation = $('.stipend_nation').val();
        if (!nation) {
            displayWarn($('.stipend_nation'));
            return;
        }
        residence = "城镇" == $('.stipend_household:checked').val() ? 0 : 1;
        isOrphan = "是" == $('.stipend_orphan:checked').val() ? 1 : 0;
        isDeformity = "是" == $('.stipend_deformed:checked').val() ? 1 : 0;
        isSingleFamily = "是" == $('.stipend_single:checked').val() ? 1 : 0;
        isMartyr = "是" == $('.stipend_martyr:checked').val() ? 1 : 0;
        isDiffFamily = "是" == $('.stipend_basic_living:checked').val() ? 1 : 0;
        identityCardId = $('.stipend_identity').val();
        if (!identityCardId) {
            displayWarn($('.stipend_identity'));
            return;
        }
        address = $('.stipend_address').val();
        if (!address) {
            displayWarn($('.stipend_address'));
            return;
        }
        salaryPerYear = $('.salary-per-year').val();
        if (!salaryPerYear) {
            displayWarn($('.salary-per-year'));
            return;
        }
        indiOperPerYear = $('.indi-oper-year').val();
        if (!indiOperPerYear) {
            displayWarn($('.indi-oper-year'));
            return;
        }
        assetsIncome = $('.assets-income').val();
        if (!assetsIncome) {
            displayWarn($('.assets-income'));
            return;
        }
        agricultureIncome = $('.agriculture-income').val();
        if (!agricultureIncome) {
            displayWarn($('.agriculture-income'));
            return;
        }
        sidelineIncome = $('.sideline-income').val();
        if (!sidelineIncome) {
            displayWarn($('.sideline-income'));
            return;
        }
        otherIncome = $('.other-income').val();
        if (!otherIncome) {
            displayWarn($('.other-income'));
            return;
        }
        peopleNumber = $('.questionary_people').val();
        if (!peopleNumber) {
            displayWarn($('.questionary_people'));
            return;
        }
        totalIncomePerYear = $('.questionary_income_all').val();
        if (!totalIncomePerYear) {
            displayWarn($('.questionary_income_all'));
            return;
        }
        yearIncomePerPerson = $('.questionary_income_average').val();
        if (!yearIncomePerPerson) {
            displayWarn($('.questionary_income_average'));
            return;
        }
        workPeople = $('.questionary_work').val();
        if (!workPeople) {
            displayWarn($('.questionary_work'));
            return;
        }
        // console.log(salaryPerYear, indiOperPerYear,assetsIncome,agricultureIncome,sidelineIncome,otherIncome,peopleNumber,totalIncomePerYear,yearIncomePerPerson,workPeople);

        illnessFee = $('.illness-fee').val();
        if (!illnessFee) {
            displayWarn($('.illness-fee'));
            return;
        }
        tuition = $('.tuition').val();
        if (!tuition) {
            displayWarn($('.tuition'));
            return;
        }
        accommodation = $('.accommodation').val();
        if (!accommodation) {
            displayWarn($('.accommodation'));
            return;
        }
        naturalLoss = $('.natural-loss').val();
        if (!naturalLoss) {
            displayWarn($('.natural-loss'));
            return;
        }
        other = $('.other').val();
        if (!other) {
            displayWarn($('.other'));
            return;
        }
        // console.log(illnessFee, tuition, accommodation, naturalLoss, other);
        let date = new Date();
        let tableYear = date.getFullYear() + '-' + (parseInt(date.getFullYear()) + 1);
        // let familyMembers = getFamilyMembers();
        let data = {
            studentId: user.userId,
            tableYear: tableYear,
            sex: sex,
            birthYear: year,
            birthMonth: month,
            nation: nation,
            residence: residence,
            isOrphan: isOrphan,
            isDeformity: isDeformity,
            isSingleFamily: isSingleFamily,
            isMartyr: isMartyr,
            isDiffFamily: isDiffFamily,
            phone: user.phone,
            identityCardId: identityCardId,
            address: address,
            salaryPerYear: salaryPerYear,
            indiOperPerYear: indiOperPerYear,
            assetsIncome: assetsIncome,
            agricultureIncome: agricultureIncome,
            sidelineIncome: sidelineIncome,
            otherIncome: otherIncome,
            peopleNumber: peopleNumber,
            totalIncomePerYear: totalIncomePerYear,
            yearIncomePerPerson: yearIncomePerPerson,
            workPeople: workPeople,
            illnessFee: illnessFee,
            tuition: tuition,
            accommodation: accommodation,
            naturalLoss: naturalLoss,
            other: other,
            familyMember: familyInfo
        };
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/questionarytable',
            data: JSON.stringify(data),
            contentType: 'application/json;charset=utf-8',
            success: function (resdata, textStatus, jqXHR) {
                console.log("resdata: ",resdata);
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
                // downloadquestionarytable(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });

    });
}


function initNormalBtnListening() {
    $('input.addFamilyInfo').unbind().on('click', () => {
        var $table = $('.form_main02 form table');
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
// downloadquestionarytable();

function downloadquestionarytable(mydata) {
    let date = new Date();
    let num = parseInt(date.getFullYear()) - parseInt('20' + user.className.substr(0, 2));
    let arr = ['', '一', '二', '三', '四', '五', '六', '七'];
    let data = {
        academy: user.academy,
        major: user.major,
        grade: '大' + arr[num],
        name: user.name,
        sex: sex,
        birthYM: year + '年' + month + '月',
        nation: nation,
        identityCardId: mydata.identityCardId,
        address: mydata.address,
        phone: user.phone,
        salaryPerYear: mydata.salaryPerYear,
        indiOperPerYear: mydata.indiOperPerYear,
        assetsIncome: mydata.assetsIncome,
        agricultureIncome: mydata.agricultureIncome,
        sidelineIncome: mydata.sidelineIncome,
        otherIncome: mydata.otherIncome,
        peopleNumber: mydata.peopleNumber,
        totalIncomePerYear: mydata.totalIncomePerYear,
        yearIncomePerPerson: mydata.yearIncomePerPerson,
        workPeople: mydata.workPeople,
        illnessFee: mydata.illnessFee,
        tuition: mydata.tuition,
        accommodation: mydata.accommodation,
        naturalLoss: mydata.naturalLoss,
        other: mydata.other
    };
    // let data = {
    //     academy: '杭州国际服务工程学院',
    //     major: '软件工程',
    //     grade: '大三',
    //     name: '傅凯琪',
    //     sex: '男',
    //     birthYM: '1996' + '年' + '12' + '月',
    //     nation: '汉族',
    //     identityCardId: '330902199612317412',
    //     address: '一二三四一二三四一二三四一二三四',
    //     phone: '18212345678',
    //     salaryPerYear: 13213,
    //     indiOperPerYear: 12313,
    //     assetsIncome: 13213,
    //     agricultureIncome: 13213,
    //     sidelineIncome: 12312,
    //     otherIncome: 12313,
    //     peopleNumber: '3',
    //     totalIncomePerYear: 13132,
    //     yearIncomePerPerson: 12313,
    //     workPeople: 3,
    //     illnessFee: 1313,
    //     tuition: 1313,
    //     accommodation: 1233,
    //     naturalLoss: 123123,
    //     other: 1321
    // };
    //
    // let familyMembers = [
    //     {name: "2015.1", age: 'asdad', appellation: '12313', workCeremony: '1231'},
    //     {name: "2015.1", age: 'asdad', appellation: '12313', workCeremony: '1231'},
    //     {name: "2015.1", age: 'asdad', appellation: '12313', workCeremony: '1231'},
    //     {name: "2015.1", age: 'asdad', appellation: '12313', workCeremony: '1231'},
    // ];

    let familyMembers = mydata.familyMember;
    objUtil(familyMembers, data, ['name', 'age', 'appellation', 'workCeremony']);
    console.log(data);

    let form = $('<form id="downloadwordword" style="display:none" target="" method="post" action="/questionarytablesave"></form>');
    $('body').append(form);
    // form.append(`<input type="hidden" name="academy" value=${data.academy}/>`);
    // form.append(`<input type="hidden" name="major" value=${data.major}/>`);
    // form.append(`<input type="hidden" name="className" value=${data.className}/>`);
    // form.append(`<input type="hidden" name="name" value=${data.name}/>`);
    // form.append(`<input type="hidden" name="sex" value=${data.sex}/>`);
    // form.append(`<input type="hidden" name="birthYM" value=${data.birthYM}/>`);
    // form.append(`<input type="hidden" name="nation" value=${data.nation}/>`);
    // form.append(`<input type="hidden" name="identityCardId" value=${data.identityCardId}/>`);
    // form.append(`<input type="hidden" name="address" value=${data.address}/>`);
    // form.append(`<input type="hidden" name="phone" value=${data.phone}/>`);
    // form.append(`<input type="hidden" name="salaryPerYear" value=${data.salaryPerYear}/>`);
    // form.append(`<input type="hidden" name="indiOperPerYear" value=${data.indiOperPerYear}/>`);
    // form.append(`<input type="hidden" name="assetsIncome" value=${data.assetsIncome}/>`);
    // form.append(`<input type="hidden" name="agricultureIncome" value=${data.agricultureIncome}/>`);
    // form.append(`<input type="hidden" name="sidelineIncome" value=${data.sidelineIncome}/>`);
    // form.append(`<input type="hidden" name="otherIncome" value=${data.otherIncome}/>`);
    // form.append(`<input type="hidden" name="peopleNumber" value=${data.peopleNumber}/>`);
    // form.append(`<input type="hidden" name="totalIncomePerYear" value=${data.totalIncomePerYear}/>`);
    // form.append(`<input type="hidden" name="yearIncomePerPerson" value=${data.yearIncomePerPerson}/>`);
    // form.append(`<input type="hidden" name="workPeople" value=${data.workPeople}/>`);
    // form.append(`<input type="hidden" name="illnessFee" value=${data.illnessFee}/>`);
    // form.append(`<input type="hidden" name="tuition" value=${data.tuition}/>`);
    // form.append(`<input type="hidden" name="accommodation" value=${data.accommodation}/>`);
    // form.append(`<input type="hidden" name="naturalLoss" value=${data.naturalLoss}/>`);
    // form.append(`<input type="hidden" name="other" value=${data.other}/>`);
    for (let i in data) {
        let str = `<input type="hidden" name="${i}" value="${data[i]}"/>`;
        console.log(str);
        form.append(str);
    }
    form.submit();
    $('#downloadwordword').remove();
}
