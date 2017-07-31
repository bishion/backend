var baseContextPath = "../../user/";
var query = baseContextPath + "login";
$(function () {
    var grid = $("#grid");
    grid.datagrid({
        title: "结果区",
        url:query,
        singleSelect: false,
        pagination: true,
        method: "post",
        toolbar: [
            {
                text: "新增", iconCls: 'icon-add', handler: function () {

            }
            },
            {
                text: "重置密码", iconCls: 'icon-edit', handler: function () {

            }
            },{text: "删除", iconCls: 'icon-add', handler: function () {

            }
            }
        ],
        columns: [[
            {field: "username", title: '用户名'},
            {field: "status", title: '状态'},
            {field: "lastLoginTime", title: '上次登录时间'},
            {field: "lastLoginIp", title: '上次登录IP'},
            {field: "createTime", title: '创建时间'},
            {field: "creator", title: '创建人'}
        ]],
        onLoadSuccess:function (data) {
            if(!data.success){
                $.messager.alert("error","test");
                return false;
            }
        }
    });
    $("#query").click(function () {

        grid.datagrid("load", $("#queryForm").serializeArray());
    })
});

function submitForm() {
    alert("test");
    $("#query").form('submit', {
        url: query,
        success: function (data) {
            alert("teset")
        }
    });
}