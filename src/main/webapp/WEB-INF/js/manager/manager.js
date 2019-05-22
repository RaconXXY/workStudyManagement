/**
 * Created by TengFei on 2017/7/12.
 */
let classObj = {};
let dataObj = {}; //展示数据数组
let originObj = {};  //源数组
let user = JSON.parse(localStorage.getItem("user"));
console.log(user);

//时间管理
let timeManage = {
    "admitApplyTeacher": 0,   // 励志生认定申请表 教师
    "stipendTeacher": 0,		// 国家助学金申请表 教师
    "encouragementTeacher": 0,// 国家励志奖学金申请表 教师
    "scholarshipTeacher": 0,  // 国家奖学金申请表 教师
    "discountFeeTeacher": 0,    	// 学费减免申请表 教师
    "admitApplySt": 0,   // 励志生认定申请表 学生
    "questionarySt": 0,	// 家庭情况调查表 学生
    "stipendSt": 0,		// 国家助学金申请表 学生
    "encouragementSt": 0,// 国家励志奖学金申请表 学生
    "scholarshipSt": 0,  // 国家奖学金申请表 学生
    "discountFeeSt": 0,    	// 学费减免申请表 学生
};


// 判断是否为空对象
function isEmptyObject(e) {
    var t;
    for (t in e)
        return !1;
    return !0
}
//获取所有班级信息
let getClassItems = () => {
    if(isEmptyObject(classObj)){
        console.log('before', classObj);
        $.ajax({
            url: '/getAdminClasses',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                classObj.classes = data.classInfoList;
                return createClassItems()
            }
        })
    }
    else{
        return createClassItems()
    }

}
let getTimeManageMessage = () => {
    $.ajax({
        url: '/getTimeControlInfo',
        contentType: 'application/json;charset=utf-8',
        type: 'POST',
        success: (data) => {
            console.log(data);
            if (data.code == 200) {
                timeManage = data.timeInfo;
                console.log('get time info: ', timeManage);
            }
        }
    })
}
let createClassItems = () => {
    let res = ``
    classObj.classes.forEach((val)=>{
        res += `<option value="${val.name}">${val.name}</option>`
    })
    return res
}
function addStatusSelect () {
    let filterValue = 'all',
        classValue = 'all'
    $('.status-select, .class-select').on('change', e => {
        filterValue = $('.status-select').val()
        classValue = $('.class-select').val()
        let midObj = []
        originObj.students.forEach(ele => {
            if ((filterValue === 'all' || ele.adminRes == filterValue || ele.result == filterValue)
                && (ele.class == classValue || classValue === 'all')) {
                midObj.push(ele)
            }
        })
        dataObj.students = midObj
        $('.page-travel').html(`
                <ul class="pages">
                    <li class="page"><<</li>
                    <li class="page selected">1</li>
                    <li class="page">>></li>
                </ul>
        `)
        pageInit()
    })
}

//评定页面的表单初始化
function initPdTB (middle) {
    // let res = `<form class="assess"><button class="exportExcelBtn">导出汇总表excel</button>`
    let res = `<form class="assess">`;
    if(middle) {
        res+=`<span class="status-span">评定状态筛选：</span><select name="statusSelect" class="status-select">`
        res += middle
        res += `</select>`
    }

    res+=`<span class="class-span">班级筛选：</span>
                    <select name="classSelect" class="class-select">
                        <option value="all" selected>全部</option>`

    res += getClassItems()
    res += `</select>
            <table class="record">
                        <tr>
                            <th>班级</th>
                            <th>姓名</th>
                            <th>申报材料</th>
                            <th>教评结果</th>
                            <th>管理员评定状态</th>
                            <th>评定结果</th>
                            <th>操作</th>
                        </tr>
                    </table>
                </form> `
    return res
}
//汇总管理页面的表单初始化
function initHzTB (middle, th) {
    let res = `
            <form class="assess">
                    <button type="button" class="exportExcelBtn">导出汇总表excel</button>`
    if(middle) {
        res+=`<span class="status-span">评定状态筛选：</span>
                    <select name="statusSelect" class="status-select">`
        res += middle
        res += `</select>`
    }
    res+=`<span class="class-span">班级筛选：</span>
                    <select name="classSelect" class="class-select">
                        <option value="all" selected>全部</option>`+getClassItems()+`
                    </select>
                    <table class="record">
                        <tr>`
        if(!th) {
            th = ` <th>序号</th>
               <th>学院</th>
               <th>姓名</th>
               <th>性别</th>
                <th>专业班级</th>
                <th>学号</th>
                <th>结果</th>
                <th>详细信息</th>
                <th>操作</th>`
        }
        res += th
        res += `</tr>
              </table>
              </form> `
    return res
}
//评定页面数据填充模板
function createPdTR (resultTrans, adminRes, data) {
    $('tr.item').remove()
    let pageMax = 10,
        len = data.students.length,
        pageIndex = $('.pages .page.selected').index(),
        pagelen = $('.pages .page').length - 2;
    if (pagelen < Math.ceil(len * 1.0 / pageMax)) {
        for (let i = 0; i < Math.ceil(len * 1.0 / pageMax) - 1; i++) {
            $('.page:last-child').before(`<li class="page">${$('.page:last-child').index()}</li>`)
        }
    }
    if (len == 0) {
        $('#content .record').append(`<tr class="item"><td>没有符合该条件的学生</td></tr>`)
    }
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        let student = data.students[i]
        $('#content .record').append(`<tr class="item">
                        <td>${student.class}</td>
                        <td>${student.name}</td>
                        <td>
                            <a target="_blank" href="${student.personalUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}" >个人信息 </a>&nbsp;&nbsp;&nbsp;
                            <a target="_blank" href="${student.tableUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}" > 申报材料</a>
                        </td>
                        <td>${resultTrans(student.teacherRes, 1)}</td>
                        <td class="assess-status">${resultTrans(student.adminRes, 0)}</td>
                        <td>${adminRes(student.adminRes)}</td>
                        <td><input type="button" value="提交" class="change-btn"></td>
                    </tr>`);
        // 提交评定
        let currentResult = $('.result-select').last();
        let assessStatus = $('.assess-status').last();
        $('.change-btn').last().unbind().on('click', () => {
            let changeResult = currentResult.val();
            if ("-2" === changeResult) {
                alert("请选择评定等级！")
            }
            else {
                let data = {
                    studentId: student.studentId,
                    createdYear: student.createdYear,
                    result: changeResult
                };
                $.ajax({
                    url: student.changeUrl,
                    contentType: 'application/json;charset=utf-8',
                    type: 'POST',
                    data: JSON.stringify(data),
                    success: (data) => {
                        console.log(data)
                        if (data.code == 200) {
                            dataObj.students[i].adminRes = parseInt(changeResult);
                            assessStatus.html('是');
                            if (dataObj.students[i].result) {
                                dataObj.students[i].result = 1;
                            }
                        }

                    }
                })
            }
        })
    }

}
//汇总页面数据填充模板
function createHzTR (resultTrans, data, identify) {
    $('tr.item').remove()
    let pageMax = 10,
        len = data.students.length,
        pageIndex = $('.pages .page.selected').index(),
        pagelen = $('.pages .page').length - 2;
    if (pagelen < Math.ceil(len * 1.0 / pageMax)) {

        for (let i = 0; i < Math.ceil(len * 1.0 / pageMax) - 1; i++) {

            $('.page:last-child').before(`
                    <li class="page">${$('.page:last-child').index()}</li>
                    `)
        }
    }
    if (len == 0) {
        $('#content .record').append(`<tr class="item"><td>没有符合该条件的学生</td></tr>`)
    }
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        let student = data.students[i]
        let htmlOutput = `
                       <tr class="item">
                        <td>${i + 1}</td>
                        <td>${student.institute}</td>
                        <td>${student.name}</td>
                        <td>${student.sex}</td>
                        <td>${student.class}</td>
                        <td>${student.studentId}</td>`
        if (identify) {
            htmlOutput += `<td>${student.identifyId}</td>`
        }
        htmlOutput += `<td>${resultTrans(student.result)}</td>
                       <td><a target="_blank" href="${student.tableUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}">${identify ? "信息录入" : "查看"}</a></td>`
        if (!identify) {
            htmlOutput += `<td><input type="button" value="删除" class="deleteBtn"></td>`
        }
        htmlOutput += `</tr>`
        $('#content .record').append(htmlOutput)

        $('.deleteBtn').last().unbind().on('click', (e) => {
            swal({
                title: '<h2 style="font-weight:bold;color:red">温馨提示</h2>',
                type: 'info',
                html: '<p>确定要删除该条记录吗？</p>',
                showCloseButton: true,
                showCancelButton: true,
                confirmButtonColor: '#3fc3ee',
                cancelButtonColor: 'gray',
                confirmButtonText: ' <i class="mui-icon mui-icon-trash"></i>确认',
                cancelButtonText: ' <i  class="mui-icon mui-icon-refresh"></i>取消'
            }).then(function (isConfirm) {
                if(isConfirm){
                    delItem(student.delUrl, student, i);
                }
            });

        })

    }
}

//励志生认定表点击页面填充
function navDifStuPageRefresh (data) {
    //教评结果判断
    let resultTrans = (result, type) => {
        if (type) {
            if (!result) {
                return "未通过"
            }
            else if (result === 1) {
                return "一般困难"
            }
            else if (result === 2) {
                return "困难"
            }
            else if (result === -1) {
                return "未评定"
            }
            else {
                return "特别困难"
            }
        }
        else {
            if (result !== -1) {
                return "是"
            }
            return "否"
        }

    }

    //管理员下拉评定菜单
    let adminRes = (res) => {
        let selected = `<option value="-2"></option>`
        if (res !== -1)
            selected = `<option value="-1" disabled selected>${resultTrans(res, 1)}</option>`
        return `<select name="resultSelect" class="result-select">`+
                    selected+
            `
                    <option value="0">不通过</option>
                    <option value="1">一般困难</option>
                    <option value="2">困难</option>
                    <option value="3">特别困难</option>
                </select>
                `
    }
    createPdTR(resultTrans, adminRes, data)

}
//国家助学金点击页面填充
function grantPageRefresh (data) {
    //教评结果判断
    let resultTrans = (result, type) => {
        if (type) {
            if (!result) {
                return "未通过"
            }
            else if (result === 1) {
                return "一档"
            }
            else if (result === -1) {
                return "未评定"
            }
            else {
                return "二档"
            }
        }
        else {
            if (result !== -1) {
                return "是"
            }
            return "否"
        }

    }

    //管理员下拉评定菜单
    let adminRes = (res) => {
        let selected = `<option value="-2"></option>`
        if (res !== -1)
            selected = `<option value="-1" disabled selected>${resultTrans(res, 1)}</option>`
        return `<select name="resultSelect" class="result-select">`+
            selected+
            `
                    <option value="0">不通过</option>
                    <option value="1">一档</option>
                    <option value="2">二档</option>
                </select>
                `
    }
    createPdTR(resultTrans, adminRes, data)


}
//国家励志奖学金点击页面填充
function insScholarshipPageRefresh (data) {
    //教评结果判断
    let resultTrans = (result, type) => {
        if (type) {
            if (!result) {
                return "未通过"
            }
            else if (result === -1) {
                return "未评定"
            }
            else {
                return "通过"
            }
        }
        else {
            if (result !== -1) {
                return "是"
            }
            return "否"
        }

    }

    //管理员下拉评定菜单
    let adminRes = (res) => {
        let selected = `<option value="-2"></option>`
        if (res !== -1)
            selected = `<option value="-1" disabled selected>${resultTrans(res, 1)}</option>`
        return `<select name="resultSelect" class="result-select">`+
            selected+
            `
                    <option value="0">不通过</option>
                    <option value="1">通过</option>
                </select>
                `
    }
    createPdTR(resultTrans, adminRes, data)
}
//学费减免评定页面填充
function navTuiWaiPageRefresh (data) {
    //教评结果判断
    let resultTrans = (result, type) => {
        if (type) {
            if (result === -1) {
                return "未评定"
            }
            return result.toFixed(2)
        }
        else {
            if (result !== -1) {
                return "是"
            }
            return "否"
        }

    }

    //管理员下拉评定菜单
    let adminRes = (res) => {
        let input = `<input class="result-select"></input>`
        if (res !== -1)
            input = `<input value="${resultTrans(res, 1)}" class="result-select"></input>`
        return input
    }
    createPdTR(resultTrans, adminRes, data)
}
//励志生申请表汇总点击页面填充
function navDifStuHzPageRefresh (data) {
    //结果判断
    let resultTrans = (result) => {
        if (!result) {
            return "未通过"
        }
        else if (result === -1) {
            return "未评定"
        }
        else if (result === 1) {
            return "一般困难"
        }
        else if (result === 2) {
            return "困难"
        }
        else {
            return "特别困难"
        }
    }
    createHzTR(resultTrans, data)
}
//国家助学金汇总页面填充
function grantHzPageRefresh (data) {
    //结果判断
    let resultTrans = (result) => {
        if (!result) {
            return "未通过"
        }
        else if (result === -1) {
            return "未评定"
        }
        else if (result === 1) {
            return "一档"
        }
        else {
            return "二档"
        }
    }
    createHzTR(resultTrans, data)
}
//国家励志奖学金汇总页面填充
function insScholarshipHzPageRefresh (data) {
    let resultTrans = (result) => {
        if (!result) {
            return "未通过"
        }
        else if (result === -1) {
            return "未评定"
        }
        else {
            return "通过"
        }
    }
    createHzTR(resultTrans, data)
}
//学费减免汇总页面填充
function navTuiWaiHzPageRefresh (data) {
    let resultTrans = (result, type) => {
        if (result == -1) {
            return '未评定'
        }
        return result.toFixed(2)
    }
    createHzTR(resultTrans, data)
}
//励志生管理页面填充
function navDifStuGlPageRefresh (data) {
    let resultTrans = (result, type) => {
        if (result) {
            return "已录入"
        }
        else {
            return "未录入"
        }
    }
    createHzTR(resultTrans, data, "identify")
}
//励志生库页面填充
function navDifStuKuPageRefresh (data) {
    let resultTrans = (result, type) => {
        if (result === 1) {
            return "一般困难"
        }
        else if (result === 2) {
            return "困难"
        }
        else if (result === 3) {
            return "特别困难"
        }
    }
    createHzTR(resultTrans, data)
}
//账号管理页面填充
function pageAcManRefresh(data) {
    let pageMax = 8,
        len = data.students.length,
        pageIndex = $('.pages .page.selected').index(),
        pagelen = $('.pages .page').length - 2;
    if (pagelen < Math.ceil(len * 1.0 / pageMax)) {
        for (let i = 0; i < Math.ceil(len * 1.0 / pageMax) - 1; i++) {
            $('.page:last-child').before(`
                    <li class="page">${$('.page:last-child').index()}</li>
                    `)
        }
    }
    else if (pagelen > Math.ceil(len * 1.0 / pageMax)) {
        $('.pages .page').eq(pagelen).remove()
        if (pageIndex === pagelen) {
            $('.pages .page').eq(pagelen - 1).trigger('click')
        }
    }
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        if (len === 0) break;
        let student = data.students[i]
        $('#content .record').append(`
                    <tr>
                        <td>${i + 1}</td>
                        <td>${student.idNumber}</td>
                        <td>${student.name}</td>
                        <td><a target="_blank" href="${student.tableUrl}?userId=${student.idNumber}" class="view">查看</a></td>
                        <td>
                            <input type="button" value="删除" class="deleteBtn" data-stuId="${student.idNumber}" data-id="${i}">
                            <input type="button" value="重置密码" class="resetPass" data-stuId="${student.idNumber}">
                        </td>
                        
                    </tr>
                `);
        $('.deleteBtn').last().unbind().on('click', () => {
            swal({
                title: '<h2 style="font-weight:bold;color:red">温馨提示</h2>',
                type: 'info',
                html: '<p>确定要删除该帐号吗？</p>',
                showCloseButton: true,
                showCancelButton: true,
                confirmButtonColor: '#3fc3ee',
                cancelButtonColor: 'gray',
                confirmButtonText: ' <i class="mui-icon mui-icon-trash"></i>确认',
                cancelButtonText: ' <i  class="mui-icon mui-icon-refresh"></i>取消'
            }).then(function (isConfirm) {
                if(isConfirm){
                    delItem(student.delUrl, student, i);
                }
            });

        });
        $('.resetPass').last().unbind().on('click', () => {
            swal({
                title: '<h2 style="font-weight:bold;color:red">温馨提示</h2>',
                type: 'info',
                html: '<p>确定要重置密码吗？</p>',
                showCloseButton: true,
                showCancelButton: true,
                confirmButtonColor: '#3fc3ee',
                cancelButtonColor: 'gray',
                confirmButtonText: ' <i class="mui-icon mui-icon-trash"></i>确认',
                cancelButtonText: ' <i  class="mui-icon mui-icon-refresh"></i>取消'
            }).then(function (isConfirm) {
                if(isConfirm){
                    $.ajax({
                        type: 'POST',
                        url: student.resetUrl,
                        data: JSON.stringify(student),
                        contentType: 'application/json;charset=utf-8',
                        success: function (resdata, textStatus, jqXHR) {
                            console.log(resdata);
                            if (resdata.code === 200) {
                                alert("重置密码成功");
                            } else {
                                console.log(resdata.result)
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

        })
    }
}

//页面跳转
function pageInit() {
    $('.record > tr').remove()
    let selectId = $('.nav-item.selected')[0].id
    //学费减免认定
    if (selectId === 'navTuitionWaive') navTuiWaiPageRefresh(dataObj)
    else if (selectId === 'navInspirationStudentLibrary') pageLibRefresh(dataObj)
    //励志生认定
    else if (selectId === 'navDifficultStudent') navDifStuPageRefresh(dataObj)
    //国家助学金认定
    else if (selectId === 'navNationalGrant') grantPageRefresh(dataObj)
    //国家励志奖学金认定
    else if (selectId === 'navInspirationalScholarship' || selectId === 'navNationalScholarship') insScholarshipPageRefresh(dataObj)
    //励志生认定申请汇总
    else if (selectId === 'navDifficultStudentHz') navDifStuHzPageRefresh(dataObj)
    //国家助学金汇总
    else if (selectId === 'navNationalGrantHz') grantHzPageRefresh(dataObj)
    //国家励志奖学金汇总
    else if (selectId === 'navInspirationalScholarshipHz') insScholarshipHzPageRefresh(dataObj)
    //国家奖学金汇总
    else if (selectId === 'navNationalScholarshipHz') insScholarshipHzPageRefresh(dataObj)
    //学费减免汇总
    else if (selectId === 'navTuitionWaiveHz') navTuiWaiHzPageRefresh(dataObj)
    //励志生管理
    else if (selectId === 'navDifficultStudentGl') navDifStuGlPageRefresh(dataObj)
    //励志生库
    else if (selectId === 'navDifficultStudentKu') navDifStuKuPageRefresh(dataObj)
    // //时间管理
    // else if (selectId === 'navTimeset') navTimesetPageRefresh(dataObj)
    //账号管理
    else pageAcManRefresh(dataObj)
}
function pageTravel() {
    $(document).on('click', '.page', (e) => {
        if ($(e.target).index() === 0) {
            if ($('.page.selected').index() === 1) return
            $('.page.selected').removeClass('selected').prev().addClass('selected')
        }
        else if ($(e.target).index() === $('.page:last-child').index()) {
            if ($('.page.selected').index() === $('.page:last-child').index() - 1) return
            $('.page.selected').removeClass('selected').next().addClass('selected')
        }
        else {
            $('.page.selected').removeClass('selected')
            $(e.target).addClass('selected')
        }
        pageInit()
    })
}

//侧边导航条目点击
function navListening() {
    $('.nav-list .nav-item').on('click', function () {
        $('.nav-list .nav-item.selected').removeClass('selected');
        $(this).addClass('selected');
        $('#form-location').text("所在位置：" + $(this).text());
        $('.page-travel').show()
        $('.page-travel').html(`
                <ul class="pages">
                    <li class="page"><<</li>
                    <li class="page selected">1</li>
                    <li class="page">>></li>
                </ul>
        `)
    })
}
//管理导航点击
function navGuideListening() {
    $('#navGuide').on('click', function () {
        $('#content').html(`
            <div class="guide">
                <p class="guide-title">学生资助管理系统管理操作指南</p>
                <div class="guide-context">
                    <table>
                        <tr><th colspan="5">1.评定管理</th></tr>
                        <tr>
                            <th>名称</th><th>评定时可以查看的材料</th><th>申请时间</th><th>评定说明</th><th>注意事项</th>
                        </tr>
                        <tr>
                        <td>励志生申请</td>
                        <td>
                        <p>1.杭州师范大学家庭经济困难学生认定申请表</p>
                        <p>2.杭州国际服务工程学院学生及家庭情况调查表</p>
                        <p>3.其他贫困证明材料</p>
                        </td>
                        <td>
                        <p>每年暑假开始到9月</p>
                        </td>
                        <td><ul>
                        <li>1.由民主评议小组根据申报材料，确定学生困难等级，分为特别困难，困难和一般困难和不能通过认定。</li>
                        <li>2.评议完成后由负责教师在系统中评定等级并提交。</li>
                        <li>3.由管理员确定最后的结果。</li>
                        </ul></td>
                        <td><ul>
                        <li>1.申请同学如实汇报家庭情况</li>
                        <li>2.采用民主评议确定贫困等级</li>
                        </ul></td>
                        </tr>
                        
                        <tr>
                        <td>国家助学金</td>
                        <td>
                        <p>1.国家助学金申请表</p>
                        <p>2.励志生库</p>
                        </td>
                        <td>
                        <p>每年10月</p>
                        </td>
                        <td><ul>
                        <li>1.由各班辅导员根据学生家庭困难情况和申请材料进行评定，评定结果有一档助学金，二档助学金和未通过。</li>
                        <li>2.由管理员确定最后的结果。</li>
                        </ul></td>
                        <td><ul>
                        <li>1.每学年分两次发放</li>
                        <li>2.大一就可申请，可同时申请学费减免、国家奖学金或者国家励志奖学金</li>
                        </ul></td>
                        </tr>
                        
                        <tr>
                        <td>励志奖学金</td>
                        <td>
                        <p>1.励志奖学金申请表</p>
                        <p>2.励志生库</p>
                        </td>
                        <td>
                        <p>每年10月</p>
                        </td>
                        <td><ul>
                        <li>1.由各班辅导员根据学生家庭困难情况和申请材料进行评定，评定结果有通过和未通过。</li>
                        <li>2.由管理员确定最后的结果。</li>
                        </ul></td>
                        <td><ul>
                        <li>1.大二开始申请,不同时享受国家奖学金</li>
                        <li>2.可申请学费减免和国家助学金</li>
                        </ul></td>
                        </tr>
                        
                        <tr>
                        <td>国家奖学金</td>
                        <td>
                        <p>1.国家奖学金申请表</p>
                        <p>2.获奖证书及评优材料复印件</p>
                        </td>
                        <td>
                        <p>每年10月</p>
                        </td>
                        <td><ul>
                        <li>1.由各班辅导员根据学生评奖评优情况和申请材料进行评定，确定参与答辩的候选。</li>
                        <li>2.通过国家奖学金答辩会确定获奖人，由管理员在系统中进行最后评定。</li>
                        </ul></td>
                        <td><ul>
                        <li>1.大二开始申请；不同时享受励志奖学金</li>
                        <li>2.可申请学费减免和国家助学金</li>
                        </ul></td>
                        </tr>
                        
                        <tr>
                        <td>学费减免</td>
                        <td>
                        <p>1.学费减免申请表</p>
                        <p>2.励志生库</p>
                        </td>
                        <td>
                        <p>每年10月</p>
                        <p>(集中申请)</p>
                        </td>
                        <td><ul>
                        <li>1.由各班辅导员根据学生家庭困难情况和申请材料进行评定，评定金额一般在500-3000之间，总金额由学院所给经费决定。</li>
                        <li>2.由管理员确定最后的减免金额。</li>
                        </ul></td>
                        <td><ul>
                        <li>1.可同时申请国家助学金、国家奖学金或者国家励志奖学金</li>
                        <li>2.有集中申请和临时申请两种方式，临时申请覆盖整个学习期间</li>
                        </ul></td>
                        </tr>
                        
                        <tr class="table2-tr"><th colspan="5">2.汇总管理</th></tr>
                        <tr class="table2-tr"><th colspan="3">名称</th><th colspan="2">操作</th></tr>
                        <tr class="table2-tr">
                            <td rowspan="5">申请汇总</td>
                            <td colspan="2">励志生认定申请汇总</td>
                            <td colspan="3"><a href="###">查看励志生申请结果</a></td>
                        </tr>
                        <tr class="table2-tr">
                            <td colspan="2">国家助学金申请汇总</td>
                            <td colspan="3"><a href="###">查看并按一档和二档分布导出汇总表</a></td>
                        </tr>
                        <tr class="table2-tr">
                            <td colspan="2">励志奖学金申请汇总</td>
                            <td colspan="3"><a href="###">查看并导出汇总表</a></td>
                        </tr>
                        <tr class="table2-tr">
                            <td colspan="2">国家奖学金申请汇总</td>
                            <td colspan="3"><a href="###">查看并导出汇总表</a></td>
                        </tr>
                        <tr class="table2-tr">
                            <td colspan="2">学费减免申请汇总</td>
                            <td colspan="3"><a href="###">查看并导出汇总表</a></td>
                        </tr>
                        
                        <tr class="table2-tr">
                            <td rowspan="2">励志生信息</td>
                            <td colspan="2">励志生信息管理</td>
                            <td colspan="3"><a href="###">修改励志生库的内容</a></td>
                        </tr>
                        <tr class="table2-tr">
                            <td colspan="2">励志生库</td>
                            <td colspan="3"><a href="###">查看并导出励志生库</a></td>
                        </tr>
                        
                        <tr class="table2-tr"><td colspan="3">账号管理</td><td colspan="2"><a href="###">对注册账号进行管理</a></td></tr>
                    </table>
                </div>
             </div>      
        `)
        $('.page-travel').hide()
    })
}

function refreshSwitch() {
    if (timeManage.admitApplyTeacher) {
        $("[name='tea-diff']").bootstrapSwitch('state', true);
    } else {
        $("[name='tea-diff']").bootstrapSwitch('state', false);
    }

    if (timeManage.stipendTeacher) {
        $("[name='tea-help-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='tea-help-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.encouragementTeacher) {
        $("[name='tea-diff-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='tea-diff-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.scholarshipTeacher) {
        $("[name='tea-country-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='tea-country-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.discountFeeTeacher) {
        $("[name='tea-disfee']").bootstrapSwitch('state', true);
    } else {
        $("[name='tea-disfee']").bootstrapSwitch('state', false);
    }

    if (timeManage.admitApplySt) {
        $("[name='stu-diff']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-diff']").bootstrapSwitch('state', false);
    }

    if (timeManage.questionarySt) {
        $("[name='stu-family']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-family']").bootstrapSwitch('state', false);
    }

    if (timeManage.stipendSt) {
        $("[name='stu-help-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-help-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.encouragementSt) {
        $("[name='stu-diff-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-diff-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.scholarshipSt) {
        $("[name='stu-country-enco']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-country-enco']").bootstrapSwitch('state', false);
    }

    if (timeManage.discountFeeSt) {
        $("[name='stu-disfee']").bootstrapSwitch('state', true);
    } else {
        $("[name='stu-disfee']").bootstrapSwitch('state', false);
    }

}
//时间管理点击
function navTimesetListening() {
    $('#navTimeset').on('click', function () {
        $('#content').html(`

        <table class="table table-bordered">
         <center><h4><strong>学生端</strong></h4></center>
        <thead>
        <tr>
            <th>家庭情况调查通道</th>
            <th>励志生认定通道</th>
            <th>助学金通道</th>
            <th>国家奖学金通道</th>
            <th>励志奖学金通道</th>
            <th>学费减免通道</th>
        </tr>
        </thead>
        <tbody>
        <tr>
           <td>
              <div class="switch">
                   <input type="checkbox" name="stu-family" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="stu-diff" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="stu-help-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="stu-country-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="stu-diff-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="stu-disfee" />
              </div>
          </td>
        </tr>
        </tbody>
    </table>
         <br>
      <table class="table table-bordered ">
         <center><h4><strong>教师端</strong></h4></center>
        <thead>
        <tr>
            
            <th>励志生认定通道</th>
            <th>助学金通道</th>
            <th>国家奖学金通道</th>
            <th>励志奖学金通道</th>
            <th>学费减免通道</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          
          <td>
              <div class="switch">
                   <input type="checkbox" name="tea-diff" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="tea-help-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="tea-country-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="tea-diff-enco" />
              </div>
          </td>
          <td>
              <div class="switch">
                   <input type="checkbox" name="tea-disfee" />
              </div>
          </td>
        </tr>
        </tbody>
    </table>
        `);

        refreshSwitch();
        $('.page-travel').hide();
        $("[name='stu-family']").on('switchChange.bootstrapSwitch', function (e, state) {
            if(state==true){
                timeManage.questionarySt = 1;
            }else{
                timeManage.questionarySt = 0;
            }
            sendTimeManageMessage();
        });

        $("[name='stu-diff']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.admitApplySt = 1;
                }else{
                    timeManage.admitApplySt = 0;
                }
                sendTimeManageMessage();
        });

        $("[name='stu-diff-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.encouragementSt = 1;
                }else{
                    timeManage.encouragementSt = 0;
                }
                sendTimeManageMessage();
        });

        $("[name='stu-help-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.stipendSt = 1;
                }else{
                    timeManage.stipendSt = 0;
                }
                sendTimeManageMessage();

        });
        $("[name='stu-country-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.scholarshipSt = 1;
                }else{
                    timeManage.scholarshipSt = 0;
                }
                sendTimeManageMessage();

        });
        $("[name='stu-disfee']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.discountFeeSt = 1;
                }else{
                    timeManage.discountFeeSt = 0;
                }
                sendTimeManageMessage();


        });

        $("[name='tea-diff']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.admitApplyTeacher = 1;
                }else{
                    timeManage.admitApplyTeacher = 0;
                }
                sendTimeManageMessage();

        });

        $("[name='tea-diff-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.encouragementTeacher = 1;
                }else{
                    timeManage.encouragementTeacher = 0;
                }
                sendTimeManageMessage();

        });
        $("[name='tea-disfee']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.discountFeeTeacher = 1;
                }else{
                    timeManage.discountFeeTeacher = 0;
                }
                sendTimeManageMessage();

        });
        $("[name='tea-help-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.stipendTeacher = 1;
                }else{
                    timeManage.stipendTeacher = 0;
                }
                sendTimeManageMessage();

        });
        $("[name='tea-country-enco']").on('switchChange.bootstrapSwitch', function (e, state) {
                if(state==true){
                    timeManage.scholarshipTeacher = 1;
                }else{
                    timeManage.scholarshipTeacher = 0;
                }
                sendTimeManageMessage();


        });
        function sendTimeManageMessage() {
            console.log(timeManage);
            $.ajax({
                url: '/timeControl',
                contentType: 'application/json;charset=utf-8',
                type: 'POST',
                data: JSON.stringify(timeManage),
                dataType: 'json',
                success: (data) => {
                    console.log(data);
                    if (data.code == 200) {
                        swal("成功","操作成功","success");
                    } else {
                        swal("失败","操作失败","error");
                    }
                }
            })
        }
    });

}

//励志生认定表点击
function navDifStuListening() {
    $('#navDifficultStudent').on('click', () => {
        let middle = `  <option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">一般困难</option>
                        <option value="2">困难</option>
                        <option value="3">特别困难</option>`;
        $('#content').html(initPdTB(middle))

        $.ajax({
            url: '/getAdminAdmitApplySts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavFamilyTableDetail';
                    item.tableUrl = '/stNavInspirationTableDetail';
                    item.changeUrl = '/changeAdminAdmitApplySt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navDifStuPageRefresh(dataObj);
            }
        })
    })
}
//国家助学金点击
function navNationalGrant() {
    $('#navNationalGrant').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">一档</option>
                        <option value="2">二档</option>
                        <option value="0">未通过</option>`
        $('#content').html(initPdTB(middle))

        $.ajax({
            url: '/getAdminStipendSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavInspirationTableDetail';
                    item.changeUrl = '/changeAdminStipendSt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                grantPageRefresh(dataObj);
            }
        })
        // $.ajax({
        //     url: '/data/navNationalGrant.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         grantPageRefresh(data)
        //     }
        // })
    })
}
//国家励志奖学金 和 国家奖学金 点击
function insScholarshipListening() {
    $('#navInspirationalScholarship, #navNationalScholarship').on('click', (e) => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">通过</option>
                        <option value="0">未通过</option>`
        $('#content').html(initPdTB(middle))
        let checkUrl = '',
            personalUrl = '',
            tableUrl = '',
            changeUrl = '';

        if (e.currentTarget.id === 'navInspirationalScholarship') {  // 国家励志奖学金
            checkUrl = '/getAdminEncouragementSts';
            personalUrl = '/stNavInspirationTableDetail';
            tableUrl = '/stNavInsScholarshipTableDetail';
            changeUrl = '/changeAdminEncouragementSt'
        }
        else {  // 国家奖学金
            checkUrl = '/getAdminScholarshipSts';
            personalUrl = '/stNavInspirationTableDetail';
            tableUrl = '/stNavNationalScholarshipTableDetail';
            changeUrl = '/changeAdminScholarshipSt'
        }

        $.ajax({
            url: checkUrl,
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = personalUrl;
                    item.tableUrl = tableUrl;
                    item.changeUrl = changeUrl;
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                insScholarshipPageRefresh(dataObj);
            }
        })
    })
}
//学费减免点击
function navTuitionWaiveListening() {
    $('#navTuitionWaive').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">已评定</option>`
        $('#content').html(initPdTB(middle))

        $.ajax({
            url: '/getAdminDiscountFeeSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavTuitionTableDetail';
                    item.changeUrl = '/changeAdminDiscountFeeSt';
                    item.result = item.adminRes == -1 ? -1 : 1;
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navTuiWaiPageRefresh(dataObj);
            }
        })

        // $.ajax({
        //     url: '/data/navTuitionWaive.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         originObj.students.forEach(stu => {
        //             stu.result = stu.adminRes == -1 ? 0 : 1
        //         })
        //         dataObj.students = originObj.students
        //
        //         addStatusSelect()
        //         navTuiWaiPageRefresh(data)
        //     }
        // })
    })

}

//励志生认定汇总点击
function navDifStuHzListening () {
    $('#navDifficultStudentHz').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">一般困难</option>
                        <option value="2">困难</option>
                        <option value="3">特别困难</option>`
        $('#content').html(initHzTB(middle));
        $('.exportExcelBtn').hide();

        $.ajax({
            url: '/getAdminAdmitApplyHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stNavInspirationTableDetail';
                    item.delUrl = '/delAdminAdmitApply';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navDifStuHzPageRefresh(dataObj);
            }
        })

    })
}
//国家助学金申请汇总点击
function navNationalGrantHzListening () {
    $('#navNationalGrantHz').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">一档</option>
                        <option value="2">二档</option>
                        <option value="0">未通过</option>`
        $('#content').html(initHzTB(middle));


        $('.exportExcelBtn').on('click', () => {
            window.location.href = '/stipendtablesaveExcel'
        })

        $.ajax({
            url: '/getStipendHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stNavGrantTableDetail';
                    item.delUrl = '/delAdminStipend'
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                grantHzPageRefresh(dataObj);
            }
        });

        // $.ajax({
        //     url: '/data/navNationalGrantHZ.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         grantHzPageRefresh(data)
        //     }
        // })
    })
}
//国家励志奖学金汇总点击
function insScholarshipHzListening () {
    $('#navInspirationalScholarshipHz').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">通过</option>
                        <option value="0">未通过</option>`;
        $('#content').html(initHzTB(middle));
        $('.exportExcelBtn').on('click', () => {
            window.location.href = '/encouragementtablesaveExcel'
        })
        $.ajax({
            url: '/getEncouragementHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stNavInsScholarshipTableDetail';
                    item.delUrl = '/delAdminEncouragement'
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                insScholarshipHzPageRefresh(dataObj);
            }
        });


        // $.ajax({
        //     url: '/data/insScholarshipHZ.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         insScholarshipHzPageRefresh(data)
        //     }
        // })
    })
}
//国家奖学金汇总点击
function scholarshipHzListening () {
    $('#navNationalScholarshipHz').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">通过</option>
                        <option value="0">未通过</option>`
        $('#content').html(initHzTB(middle));

        $('.exportExcelBtn').on('click', () => {
            window.location.href = '/scholarshiptablesaveExcel'
        })
        $.ajax({
            url: '/getScholarshipHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stNavNationalScholarshipTableDetail';
                    item.delUrl = '/delAdminScholarship'
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                insScholarshipHzPageRefresh(dataObj);
            }
        });

        // $.ajax({
        //     url: '/data/insScholarshipHZ.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         insScholarshipHzPageRefresh(data)
        //     }
        // })
    })
}
//学费减免汇总点击
function navTuitionWaiveHzListening () {
    $('#navTuitionWaiveHz').on('click', () => {
        $('#content').html(initHzTB());
        $('.exportExcelBtn').on('click', () => {
            window.location.href = '/discountfeetablesaveExcel'
        })
        $.ajax({
            url: '/getDiscountFeeHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stNavTuitionTableDetail';
                    item.delUrl = '/delAdminDiscountFee'
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navTuiWaiHzPageRefresh(dataObj);
            }
        });

        // $.ajax({
        //     url: '/data/navTuitionWaiveHZ.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         navTuiWaiHzPageRefresh(data)
        //     }
        // })
    })
}
//励志生信息管理点击
function navDifStuGlListening () {
    $('#navDifficultStudentGl').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="0">未录入</option>
                        <option value="1">已录入</option>`
        let th = ` <th>序号</th>
               <th>学院</th>
               <th>姓名</th>
               <th>性别</th>
                <th>专业班级</th>
                <th>学号</th>
                <th>身份证号</th>
                <th>是否已录入</th>
                <th>操作</th>`
        $('#content').html(initHzTB(middle, th));
        $('.exportExcelBtn').hide();
        $.ajax({
            url: '/getStuLibSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stuLibOperate';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navDifStuGlPageRefresh(dataObj);
            }
        });
        // $.ajax({
        //     url: '/data/navDifStuGL.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         dataObj.students = data.students
        //         addStatusSelect()
        //         navDifStuGlPageRefresh(data)
        //     }
        // })
    })
}
//励志生库点击
function navDifStuKuListening () {
    $('#navDifficultStudentKu').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="1">一般困难</option>
                        <option value="2">困难</option>
                        <option value="3">特别困难</option>`
        let th = ` <th>序号</th>
               <th>学院</th>
               <th>姓名</th>
               <th>性别</th>
                <th>专业班级</th>
                <th>学号</th>
                <th>困难等级</th>
                <th>详细信息</th>
                <th>操作</th>`
        $('#content').html(initHzTB(middle, th));
        $('.exportExcelBtn').on('click', () => {
            window.location.href = '/studentlibtablesaveExcel'
        })
        $.ajax({
            url: '/getAdmitApplyHZSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stLibDetail';
                    item.delUrl = '/delAdminAdmitApply'
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                navDifStuKuPageRefresh(dataObj);
            }
        });
    })
}
//账户管理点击
function navAccountManageListening() {
    $('#navAccountManage').on('click', () => {
        $('#content').html(`
            <form class="account">
                <table class="record">
                    <tr>
                        <th>序号</th>
                        <th>学号(工号)</th>
                        <th>姓名</th>
                        <th>帐号详细信息</th>
                        <th>操作</th>
                    </tr>
                </table>
                <input type="button" class="add-account" value="新增用户">
            </form>
        `)


        $.ajax({
            url: '/getAdmitAccountSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/userDetail';
                    item.delUrl = '/delAdminUser';
                    item.resetUrl = '/resetUserPwd';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageAcManRefresh(dataObj);
            }
        });
    })
}



function delItem(url, item, i) {
    $.ajax({
        type: 'POST',
        url: url,
        data: JSON.stringify(item),
        contentType: 'application/json;charset=utf-8',
        success: function (resdata, textStatus, jqXHR) {
            console.log(resdata);
            if (resdata.code === 200) {
                dataObj.students.splice(i, 1);
                pageInit();
            } else {
                console.log(resdata.result)
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}
//设置cookie
function setCookie(cname, cvalue, exdays) {
    let date = new Date();
    date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + date.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
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
function exitEventBind(){
    $('.exit').on('click',function () {
        localStorage.clear();
        clearAllCookie();
    })
}

let init = () => {
    //初始化班级信息
    getClassItems();
    getTimeManageMessage();
    navListening();
    navGuideListening();
    navDifStuListening();
    navNationalGrant();
    insScholarshipListening();
    pageTravel();
    navTuitionWaiveListening();
    navDifStuHzListening ();
    navNationalGrantHzListening ();
    insScholarshipHzListening ();
    scholarshipHzListening ();
    navTuitionWaiveHzListening ();
    navDifStuGlListening ();
    navDifStuKuListening ();

    navTimesetListening();

    navAccountManageListening();
    exitEventBind();
    // $('#navGuide').trigger('click');
    // $('#navDifficultStudent').trigger('click');
    // $('#navTuitionWaive').trigger('click');
    $('#navGuide').trigger('click');
    $('.username').append(`${user.name}`);
}
init()