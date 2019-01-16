var  prefix = "/admin";

/**
 * 本地搜索菜单选项
 */
function search_menu() {
    //要搜索的值
    var text = $('input[name=q]').val();

    var $ul = $('.sidebar-menu');
    $ul.find("a.nav-link").each(function () {
        var $a = $(this).css("border","");

        //判断是否含有要搜索的字符串
        if ($a.children("span.menu-text").text().indexOf(text) >= 0) {

            //如果a标签的父级是隐藏的就展开
            $ul = $a.parents("ul");

            if ($ul.is(":hidden")) {
                $a.parents("ul").prev().click();
            }

            //点击该菜单
            $a.click().css("border","1px solid");

//                return false;
        }
    });
}

function getMenus (userId) {
    $.ajax({
        url: prefix+'/getMenus',
        type: 'post',
        dataType: 'json',
        data: {'userId':'0'},
        cache: false,
        success: function (data) {
            var menus = [];
            var Menu = function () {
                return {
                    id: '',
                    text : '',
                    icon : '',
                    children: []
                }
            };
            for (var i in data) {
                var menu = new Menu();
                menu.id = i.id;
                menu.text = i.text;
                menu.icon = i.attrs.icon;
                for (var j in i.children) {
                    var child = new Menu();
                    child.id = j.id;
                    child.text = j.text;
                    child.icon = j.attrs.icon;
                    menu.children.push(child);
                }
                menus.push(menu);
            }
            $(".sidebar-menu").sidebarMenu({data:menus, param : {strUser : 'admin'}});
        }


    });
}

$(function () {
//        console.log(window.location);

    App.setbasePath("/");
    addTabs({
        id: '10008',
        title: '仪表盘',
        close: false,
        url: '/main'
    });
    App.fixIframeCotent();
    var menus = [
        // {
        //     id: "9000",
        //     text: "header",
        //     icon: "",
        //     isHeader: true
        // },
        {
            id: "9001",
            text: "UI Elements",
            icon: "fa fa-laptop",
            children: [
                {
                    id: "90011",
                    text: "buttons",
                    icon: "fa fa-circle-o",
                    url: "UI/buttons_iframe.html",
                    targetType: "iframe-tab"
                },
                {
                    id: "90012",
                    text: "icons",
                    url: "UI/icons_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90013",
                    text: "general",
                    url: "UI/general_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90014",
                    text: "modals",
                    url: "UI/modals_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90015",
                    text: "sliders",
                    url: "UI/sliders_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90016",
                    text: "timeline",
                    url: "UI/timeline_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                }
            ]
        },
        {
            id: "9002",
            text: "Forms",
            icon: "fa fa-edit",
            children: [
                {
                    id: "90021",
                    text: "advanced",
                    url: "forms/advanced_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90022",
                    text: "general",
                    url: "forms/general_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                },
                {
                    id: "90023",
                    text: "editors",
                    url: "forms/editors_iframe.html",
                    targetType: "iframe-tab",
                    icon: "fa fa-circle-o"
                }
            ]
        }
    ];
    var sidebar = [];

    // $('.sidebar-menu').sidebarMenu({data: menus, param: {strUser: 'admin'}});
    getMenus("0");

});