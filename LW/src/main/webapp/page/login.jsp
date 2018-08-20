<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<%@ include file="../static/include/taglib.jsp"%>
<link href="/static/css/style.css" rel='stylesheet' type='text/css' />
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>登录</title>
    <jsp:include page="${pageContext.request.contextPath}/static/include/head.jsp"/>

    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>
<script>
	$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});
});

    function keyLogin(){
        if (event.keyCode==13)  //回车键的键值为13
           login();
    }


	function login(){
	    var data={"mobile":$("#mobile").val(),"password":$("#password").val()};

        $.ajax({
            type: "post",
            dataType: "json",
            contentType : "application/json",
            url: '${contentPath}/login',
            data:JSON.stringify(data),
            success: function (data) {
                if(data.status==0){
                    window.location.href="${contentPath}/index";
                }else if(data.status==1){
                    $("#key1").attr("style","background:url(static/img/pass.png) no-repeat 447px 56px;");
                    layer.msg(data.message);
                }else if(data.status==2){
                    $("#key2").attr("style","background:url(static/img/pass.png) no-repeat 447px 17px;");
                    layer.msg(data.message);
                }
            }
        });
	}
</script>
	<!--[if lt IE 9]>
	<meta http-equiv="refresh" content="0;ie.html" />
	<![endif]-->
	<script>
        function inserOk(){
            layer.msg('注册成功！请登录。');
        }
	</script>
	<script>
        if(window.top!==window.self){window.top.location=window.location};
	</script>
	<script>$(document).ready(function(c) {
        $('.close').on('click', function(c){
            $('.login-form').fadeOut('slow', function(c){
                $('.login-form').remove();
            });
        });
    });

    function showInsert()
    {
        window.location.href="${contentPath}/UserRegistration";
    }
    function showLogin()
    {
        var loginPage = document.getElementById("loginPage");
        loginPage.style.display="";
        var insertPage = document.getElementById("insertPage")
        insertPage.style.display="none";
    }

	</script>

</head>

<body class="signin"  style="min-height:0;" onkeydown="keyLogin();">
<h1></h1>
<div class="login-form" id="loginPage">
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
		<div id="key1">
			<input type="text" id="mobile" class="text" value="" placeholder="手机号码" onfocus = "$('#key1').removeAttr('style')">
		</div>
		<!-- <input type="text" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >-->
		<div id="key2"> <!-- class="key"-->
			<input type="password" id="password" class="pwd" value="" placeholder="密码" onfocus = "$('#key2').removeAttr('style')">
			<!-- <input type="password" value="" placeholder="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">-->
		</div>
		<div style="float:left;margin-left:14.8%;margin-bottom:3%;">
			<a href="#" onclick="showInsert();">立即注册</a>
		</div>
	</form>
	<div class="signin">
		<input type="submit" onclick="login()" value="登 录" >
	</div>
</div>
<!-- inser start -->

<div class="login-form" style="display:none;" id="insertPage"  style="display:none;position: absolute;  top: 30%;  left: 25%;" >
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
		<input type="text" class="text" value="" placeholder="手机号码" onfocus="this.value = ''" onblur="if (this.value == '') {this.value = '';}" >
		<!-- <input type="text" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >-->
		<div class="key">
			<input type="password" class="password" value="" placeholder="密码" onfocus="this.value = ''" onblur="if (this.value == '') {this.value = '';}">
			<input type="password" class="pwd" value="" placeholder="确认密码" onfocus="this.value = ''" onblur="if (this.value == '') {this.value = '';}">
		</div>
		<div style="float:left;margin-left:14.8%;margin-bottom:3%;">
			<a href="#" onclick="showLogin();">返回登录</a>
		</div>
	</form>
	<div class="signin">
		<input type="submit" value="注 册" onclick="inserOk();" >
	</div>
</div>

<!-- insert end-->
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
</html>
