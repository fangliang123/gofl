// $(document).ready(function () {
//     $("#login").on('click', function () {
//         $("#loginForm").submit();
//     });
//     validateRule();
// });
//
// $.validate().setDefaults({
//     submitHandler: function () {
//         login();
//     }
// });
//
// //登录
// function login () {
//     $.ajax({
//        type: "POST",
//        url:ctx+"login",
//        data: $("#loginForm").serialize(),
//        success: function (data) {
//            if (data.code == 0) {
//                 var index = layer.load(1,{
//                    shade: [0.1,'#fff'] //0.1透明度的白色背景
//                 });
//                 parent.location.href='/index';
//            } else {
//                layer.msg(data.msg);
//            }
//        }
//     });
// }
//
// //触发请求
// function keyDownLogin() {
//     if (event.keyCode == "13") {
//         $("#login").trigger('click');
//     }
// }
//
// //验证输入规则
// function validateRule() {
//     var icon = "<i class='fa fa-times-circle'></i> ";
//     $("#loginForm").validate({
//         rules: {
//             username: {
//                 required: true
//             },
//             password: {
//                 required: true
//             }
//         },
//         messages: {
//             username: {
//                 required: icon+"用户名不能为空"
//             },
//             password: {
//                 required: icon+"密码不能为空"
//             }
//         }
//     });
// }
//
//
//
//


