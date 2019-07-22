//导航头部区域
var login = window.localStorage.getItem("login");
var loginUser = JSON.parse(login);
$("#loginMsg").html("欢迎"+loginUser.nickname+"!|<span style='color: #ebee23'>注销</span>");

$(function () {
    $.ajax({
        url:'/getMenus',
        type:'post',
        datatype:'json',
        data:{
        },
        success:function (data) {
            //添加侧边栏
           if(data.status==200){
               for (var i=0;i<data.data.length;i++){
                   var menus = data.data[i];
                   $('#aa').accordion('add', {
                       title: menus.name,
                       href:'/getMenu?pid='+menus.id,
                       selected: false
                   });
               }
           }
        },
        error:function (data) {
            console.log(data)
        }
    });

});


/**
 * 生成导航栏
 */
function menuItem(name,url) {

    if ($('#tt').tabs('exists',name)) {
        $('#tt').tabs('select',name);
        return ;
    }
    //生成导航
    $('#tt').tabs('add',{
        title:name,
        href:url,
        closable:true
    });
}

