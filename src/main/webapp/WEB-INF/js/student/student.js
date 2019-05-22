/**
 * Created by TengFei on 2017/7/12.
 */
let dataObj = {};
let user = JSON.parse(localStorage.getItem("user"));
console.log(user);
let statusTrans = (status) => {
    var eleName = $('.nav-item.selected')[0].id;
    if (eleName === 'navInspirationalScholarship' || eleName === 'navNationalScholarship') {
        if (status === -1) return "待审核";
        else if (status === 1) return "通过";
        else if (status === 0) return "未通过";
    }
    else if (eleName === 'navInspirationalStudent') {
        if (status === -1) return "待审核";
        else if (status === 0) return "未通过";
        else if (status === 1) return "一般困难";
        else if (status === 2) return "困难";
        else if (status === 3) return "特别困难";
    }
    else if (eleName === 'navNationalGrant') {
        if (status === -1) return "待审核";
        else if (status === 0) return "未通过";
        else if (status === 1) return "一档";
        else if (status === 2) return "二档";
    }
    else if (eleName === 'navTuitionWaive') {
        if (status === -1) return "待审核";
        else
            return status.toFixed(2);
    }
    else {
        return '已提交';
    }
};


let pageRefresh = (data) => {
    let pageMax = 8,
        len = data.forms.length,
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
        $('.pages .page').eq(pagelen).remove();
        if (pageIndex === pagelen) {
            $('.pages .page').eq(pagelen - 1).trigger('click');
        }
    }
    for (let i = (pageIndex - 1) * pageMax; i < pageIndex * pageMax && i < len; i++) {
        if (len === 0) break;
        let form = data.forms[i];
        // console.log(form);
        let htmlInput = `<tr>
                        <td class="none-R-border">${user.name} ${$('.nav-list .nav-item.selected').text()}表</td>
                        <td class="none-R-border none-L-border">${form.tableYear}学年</td>`;
        if ($('.nav-item.selected')[0].id === 'navFamilySituation') {
            htmlInput += `<td class="none-L-border">已提交</td>`;
        }
        else {
            htmlInput += `<td class="none-L-border">教师评定: ${statusTrans(form.teacherResult)}<br/> 管理员评定: ${statusTrans(form.adminResult)}</td>`;
        }
        htmlInput += `<td>
                        <a target="_blank" href="${form.detailUrl}?studentId=${form.studentId}&tableYear=${form.tableYear}"><input type="button" class="view-btn" value="查看"></a>
                     </td>
                        <td>
                            <input type="button" class="del-btn" value="删除">
                        </td>
                        <td>
                            <input type="button" class="export-btn" value="导出">
                        </td>
                    </tr>`;
        $('#content .record').append(htmlInput);
        $('.del-btn').last().on('click', () => {
            swal({
                title: '<h2 style="font-weight:bold;color:red">温馨提示</h2>',
                type: 'info',
                html: '<p>确定要删除该表吗？</p>',
                showCloseButton: true,
                showCancelButton: true,
                confirmButtonColor: '#3fc3ee',
                cancelButtonColor: 'gray',
                confirmButtonText: ' <i class="mui-icon mui-icon-trash"></i>确认',
                cancelButtonText: ' <i  class="mui-icon mui-icon-refresh"></i>取消'
            }).then(function (isConfirm) {
                if(isConfirm){
                    delItem(form.delUrl, form, i);
                }
            });

        });
        $('.export-btn').last().on('click', () => {
            exportItem(form, form.delUrl);
        });
    }
    if (dataObj.direction && $('.direction-item').length !== dataObj.direction.length)
        for (let i in data.direction) {
            let direct = data.direction[i];
            $('.direction-list').append(`
                <li class="direction-item">${direct.context}</li>
            `)
        }
};
let pageTravel = () => {
    $(document).on('click', '.page', (e) => {
        if ($(e.target).index() === 0) {
            if ($('.page.selected').index() === 1) return;
            $('.page.selected').removeClass('selected').prev().addClass('selected');
        }
        else if ($(e.target).index() === $('.page:last-child').index()) {
            if ($('.page.selected').index() === $('.page:last-child').index() - 1) return;
            $('.page.selected').removeClass('selected').next().addClass('selected');
        }
        else {
            $('.page.selected').removeClass('selected');
            $(e.target).addClass('selected');
        }
        pageInit()
    })
};
let pageInit = () => {
    $('.record').html(`
                <tr>
                    <th colspan="3">记录</th>
                    <th colspan="2">
                        <select name="" id="" class="year-select">
                            <option value="">2017</option>
                        </select>
                    </th>
                    <th>
                        <input type="button" class="search-btn" value="搜索">
                    </th>
                </tr>
        `);
    if ($(".direction").length === 0)
        $('.form').append(`
               <div class="direction">
                    <p>操作指南 :</p>
                    <ul class="direction-list">
                    </ul>
                </div>
        `);
    pageRefresh(dataObj)
};
let baseFormat = () => {
    $('#content').html(`
        <form class="assess">
            <table class="record">
                <tr>
                    <th colspan="3">记录</th>
                    <th colspan="2">
                        <select name="" id="" class="year-select">
                            <option value="">2017</option>
                        </select>
                    </th>
                    <th>
                        <input type="button" class="search-btn" value="搜索">
                    </th>
                </tr>
            </table>
            <input type="button" class="add-btn" value="新增">
        </form>
    `);
    if ($(".direction").length === 0)
        $('.form').append(`
               <div class="direction">
                    <p>操作指南 :</p>
                    <ul class="direction-list">
                    </ul>
                </div>
        `)

};

function addBtnClick(toPage) {
    $('#content .add-btn').unbind().on('click', () => {
        let index = window.location.href.lastIndexOf('/');
        let href = window.location.href.substring(0, index) + '/' + toPage;
        // console.log(href);
        window.open(href);
    })
}

function navListening() {
    $('.nav-list .nav-item').on('click', function () {
        $('.nav-list .nav-item.selected').removeClass('selected');
        $(this).addClass('selected');
        $('#form-location').text("所在位置：" + $(this).text());
        $('.page-travel').show();
        $('.page-travel').html(`
                <ul class="pages">
                    <li class="page"><<</li>
                    <li class="page selected">1</li>
                    <li class="page">>></li>
                </ul>
        `);
    })
}

function navGuideListening() {
    $('#navGuide').on('click', function () {
        $('#content').html(`
            <div class="guide">
                <p class="guide-title">学生资助管理系统申报项目简介</p>
                <div class="guide-context">
                    <table>
                        <tr>
                            <th>名称</th><th>申请条件</th><th>分配标准和额度</th><th>申请应提交的材料</th><th>申请时间</th><th>注意事项</th>
                        </tr>
                        <tr>
                        <td>励志生申请</td>
                        <td>
                        <p>家庭经济困难，生活俭朴</p>
                        </td>
                        <td>
                        <p>分为特别困难，困难和一般困难</p>
                        </td>
                        <td><ul>
                        <li>1.杭州师范大学家庭经济困难学生认定申请表</li>
                        <li>2.杭州国际服务工程学院学生及家庭情况调查表</li>
                        <li>3.其他贫困证明材料</li>
                        </ul></td>
                        <td>每年暑假开始到9月</td>
                        <td>
                        <p>1.申请同学如实汇报家庭情况</p>
                        <p>2.采用民主评议确定贫困等级</p>
                        </td>
                        </tr>
                        
                        <tr>
                        <td>国家助学金</td>
                        <td>
                        <p>家庭经济困难，生活俭朴</p>
                        <p>(励志生)</p>
                        <td>
                        <p>一档4000元/每人</p>
                        <p>二档2500元/每人</p>
                        </td>
                        <td>国家助学金申请表</td>
                        <td>每年10月</td>
                        <td>
                        <p>1.每学年分两次发放</p>
                        <p>2.大一就可申请，可同时申请学费减免、国家奖学金或者国家励志奖学金</p>
                        </td>
                        </tr>
                        
                        <tr>
                        <td>励志奖学金</td>
                        <td>
                        <p>学习成绩优秀、 家庭经济困难，生活俭朴</p>
                        <p>(励志生)</p>
                        <td>
                        <p>5000元/每人</p>
                        </td>
                        <td>励志奖学金申请表</td>
                        <td>每年10月</td>
                        <td>
                        <p>1.大二开始申请,不同时享受国家奖学金</p>
                        <p>2.可申请学费减免和国家助学金</p>
                        </td>
                        </tr>
                        
                        <tr>
                        <td>国家奖学金</td>
                        <td>
                        <p>学习成绩优异， 社会实践、创新能力、综合素质等方面特别突出</p>
                        <td>
                        <p>8000元/每人</p>
                        </td>
                        <td><p>国家奖学金申请表</p><p>获奖证书及评优材料复印件</p></td>
                        <td>每年10月</td>
                        <td>
                        <p>1.大二开始申请；不同时享受励志奖学金</p>
                        <p>2.可申请学费减免和国家助学金</p>
                        </td>
                        </tr>
                        
                        <tr>
                        <td>学费减免</td>
                        <td>
                        <p>家庭经济特别困难，不可抗拒意外事故发生，生活俭朴</p>
                        <p>(励志生)</p>
                        <td>
                        <p>视具体情况减免</p>
                        </td>
                        <td>学费减免申请表</td>
                        <td><p>每年10月</p><p>(集中申请)</p></td>
                        <td>
                        <p>1.可同时申请国家助学金、国家奖学金或者国家励志奖学金</p>
                        <p>2.有集中申请和临时申请两种方式，临时申请覆盖整个学习期间</p>
                        </td>
                        </tr>
                        
                        <tr><td colspan="6">其他说明：具体申请时间和要求请查看网站首页的通知。</td></tr>
                    </table>
                </div>
             </div>      
        `)
        $('.page-travel').hide();
        $('.direction').eq(0).remove();
    })

}

function navFamilySituationListening() {
    $('#navFamilySituation').on('click', () => {
        baseFormat();
        addBtnClick('questionary');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getStNavFamilyTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delStNavFamilyTable';
                    item.detailUrl = '/stNavFamilyTableDetail';
                });
                dataObj.forms = date.date;
                pageRefresh(dataObj);
            }
        });
    });
}

//励志生
function navInspirationalStudentListening() {
    $('#navInspirationalStudent').on('click', () => {
        baseFormat();
        addBtnClick('admitapply');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getNavInspirationalTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delNavInspirationTable';
                    item.detailUrl = '/stNavInspirationTableDetail';
                });
                dataObj.forms = date.date;
                console.log(dataObj);
                pageRefresh(dataObj);
            }
        })
    })
}

//国家助学金
function navNationalGrant() {
    $('#navNationalGrant').on('click', () => {
        baseFormat();
        addBtnClick('stipend');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getNavGrantTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delNavGrantTable';
                    item.detailUrl = '/stNavGrantTableDetail';
                });
                dataObj.forms = date.date;
                pageRefresh(dataObj);
            }
        })
    })
}

//励志奖学金
function navInspirationalScholarship() {
    $('#navInspirationalScholarship').on('click', () => {
        baseFormat();
        addBtnClick('encouragement');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getNavInsScholarshipTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delNavInsScholarshipTable';
                    item.detailUrl = '/stNavInsScholarshipTableDetail';
                });
                dataObj.forms = date.date;
                console.log(dataObj);
                pageRefresh(dataObj);
            }
        })
    })
}

//国家奖学金
function navNationalScholarship() {
    $('#navNationalScholarship').on('click', () => {
        baseFormat();
        addBtnClick('scholarship');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getNavScholarshipTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delNavNationalScholarshipTable';
                    item.detailUrl = '/stNavNationalScholarshipTableDetail';
                });
                dataObj.forms = date.date;
                pageRefresh(dataObj);
            }
        })
    })
}

function navTuitionWaive() {
    $('#navTuitionWaive').on('click', () => {
        baseFormat();
        addBtnClick('discountfee');
        let postData = {
            studentId: user.userId
        };
        $.ajax({
            url: '/getNavTuitionTables',
            contentType: 'application/json;charset=utf-8',
            type: 'POST',
            data: JSON.stringify(postData),
            success: (date) => {
                date.date.forEach(item => {
                    item.delUrl = '/delNavTuitionTable';
                    item.detailUrl = '/stNavTuitionTableDetail';
                });
                dataObj.forms = date.date;
                pageRefresh(dataObj);
            }
        })
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
                dataObj.forms.splice(i, 1);
                pageInit();
            } else {
                console.log(resdata.result)
                swal('错误!',resdata.description,'error');
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

//下载word
function exportItem(data, url) {
    //因为url不一样也没有啥好方法找到url所以手动映射
    let mapping = {
        "/delStNavFamilyTable": "/questionarytablesave",
        "/delNavInspirationTable": "/admitapplytablesave",
        "/delNavGrantTable": "/stipendtablesave",
        "/delNavInsScholarshipTable": "/encouragementtablesave",
        "/delNavNationalScholarshipTable": "/scholarshiptablesave",
        "/delNavTuitionTable": "/discountfeetablesave",
    };
    url = mapping[url];

    //字段替换的映射
    //因为模板文件里面的变量这里必须要有否者就报错，多了没关系
    //以下代码都是处理字段，这里用于吧arr拆开
    let strarrMapping = {
        familyMember: ['name', 'age', 'appellation', 'workCeremony'],
        familyMembers: ['name', 'age', 'appellation', 'workCeremony'],
        prizes: ['date', 'priceName', 'awardCeremony'],
        awards: ["awardName", "awardNumber"],
        helps: ["helpName", "helpNumber"]
    };

    for (let i in data) {
        if (typeof data[i] === 'object') {
            let num;
            if (i === 'familyMember' || i === 'familyMembers') {
                num = 5;
            } else {
                num = 4;
            }
            console.log(num);
            objUtil(data[i], data, strarrMapping[i], num)
        }
    }
    //这里是吧user有的字段也都加上去
    let user = JSON.parse(localStorage.getItem('user'));
    console.log(user);
    for (let i in user) {
        data[i] = user[i];
    }
    //这里是处理一些诡异的字段
    data.birthYM = data.birthYear + '年' + data.birthMonth + '月';
    data.startYM = data.startYear + '年' + data.startMonth + '月';
    data.startYear = data.tableYear.substr(0, 4);
    data.endYear = data.tableYear.substr(5, 4);
    if (url === '/questionarytablesave') {
        let date = new Date();
        let num = parseInt(date.getFullYear()) - parseInt('20' + user.className.substr(0, 2));
        let arr = ['', '一', '二', '三', '四', '五', '六', '七'];
        data.grade = '大' + arr[num];
    }

    console.log(data);
    let form = $(`<form id="downloadwordword" style="display:none" target="" method="post" action="${url}"></form>`);
    $('body').append(form);
    for (let i in data) {
        let str = `<input type="hidden" name="${i}" value="${data[i]}"/>`;
        // console.log(str);
        form.append(str);
    }
    form.submit();
    $('#downloadwordword').remove();

    function objUtil(objarr, data, strarr, num) {
        const COUNT = num;
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
function exitEventBind() {
    $('.exit').on('click', function () {
        localStorage.clear();
        clearAllCookie();
    })
}
let init = () => {

    navListening();
    navGuideListening();
    navFamilySituationListening();
    navInspirationalStudentListening();
    navNationalGrant();
    navInspirationalScholarship();
    navNationalScholarship();
    navTuitionWaive();
    pageTravel();
    exitEventBind();
    $('#navGuide').trigger('click');
    // $('#navInspirationalStudent').trigger('click');
    // $('#navTuitionWaive').trigger('click');
    // $('#navInspirationStudentLibrary').trigger('click');
    $('.unbind-click').unbind('click');
    $('.username').append(`${user.name}`);
};
init();