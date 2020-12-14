<%@page import="www.novel.entity.NovelClassify"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
				添加新栏目
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form
			action="${pageContext.request.contextPath}/ClassifyUpdateServlet"
			method="post">

			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="${pageContext.request.contextPath}/style/images/item_point.gif">
				栏目信息&nbsp;
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<%
						NovelClassify novelClassify =(NovelClassify)request.getAttribute("novelClassify");
/* 							String cid = request.getParameter("classifyId");
							String cname = request.getParameter("classifyName"); */
						%>
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="80px">新的分类：</td>
								<td><input required="required" type="text"
									name="newclassify" class="InputStyle" value="<%=novelClassify.getNovelClassifyName()%>" /> *
									<input type="hidden" name="classifyId" value="<%=novelClassify.getNovelClassifyId()%>" /></td>
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
