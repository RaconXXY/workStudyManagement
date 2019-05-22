/**
 * Created by TengFei on 2017/7/2.
 */
init()
function init() {
    navListening();
    addRecord()
    deleteRecord()
}
function navListening() {

    $('.nav-list .nav-item').on('click', function () {
        $('.nav-list .nav-item.selected').removeClass('selected');
        $(this).addClass('selected');
        $('#form-location').text("所在位置：" + $(this).text());
        if ($(this).index() === 0) {
            $('.guide').show();
            $('.content').hide();
        }
        else {
            $('.guide').hide();
            $('.content').show();
        }
    })
}

function addRecord() {
    var Name = 'XXX困难生认定表',
        Year = '2016-2017学年',
        Status = '通过',
        id = 0;

    var $col1 = "<tr><td><ul class=\"record-specific\"><li class=\"specific-item form-name\">" + Name + "</li><li class=\"specific-item form-year\">" + Year + "</li><li class=\"specific-item form-status\">" + Status + "</li></ul></td>";
    var $col2 = "<td class=\"col-2\"><a class=\"recordScan\" href=\"JavaScript: void(0);\">查看</a><a class=\"recordDel\" href=\"JavaScript: void(0);\">删除</a></td>";
    var $col3 = "<td class=\"col-3\"><a class=\"recordExport\" href=\"JavaScript: void(0);\">导出</a></td></tr>";
    $('.form .add').on('click', function () {
        $('.record table tbody').append($col1 + $col2 + $col3);
    })

}
function scanRecord() {

}

function deleteRecord() {
    $(document).on("click", ".recordDel", function (e) {
        $(e.target).parentsUntil("tbody").remove();
    })
}
function exportRecord() {

}