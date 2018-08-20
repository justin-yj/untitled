<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<%@ include file="/static/include/taglib.jsp"%>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>注册</title>
    
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/css/animate.min.css" rel="stylesheet">
    <link href="/static/css/style.min.css" rel="stylesheet">
    <link href="/static/css/login.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel='stylesheet' type='text/css' />
    <!--<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>-->
<!--<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>-->
<!--//webfonts-->
<script src="/static/js/jquery.min.js"></script>
<script src="/static/common/layer-v3.1.1/layer/layer.js"></script>

	<script>
        function  UserRegistration(){
            var mobile =  $("#mobile").val();
            var password =  $("#password").val();
			var confirmPwd = $("#confirmPwd").val();
			if(mobile==""){
                layer.msg('手机号码不能为空！');
                return;
			}
			if(password==""){
                layer.msg('密码不能为空！');
                return;
			}
			if(confirmPwd==""){
                layer.msg('确认密码不能为空！');
                return;
			}
			if(!password==confirmPwd){
                layer.msg('两次密码不一致！');
                return;
			}
			var data={mobile:mobile,password:password,confirmPwd:confirmPwd};
            $.ajax({
                type: "post",
                dataType: "json",
                url: '${contentPath}/registration',
                contentType : "application/json",
                data: JSON.stringify(data),
                success: function (msg) {
                    if(msg.status==0){
                        layer.msg(msg.message);
                    }else {
                        layer.msg(msg.message);
                    }
                }
            });
        }
	</script>

</head>

<body class="signin"  style="min-height:0;">
<h1></h1>
<!-- inser start -->

<div class="login-form" id="insertPage"  >
	<div class="close"> </div>
	<div class="head-info">
		<label class="lbl-1"> </label>
		<label class="lbl-2"> </label>
		<label class="lbl-3"> </label>
	</div>
	<div class="clear"> </div>
	<div class="avtar">
		<img src="/static/img/avtar.png" />
	</div>
	<form>
		<input type="text" class="text" value="" placeholder="手机号码" id="mobile">
		<!-- <input type="text" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >-->
		<div class="key">
			<input type="password" class="password" value="" placeholder="密码" id="password">
			<input type="password" class="pwd" value="" placeholder="确认密码" id="confirmPwd">
		</div>
		<div style="float:left;margin-left:14.8%;margin-bottom:3%;">
			<a href="${contentPath}/login">返回登录</a>
		</div>
	</form>
	<div class="signin">
		<input type="submit" value="注 册" onclick="UserRegistration();" >
	</div>
</div>

<!-- insert end-->
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
</html>
