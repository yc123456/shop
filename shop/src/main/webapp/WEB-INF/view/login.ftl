<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
<meta content="乐购网是时尚消费品网站" name="description">
<meta content="时尚,乐购网,乐购" name="keywords">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>找商品-时尚商品销售-乐购网</title>
<link rel="stylesheet" type="text/css" href="/styles/style2.css"/>
<script src="/js/jquery-1.12.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">
           $(document).ready(function() {
				$('#submitLogin').click(formSubmit);
			});
			
			function formSubmit() {
			if($('#email').val()==''&&$('#password').val() == ''){
			   $('#beError1').show();
			    $('#email').addClass('input_warning');
			   $('#beError2').show();
			    $('#password').addClass('input_warning');
			   return;
			}
				if($('#email').val()=='') {
				  if($('#password').hasClass('input_warning')){
				   $('#password').removeClass('input_warning');
				    $('#beError2').hide();
				   }
					$('#beError1').show();
					 $('#email').addClass('input_warning');
					return;
				}
						
				var search_str = /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/;
				var email_val = $('#email').val();
				if(!search_str.test(email_val)){       
                $('#beError1').show();
				$('#beError1').text('邮箱格式不正确');
                $('#email').focus();
                return;
               }
               
				if($('#password').val() == '') {
				  if($('#email').hasClass('input_warning')){
				   $('#email').removeClass('input_warning');
				    $('#beError1').hide();
				  }
					$('#beError2').show();
					$('#password').addClass('input_warning');
					return;
				}
				
				$('form').ajaxSubmit({
					url: '/login/doLogin.htm',
					type: 'post',
					dataType: 'json',
					success: function(data) {
						if(data.loginStatus) {
						  $('#beError2').show();
						  $('#beError2').text('登陆成功');
							document.location.href = '/paging/pageInfo.htm';
						} else {
						  $('#beError2').show();
						   $('#beError2').text('邮箱账号和密码不匹配');
						}
					}
				});
			}
			
			
		</script>
<link rel="Shortcut Icon" href="/images/Pocket.png">
</head>
<body>
	
<!-- 页面主体START -->
<header class="sso_header">
	<!--<a href="http://www.lagou.com" class="logo">-->
	</a>
</header>
<section class="content_box cleafix">
	<div class="left_area fl">
		<form method="" action="">
			<div class="form_body">
				<div class="input_item clearfix" >
					<input type="text" class="input input_white" id="email" name="email" placeholder="请输入已验证手机/邮箱" autocomplete="off" > 
					<span id="beError1" class="input_tips" style="display:none;">请输入已验证邮箱</span>
				</div>
				<div class="input_item clearfix">
					<input type="password" class="input input_white" id="password" name="userPwd" placeholder="请输入密码"  autocomplete="off" > 
					<span id="beError2" class="input_tips" style="display:none;">请输入密码</span>
				</div>
				<div class="input_item clearfix" style="display:none;">
					<input type="text" class="input input_white fl" style="width:130px; display:block;" name="" placeholder="请输入验证码"  autocomplete="off" >
					<img src="" alt="" class="yzm">
					<a href="javascript:;" class="reflash"></a>
				</div>
				<div class="input_item clearfix">
					<a href="/account/resetPwd.html" class="forgot_pwd">忘记密码？</a>
				</div>
				<div class="input_item clearfix">
					<input id="submitLogin" type="button" class="btn btn_green btn_active btn_block btn_lg" value="登&nbsp;录">
				</div>
				<div class="input_item clearfix">
					<h5 class="reg_now">还没有乐购帐号？<a href="/register/register.html">立即注册</a></h5>
				</div>
				<input type="hidden" value = "" id = "isVisiable_request_form_verifyCode" />
			</div>
		</form>
	</div>

	<div class="divider fl">
		<img src="/images/divider-login_3362138.jpg" alt="分割线">
	</div>
	<div class="right_area fl">
		<h5>使用以下帐号直接登录:</h5>
		<ul class="vender_login clearfix">
			<li><a href="/oauth20/auth_sinaWeiboProvider.html" title="使用新浪微博帐号登录" class="vender_icon icon_sina" target="_blank"></a></li>
			<li><a href="/oauth20/auth_qqProvider.html" title="使用腾讯QQ帐号登录" class="vender_icon icon_tencent" target="_blank"></a></li>
			<li class="last_child"><a href="/oauth20/auth_weixinProvider.html" class="vender_icon icon_wechat" title="使用微信帐号登录" target="_blank"></a></li>
		</ul>

	</div>
</section>

<footer>
	<h4 class="slogan">— 专注打造时尚品牌购物 —</h4>
</footer>
<!-- 页面主体END -->	
</body>
</html>

