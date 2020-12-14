<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link
	href="${pageContext.request.contextPath}/style/css/common_style_blue.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/index_1.css" />
<!--引入 fontawesom-4.2.0-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/fontawesome-4.2.0/css/font-awesome.min.css">
<!--[if IE]>
    <link rel="stylesheet" type="text/css" href="style/fontawesome-4.2.0/css/font-awesome-ie7.min.css">
    <![endif]-->
<!--引入 jquery.js-->
<script
	src="${pageContext.request.contextPath}/style/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
</head>
<body>

	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				作者信息添加
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="${pageContext.request.contextPath}/AuthorAddServlet"
			method="post">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="${pageContext.request.contextPath}/style/images/item_point.gif">
				作者信息添加&nbsp;
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="80px">作者名：</td>
								<td>
									<!-- 	<input required="required" type="hidden" name="authorId" class="InputStyle" value="addAuthor" /> -->
									<input required="required" type="text" name="authorName"
									class="InputStyle" /> *
								</td>
							</tr>

							<tr>
								<td>作者账号：</td>
								<td><input required="required" type="text"
									name="authorAccount" class="InputStyle" /> *</td>
							</tr>
							<tr>
								<td>作者密码：</td>
								<td><input required="required" type="text"
									name="authorPassword" class="InputStyle" /> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="添加" class="FunctionButtonInput">

				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
