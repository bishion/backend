$(function () {
    var baseContextPath = "../../user/";
    var query = baseContextPath + "query.json";
    var insert = baseContextPath + "insert.json";
    var update = baseContextPath + "update.json";
    var url;

    var grid = $("#grid");
    grid.datagrid({
        title: "结果区",
        url:query,
        singleSelect: false,
        pagination: true,
        method: "post",
        fit:true,
        toolbar: [
            {text: "新增", iconCls: 'icon-add', handler: function () {
                $("#dialog").dialog('open').dialog("setTitle","新增");
                $('#editForm').form('clear');
                url = insert;
            }
            },{text: "编辑", iconCls: 'icon-edit', handler: function () {
                var record = grid.datagrid('getSelected');
                if(!record){
                    return false;
                }
                $("#dialog").dialog('open').dialog("setTitle","编辑");

                $('#editForm').form('load');
                url = update;
            }
            },{text: "删除", iconCls: 'icon-remove', handler: function () {}
            },'-',{text: "重置密码", handler: function () {}
            }
        ],
        columns: [[
            {field: "username", title: '用户名'},
            {field: "validFlag", title: '状态',formatter:function (val, rec) {
                console.log(val);
                console.log(rec);
                if(val == 1){
                    return "有效";
                }else{
                    return "无效";
                }

            }},
            {field: "lastLoginTime", title: '上次登录时间'},
            {field: "lastLoginIp", title: '上次登录IP'},
            {field: "createTime", title: '创建时间',formatter:function (val) {
                return dateTimeFormatter(val)
            }},
            {field: "creator", title: '创建人'}
        ]],
        onLoadSuccess:function (data) {
            if(!data.success){
                $.messager.alert("错误",data.message,"error");
                return false;
            }
        }
    });
    $("#query").click(function () {
        grid.datagrid("load", $("#queryForm").serializeObject());
    });
    $("#save").click(function () {
        $.post(url,$("#editForm").serializeArray(),function (result) {
            console.log(result);
            if(result.success){
                $.messager.alert("提示","操作成功");
                $("#dialog").dialog('close');
                $("#grid").datagrid('reload');
            }else{
                $.messager.alert("警告","操作成功");
            }
        },'json');
    });
});