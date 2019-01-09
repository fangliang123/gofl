var prefix = "/sys/user";

$(document).ready(function () {
    loadUserList();
});

//加载用户列表
function loadUserList() {
    $("#userList").DataTable({
        'language'  : {
            "sProcessing"   : "处理中...",
            "sLengthMenu"   : "显示 _MENU_ 项结果",
            "sZeroRecords"  : "没有匹配结果",
            "sInfo"         : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty"    : "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix"  : "",
            "sSearch"       : "搜索:",
            "sUrl"          : "",
            "sEmptyTable"   : "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate"     : {
                "sFirst"        : "首页",
                "sPrevious"     : "上页",
                "sNext"         : "下页",
                "sLast"         : "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        },
        'paging'      : true, // 是否开启本地分页
        'lengthChange': false, //是否允许用户改变表格每页显示的记录数
        'searching'   : false,
        'ordering'    : true, // 是否允许Datatables开启排序
        'info'        : true, // 控制是否显示表格左下角的信息
        'autoWidth'   : false, // 控制Datatables是否自适应宽度
        'serverSide'  : true, // 是否开启服务器模式
        'ajax'        : {
            'url'           : prefix + '/list',
            'type'          : 'post'
        },
        'columns'     : [
            {
                'data'  : 'userId',
                'title' : '用户ID'
            },
            {
                'data' : 'username',
                'title': '登录名'
            },
            {
                'data' : 'realname',
                'title': '用户名'
            },
            {
                'data' : 'email',
                'title': '邮箱'
            }
        ]
    });
}

// function loadUserList() {
//     $('#userList').bootstrapTable({
//         method : 'post', // 服务器数据的请求方式 get or post
//         url : prefix + "/list", // 服务器数据的加载地址
//         // toolbar : '#exampleToolbar',
//         striped : true, // 设置为true会有隔行变色效果
//         dataType : "json", // 服务器返回的数据类型
//         pagination : true, // 设置为true会在底部显示分页条
//         // queryParamsType : "limit",
//         // //设置为limit则会发送符合RESTFull格式的参数
//         singleSelect : false, // 设置为true将禁止多选
//         // contentType : "application/x-www-form-urlencoded",
//         // //发送到服务器的数据编码类型
//         pageSize : 10, // 如果设置了分页，每页数据条数
//         pageNumber : 1, // 如果设置了分布，首页页码
//         //search : true, // 是否显示搜索框
//         showColumns : false, // 是否显示内容下拉框（选择显示的列）
//         sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
//         queryParams : function(params) {
//             return {
//                 //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
//                 offset: params.offset,
//                 limit: params.limit,
//                 // name:$('#name').val(),
//                 // loginName:$('#loginName').val()
//             };
//         },
//         columns : [
//             {
//                 field : 'userId',
//                 title : '用户ID'
//             },
//             {
//                 field : 'username',
//                 title : '登录名'
//             },
//             {
//                 field : 'realname',
//                 title : '用户名'
//             },
//             {
//                 field : 'email',
//                 title : '邮箱'
//             },
//             {
//                 field : 'mobile',
//                 title : '手机号码'
//             },
//             {
//                 field : 'createTime',
//                 title : '时间'
//             },
//             {
//                 field : 'status',
//                 title : '状态',
//                 align : 'center',
//                 formatter : function(value, row, index) {
//                     if (value == '0') {
//                         return '<span class="label label-danger">禁用</span>';
//                     } else if (value == '1') {
//                         return '<span class="label label-primary">正常</span>';
//                     }
//                 }
//             },
//             {
//                 title : '操作',
//                 field : 'id',
//                 align : 'center',
//                 formatter : function(value, row, index) {
//                     var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''
//                         + row.id
//                         + '\')"><i class="fa fa-edit"></i></a> ';
//                     var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
//                         + row.id
//                         + '\')"><i class="fa fa-remove"></i></a> ';
//                     var f = '<a class="btn btn-success btn-sm" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
//                         + row.id
//                         + '\')"><i class="fa fa-key"></i></a> ';
//                     return e + d + f;
//                 }
//             } ]
//     });
// }