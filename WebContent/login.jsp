<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>后台管理登录</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="/favicon.ico" type="style/image/x-icon" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/style/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/xadmin.js"></script>
</head>
<style>
.Row {
	display: table;
	width: 100%; /*Optional*/
}

.Column {
	display: table-cell;
}
</style>
<body class="login-bg">
	<div class="login layui-anim layui-anim-up">
		<div class="message">后台登录</div>
		<div id="darkbannerwrap"></div>
		<form method="post" class="layui-form"
			action="${pageContext.request.contextPath}/AdminLoginServlet">
			<input name="account" placeholder="用户名" type="text"
				lay-verify="required" class="layui-input">
			<hr class="hr15">
			<input name="password" lay-verify="required" placeholder="密码"
				type="password" class="layui-input">
			<hr class="hr15">
			<input value="登录" lay-submit lay-filter="login" style="width: 100%;"
				type="submit">
			<hr class="hr20">
			<div class="Row">
				<div class="Column">

					<a href="${pageContext.request.contextPath}/foreground/index.jsp">返回前台</a>
				</div>
			</div>
		</form>
	</div>


	<!-- 底部结束 -->
</body>
</html>