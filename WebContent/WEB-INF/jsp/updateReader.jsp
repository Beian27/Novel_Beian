
<%@page import="www.novel.entity.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/page_common.js"></script>
<link
	href="${pageContext.request.contextPath}/style/css/common_style_blue.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/index_1.css" />
</head>
<body>

	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				更新
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="${pageContext.request.contextPath}/ReaderUpdateServlet" method="post">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="${pageContext.request.contextPath}/style/images/item_point.gif">
				读者信息&nbsp;
			</div>

			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<%
							Reader reader = (Reader) request.getAttribute("reader");
						%>
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<input type="hidden" name="readerId" value="<%=reader.getReaderId()%>">
								<td width="80px">读者名：</td>
								<td><input required="required" type="text" name="readerName"
									class="InputStyle" value=<%=reader.getReaderName()%> /> *</td>
							</tr>
							<tr>
								<td width="80px">读者账号</td>
								<td><input required="required" type="text" name="readerAccount"
									class="InputStyle" value=<%=reader.getReaderAccount()%> /> *</td>
							</tr>
							<tr>
								<td width="80px">读者密码</td>
								<td><input required="required" type="text" name="readerPassword"
									class="InputStyle" value=<%=reader.getReaderPassword()%> /> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" value="修改" class="FunctionButtonInput">
				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
