/**
 * Created by Alander on 2017/8/19.
 */
let data = {};

$(init());

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function init () {
    $('.submit').unbind().on('click', () => {
        data.studentId = getQueryString('studentId');
        data.tableYear = getQueryString('tableYear');
        data.isLoan = $('input[name="stipend_hasApply"]:checked').val();
        data.isWorkAndStudy = $('input[name="stipend_hasJob"]:checked').val();
        data.awardsName = $('.stipend_rewardSituation').val();
        data.awardsNumber = $('.stipend_rewardNumber').val();
        data.helpsName = $('.stipend_supprotSituation').val();
        data.helpsNumber = $('.stipend_supprotNumber').val();
        data.other = $('.stipend_remark').val();
        data.isCheckin = 1;

        console.log(data);


        $.ajax({
            type: 'POST',
            url: '/saveEncourageLib',
            data: JSON.stringify(data),
            contentType: 'application/json;charset=utf-8',
            success: function (resdata, textStatus, jqXHR) {
                if (resdata.code === 200) {
                    console.log(resdata);
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
    })
}