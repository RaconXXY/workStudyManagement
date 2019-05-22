function addTodo() {
    // swal({
    //     title: '请输入内容',
    //     text: '',
    //     type: 'info',
    //     input: 'text',
    //     showCancelButton: true,
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消'
    // }).then(function (inputValue) {
    //     let id = $('#items').children().length + 1;
    //     console.log(id);
    //     let todo = {
    //         id: id,
    //         content: inputValue,
    //         isfinish: false
    //     };
    //     $.ajax({
    //         type: 'POST',
    //         url: '/todo/addTodo',
    //         data: JSON.stringify(todo),
    //         contentType: 'application/json;charset=utf-8',
    //         success: function (data, textStatus, jqXHR) {
    //             let todo = data;
    //             console.log(todo);
    //             $('#items').append('<div class="item" id="todo' + todo.id + '">'
    //                 + '<div class="index">' + todo.id + '</div>'
    //                 + '<input class="content" value="' + todo.content + '" onblur="updateTodo(' + todo.id + ')"/>'
    //                 + '<div class="mybtn delete" onclick="deleteTodo(' + todo.id + ')">Delete</div>'
    //                 + '</div>')
    //         },
    //         error: function (jqXHR, textStatus, errorThrown) {
    //             console.log(jqXHR);
    //             console.log(textStatus);
    //             console.log(errorThrown);
    //         }
    //     });
    // }, function (dismiss) {
    //     if (dismiss === 'cancel') {
    //         // ignore
    //     } else {
    //         console.log(dismiss);
    //     }
    // });

    let todo = {
        aaa: 'aaa',
        bbb: 1,
        ccc: {
            a: 1,
            b: 'ccc'
        }
    };
    $.ajax({
        type: 'POST',
        url: '/todo/addTodo',
        data: JSON.stringify(todo),
        contentType: 'application/json;charset=utf-8',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function deleteTodo(todoId) {
    $.ajax({
        type: 'POST',
        url: '/todo/deleteTodo',
        data: {todoId: todoId},
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        success: function (data) {
            console.log(data);
            $('#todo' + todoId).remove();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function updateTodo(id) {
    let content = $('#todo' + id + '>input').val();
    console.log(id, content)
    let todo = {
        id: id,
        content: content,
        isfinish: false
    };
    $.ajax({
        type: 'POST',
        url: '/todo/updateTodo',
        data: JSON.stringify(todo),
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            console.log(data);
        }
    });
}