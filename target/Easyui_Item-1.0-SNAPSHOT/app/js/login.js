/**
 * 登录
 */
function login() {
    var username = $("#username").val();
    var password = $("#password").val();

    if ((username ==null || username == '') || (password==null || password== '')){
        $.messager.alert("提示","用户名或密码不能为空");
        return ;
    }

    $.post("/login",{username:username,password:password},function (data) {
        if (data.status==200) {
            window.localStorage.setItem("login",JSON.stringify(data.data));
            window.location.href="/app/index.html"
        }else {
            $.messager.alert("提示",data.msg)
        }
    });
}

/**
 * 取消
 */
function cancel() {
    var username = $("#username").val();
    var password = $("#password").val();
    $("#username").textbox('setValue','');
    $("#password").textbox('setValue','');
}
