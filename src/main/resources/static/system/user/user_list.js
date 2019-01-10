var prefix = "/sys/user";

$(document).ready(function () {
    // loadDeptTree();
    loadUserList();
});

function loadUserList() {
    $("#userList").jqGrid({
        url         :   prefix+'/listData',
        datatype    :   'json',
        colModel    :   [
            {
                header  :   '用户ID',
                index   :   ''
                name    :   'userId',
                align   :   'center'
            },
            {
                header  :   '登录名',
                name    :   'username',
                align   :   'center'
            },
            {
                header  :   '用户名',
                name    :   'realname',
                align  :   'center'
            },
            {
                header  :   '邮件',
                name    :   'email',
                align  :   'center'
            }
        ],
        rowNum      :   10,
        rowList     :   [ 10, 20, 30],
        // pager       :   '#pagebar',
        mtype       :   'POST',
        // viewrecords :   true,
        autowidth   :   true,
        // sortorder   :   'desc'
    });
}

//加载树形结构
function loadDeptTree() {
    $("#deptTree").treeview({
        data    :   tree
    });
}