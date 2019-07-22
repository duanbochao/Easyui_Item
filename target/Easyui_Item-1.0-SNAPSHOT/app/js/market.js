$(function () {
    $('#dg').datagrid({
        url:'/getMarketByPage',
        pagination:true,
        pageNumber:1,
        pageSize:2,
        pageList:[2,4,6,8,10],
        fitColumns:true,
        fit:true,
        singleSelect:true,
        columns:[[
            {field:'id',title:'活动编号',width:100},
            {field:'theme',title:'活动主题',width:100},
            {field:'description',title:'活动详情',width:100,formatter: function(value,row,index){
                   if (value.length<8) {
                       return value;
                   }else {
                       return value.substring(0,8)+"...";
                   }
                }
            },
            {field:'summary',title:'活动主题',width:100},
            {field:'clue',title:'活动线索',width:100}
        ]],
        toolbar: [{
            iconCls: 'icon-add',
            text:'添加操作',
            handler: function(){
                $('#win').window('open');  // open a window
            }
        },'-',{
            iconCls: 'icon-remove',
            text:'删除操作',
            handler: function(){
                deleteMarketById();
            }
        },'-',{
            iconCls: 'icon-edit',
            text:'修改操作',
            handler: function(){
                showEditActivity();
            }
        },'-',{
            iconCls: 'icon-search',
            text:'查询操作',
            handler: function(){
                showQueryActivity();
            }
        }],
        onRowContextMenu:function (e, rowIndex, rowData) {
            e.preventDefault();
            $(this).datagrid("selectRow",rowIndex);
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
            e.preventDefault();
        }

    });


    //菜单选项
    $('#mm').menu({
        onClick:function (item) {
            if (item.text=='添加') {
                $('#win').window('open');  // open a window
            }
            if (item.text=='修改') {
                showEditActivity();
            }

            if (item.text=='删除') {
                deleteMarketById();
            }

        }
    });

});


var mid=null;
/**
 * 添加
 */
function addMarketActivity() {

    var theme = $("#theme").val();
    var budget = $("#budget").val();
    var clue = $("#clue").val();
    var description = $("#description").val();

    /**
     * 发送添加请求
     */
    if (mid==null || mid==''){

        $.post('/addMarket',{theme:theme,budget:budget,clue:clue,description:description},function (data) {
           if (data.status==200) {
               console.log("success")
               //关闭添加窗口
               $('#win').window('close');  // closed a window
               // 提示一下
               $.messager.alert("提示",data.msg);
               //重新加载页面
               $('#dg').datagrid('reload');

               //清空缓存数据
               clearTextBox();
           }else {
               // 提示一下
               $.messager.alert("提示",data.msg);
           }
       });
   } else {
        /**
         * 发送修改请求
         */
       $.post('/updateMarket',{theme:theme,clue:clue,budget:budget,description:description,id:mid},function (data) {
         if (data.status==200) {
             $.messager.alert("提示",data.msg);
             $('#win').window('close');  // closed a window
             clearTextBox();//清空窗口
             $('#dg').datagrid('reload');
             mid='';
         }else {
             $.messager.alert("提示",data.msg);
         }
       });

   }
}

/**
 * 修改操作
 */
function showEditActivity(){

    var sel = $('#dg').datagrid('getSelections');
    if (sel==null || sel.length==0) {
        $.messager.alert('提示','请选择一行');
        return null;
    }
    //打开窗口
    $('#win').window('open');  // closed a window
    //填充数据
    var theme = $("#theme").textbox('setValue',sel[0].theme);
    var budget = $("#budget").textbox('setValue',sel[0].budget);
    var clue = $("#clue").textbox('setValue',sel[0].clue);
    var description = $("#description").val(sel[0].description);
    mid=sel[0].id;
}


/**
 * 删除操作
 */
function deleteMarketById() {
    var sel = $('#dg').datagrid('getSelections');
    if (sel==null || sel=='') {
        $.messager.alert("提示","请选择一个要删除的行");
        return null;
    }
    var id = sel[0].id;
    $.post('/deleteMarketById',{id:id},function (data) {
        if (data.status==200){
            $.messager.alert("提示",data.msg);
            $('#dg').datagrid('reload');
        } else {
            $.messager.alert("提示",data.msg);
        }
    });
}


/**
 * 查询操作显示面板
 */
function showQueryActivity() {
    //创建一个面板
    $('#selWin').window({
        title:'查询',
        iconCls:'icon-search',
        width:600,
        height:200,
        modal:true,
        collapsible:false,
        minimizable:false,
        maximizable:false
    });
}


/**
 * 查询操作
 * @returns {string}
 */
function selectMarketActivity() {
    var query = $("#query").val();
    //表单校验
    if (query==null || query=='') {
        $.messager.alert("请输入查询内容")
        return '';
    }

    // $.post('/selectMarketByLike',{query:query},function (data) {
    //     if (data.status==200){
    //         console.log(data)
    //         $('#win').window('close');  // closed a window
    //     }
    // });


    // $('#dg').datagrid({
    //     url:'/selectMarketByLike',
    //     queryParams:{
    //         query:query
    //      }
    //     });




    $('#dg').datagrid({
        url:'/selectMarketByLike',
        queryParams:{
            query:query
        },
        pagination:true,
        pageNumber:1,
        pageSize:2,
        pageList:[2,4,6,8,10],
        fitColumns:true,
        fit:true,
        singleSelect:true,
        columns:[[
            {field:'id',title:'活动编号',width:100},
            {field:'theme',title:'活动主题',width:100},
            {field:'description',title:'活动详情',width:100,formatter: function(value,row,index){
                    if (value.length<8) {
                        return value;
                    }else {
                        return value.substring(0,8)+"...";
                    }
                }
            },
            {field:'summary',title:'活动主题',width:100},
            {field:'clue',title:'活动线索',width:100}
        ]],
        toolbar: [{
            iconCls: 'icon-add',
            text:'添加操作',
            handler: function(){
                $('#win').window('open');  // open a window
            }
        },'-',{
            iconCls: 'icon-remove',
            text:'删除操作',
            handler: function(){
                deleteMarketById();
            }
        },'-',{
            iconCls: 'icon-edit',
            text:'修改操作',
            handler: function(){
                showEditActivity();
            }
        },'-',{
            iconCls: 'icon-search',
            text:'查询操作',
            handler: function(){
                showQueryActivity();
            }
        }],
        onRowContextMenu:function (e, rowIndex, rowData) {
            e.preventDefault();
            $(this).datagrid("selectRow",rowIndex);
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
            e.preventDefault();
        }

    });


    //菜单选项
    $('#mm').menu({
        onClick:function (item) {
            if (item.text=='添加') {
                $('#win').window('open');  // open a window
            }
            if (item.text=='修改') {
                showEditActivity();
            }

            if (item.text=='删除') {
                deleteMarketById();
            }
        }
    });
    $('#selWin').window('close');  // closed a window
}



/**
 * 公共清空窗口函数
 */
function clearTextBox() {
    var theme = $("#theme").textbox('setValue','');
    var budget = $("#budget").textbox('setValue','');
    var clue = $("#clue").textbox('setValue','');
    var description = $("#description").val('');
}