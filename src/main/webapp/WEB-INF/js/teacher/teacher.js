/**
 * Created by TengFei on 2017/7/12.
 */
let classObj = {};
let dataObj = {}; //展示数据数组
let originObj = {};  //源数组
let user = JSON.parse(localStorage.getItem("user"));
console.log(user);


// 判断是否为空对象
function isEmptyObject(e) {
    var t;
    for (t in e)
        return !1;
    return !0
}

function addStatusSelect () {
    let filterValue = 'all',
        classValue = 'all';
    $('.status-select, .class-select').on('change', e => {
        filterValue = $('.status-select').val();
        classValue = $('.class-select').val();
        let midObj = [];
        originObj.students.forEach(ele => {
            if ((filterValue === 'all' || ele.result == filterValue || ele.already == filterValue)
                && (ele.className == classValue || classValue === 'all')) {
                midObj.push(ele);
            }
        });
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

//获取教师对应的班级信息
let getClassItems = () => {
    if(isEmptyObject(classObj)){
        console.log('before', classObj);
        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherClasses',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
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
let createClassItems = () => {
    let res = ``;
    classObj.classes.forEach((val, index)=>{
        res += `<option value="${val.name}">${val.name}</option>`
    });
    return res
}

//页面的表单初始化
function initTB (middle) {
    let res = `<form class="assess">`
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
                            <th>评定状态</th>
                            <th>教师评定结果</th>
                            <th>操作</th>
                        </tr>
                    </table>
                </form> `
    return res
}
function createTR (resultTrans, data) {
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
        $('#content .record').append(`<tr class="items"><td>没有符合该条件的学生</td></tr>`)
    }
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        let student = data.students[i]
        $('#content .record').append(`
                    <tr class="items">
                        <td>${student.className}</td>
                        <td>${student.name}</td>
                        <td>
                            <a target="_blank" href="${student.personalUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}" class="view">个人信息</a>
                            <a target="_blank" href="${student.tableUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}" class="view">申报材料</a>
                        </td>
                        <td class="assess-status">
                            ${statusTrans(student.result)}
                        </td>
                        <td>${resultTrans(student.result)}</td>
                        <td>${btnTrans(student.assessStatus)}</td>
                    </tr>`
        );

        // 提交评定
        let currentResult = $('.result-select').last();
        let assessStatus = $('.assess-status').last();
        $('.submit').last().unbind().on('click', (e) => {
            let changeResult = currentResult.val();
            if ("result" === changeResult) {
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
                        if(data.code === -200){
                            swal('错误!',data.description,'error');
                        }
                        if (data.code == 200) {
                            console.log(data)
                            dataObj.students[i].assessStatus = 1;
                            dataObj.students[i].result = parseInt(changeResult);
                            if (dataObj.students[i].already) {
                                dataObj.students[i].already = 1;
                            }
                            assessStatus.html('是');
                        }

                    }
                })
            }
        })
    }
}

//模板分块
let statusTrans = (data) => {
    if (data != -1) {
        return '是'
    }
    else return '否'
}
let btnTrans = (result) => {
        return `<button type="button" class="submit">提交</button>`
}

//励志生认定模板
let pageRefresh = (data) => {
    let resultTrans = (result) => {
        let res = `<select name="resultSelect" class="result-select">`
        if (result != -1) {
            let tmp = '未通过'
            if (result == 1) {
                tmp = '一般困难'
            }
            else if (result == 2) {
                tmp = '困难'
            }
            else if (result == 3) {
                tmp = '特别困难'
            }
            res += `<option value="result" disabled selected>${tmp}</option>`
        }
        else {
            res += `<option value="result" disabled="" selected>无</option>`
        }
        res += `<option value="0">未通过</option>
                    <option value="1">一般困难</option>
                    <option value="2">困难</option>
                    <option value="3">特别困难</option>
                </select>`
            return res

    }
    createTR(resultTrans, data);

}
//学费减免模板
let pageReduceRefresh = (data) => {
    let resultTrans = (result) => {
        if (result != -1) {
            return `<input class="result-select" value="${result.toFixed(2)}">`
        }
        else {
            return `<input class="result-select">`
        }
    }
    createTR(resultTrans, data)
}
//励志生库模板
let pageLibRefresh = (data) => {
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
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        let student = data.students[i]
        $('#content .record').append(`
                    <tr class="items">
                        <td>${i + 1}</td>
                        <td>${student.institute}</td>
                        <td>${student.name}</td>
                        <td>${student.gender}</td>
                        <td>${student.className}</td>                   
                        <td>${student.studentId}</td>                   
                        <td><a target="_blank" href="${student.tableUrl}?studentId=${student.studentId}&tableYear=${student.createdYear}" class="view">查看</a></td>
                    </tr>
                `)
    }
}
//国家助学金模板
let pagenavNationalGrantRefresh = (data) => {
    let resultTrans = (result) => {
        let res = `<select name="resultSelect" class="result-select">`
        if (result != -1) {
            let tmp = '未通过'
            if (result == 1) {
                tmp = '一档'
            }
            else if (result == 2) {
                tmp = '二档'
            }
            res += `<option value="result" disabled selected>${tmp}</option>`
        }
        else {
            res += `<option value="result" disabled selected>无</option>`
        }
        res += `<option value="0">未通过</option>
                    <option value="1">一档</option>
                    <option value="2">二档</option>
                </select>`
        return res
    }
    createTR(resultTrans, data);
}
//励志奖学金模板
let pageNavInspirationalScholarshipRefresh = (data, personalUrl, tableUrl, changeUrl ) => {
    let resultTrans = (result) => {
        let res = `<select name="resultSelect" class="result-select">`
        if (result != -1) {
            let tmp = '未通过'
            if (result == 1) {
                tmp = '通过'
            }
            res += `<option value="result" disabled selected>${tmp}</option>`
        }
        else {
            res += `<option value="result" disabled selected>无</option>`
        }
        res += `<option value="0">未通过</option>
                    <option value="1">通过</option>
                </select>`
        return res
    }
    createTR(resultTrans, data, personalUrl, tableUrl, changeUrl);
}

//页数点击
let pageTravel = () => {
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
        pageInit ()

    })
}

function pageInit () {
    console.log('删除')
    $('table.record tr.items').remove()
    //学费减免
    if ($('.nav-item.selected')[1].id === 'navTuitionWaive') pageReduceRefresh(dataObj)
    //励志生库
    else if ($('.nav-item.selected')[1].id === 'navInspirationStudentLibrary') pageLibRefresh(dataObj)
    //励志生
    else if ($('.nav-item.selected')[1].id === 'navInspirationalStudent') pageRefresh(dataObj)
    //国家助学金
    else if ($('.nav-item.selected')[1].id === 'navNationalGrant') pagenavNationalGrantRefresh(dataObj)
    //励志奖学金  和   国家奖学金
    else pageNavInspirationalScholarshipRefresh(dataObj)
}


//导航栏条目点击
function navListening() {
    $('.nav-list .nav-item').on('click', function () {
        $('.nav-list .nav-item.selected').removeClass('selected');
        $('.nav-list .nav-item-first').addClass('selected');
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
//评定导航点击
function navGuideListening() {
    $('#navGuide').on('click', function () {
        $('#content').html(`
            <div class="guide">
                <p class="guide-title">学生资助管理系统申报项目教师评定说明</p>
                <div class="guide-context">
                    <table>
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
                        
                        <tr>
                        <td>励志生库</td>
                        <td colspan="4">可以查看负责班级的励志生的个人信息。</td>
                        </tr>
                        
                        <tr>
                        <td colspan="5">其他说明：具体评定时间和评定名额根据每年学校的通知和要求另行通知。</td>
                        </tr>
                    </table>
                </div>
             </div>      
        `)
        $('.page-travel').hide()
    })
}
//励志生点击
function navInsStuListening() {
    $('#navInspirationalStudent').on('click', () => {
        let middle = `  <option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">一般困难</option>
                        <option value="2">困难</option>
                        <option value="3">特别困难</option>`
        $('#content').html(initTB(middle))

        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherAdmitApplySts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavFamilyTableDetail';
                    item.tableUrl = '/stNavInspirationTableDetail';
                    item.changeUrl = '/changeTeacherAdmitApplySt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageRefresh(dataObj);
            }
        })
    })
}
//励志生库点击
function navInsStuLibListening() {
    $('#navInspirationStudentLibrary').on('click', () => {
        $('#content').html(`
            <form class="library">
                <span class="status-span">班级筛选：</span>
                <select name="classSelect" class="class-select">
                    <option value="all" selected>全部</option>
                    `+getClassItems()+
            `
                </select>
                <table class="record">
                    <tr>
                        <th>序号</th>
                        <th>学院</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>专业班级</th>
                        <th>学号</th>
                        <th>详细信息</th>
                    </tr>
                </table>
            </form>
        `);
        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherLibSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.tableUrl = '/stLibDetail';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageLibRefresh(dataObj);
            }
        })
        // $.ajax({
        //     url: '/data/tmp3.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students;
        //         dataObj.students = data.students;
        //         addStatusSelect();
        //         pageLibRefresh(data);
        //     }
        // });
    });
}
//学费减免评定点击
function navTuitionWaiveListening() {
    $('#navTuitionWaive').on('click', () => {
        let middle = `  <option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="1">已评定</option>`
        $('#content').html(initTB(middle));
        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherDiscountFeeSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavTuitionTableDetail';
                    item.changeUrl = '/changeTeacherDiscountFeeSt';
                    item.already = item.result == -1 ? 0 : 1;
                    item.result =  parseInt(item.result);
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageReduceRefresh(dataObj);
            }
        })
        // $.ajax({
        //     url: '/data/tmp2.json',
        //     dataType: 'json',
        //     success: (data) => {
        //         originObj.students = data.students
        //         originObj.students.forEach(stu => {
        //             if (stu.result != -1) {
        //                 stu.already = 1
        //             }
        //             else {
        //                 stu.already = 0
        //             }
        //         })
        //         dataObj.students = originObj.students
        //         addStatusSelect()
        //         pageReduceRefresh(data)
        //     }
        // })
    })

}
//国家助学金点击
function  navNationalGrantListening() {
    $('#navNationalGrant').on('click', () => {
        let middle = `<option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">一档</option>
                        <option value="2">二档</option>`
        $('#content').html(initTB(middle))
        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherStipendSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavGrantTableDetail';
                    item.changeUrl = '/changeTeacherStipendSt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pagenavNationalGrantRefresh(dataObj);
            }
        })
    })
}
//励志奖学金点击
function navInspirationalScholarshipListening() {
    $('#navInspirationalScholarship').on('click', () => {
        let middle = `  <option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">通过</option>`
        $('#content').html(initTB(middle))
        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherEncouragementSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavInsScholarshipTableDetail';
                    item.changeUrl = '/changeTeacherEncouragementSt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageNavInspirationalScholarshipRefresh(dataObj);
            }
        })
    })
}
//国家奖学金点击
function navNationalScholarshipListening() {
    $('#navNationalScholarship').on('click', () => {
        let middle = `  <option value="all">全部</option>
                        <option value="-1">未评定</option>
                        <option value="0">未通过</option>
                        <option value="1">通过</option>`
        $('#content').html(initTB(middle))

        let postData = {
            userId: user.userId
        };
        $.ajax({
            url: '/getTeacherScholarshipSts',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (data) => {
                console.log(data);
                data.userInfos.forEach(item => {
                    item.personalUrl = '/stNavInspirationTableDetail';
                    item.tableUrl = '/stNavNationalScholarshipTableDetail';
                    item.changeUrl = '/changeTeacherScholarshipSt';
                });
                originObj.students = data.userInfos;
                dataObj.students = data.userInfos;
                addStatusSelect();
                pageNavInspirationalScholarshipRefresh(dataObj);
            }
        })
    })
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
    navListening();
    navGuideListening();
    navInsStuListening();
    pageTravel();
    navTuitionWaiveListening();
    navInsStuLibListening();
    navNationalGrantListening();
    navInspirationalScholarshipListening();
    navNationalScholarshipListening();
    exitEventBind();
    $('#navGuide').trigger('click');
    $('.username').append(`${user.name}`);
}


getClassItems();
init();