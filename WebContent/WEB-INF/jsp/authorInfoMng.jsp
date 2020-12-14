<%@page import="www.novel.entity.Author"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>后台管理</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 作者信息列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/AuthorListSerlvet" method="get">
			<input
				type="text" name="q" title="请输入作者姓名"> <input
				type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->

	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td align="center">作者号</td>
					<td align="center">作者名称</td>
					<td align="center">作者账号</td>
					<td align="center">作者密码</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<%
					ArrayList<Author> authors = (ArrayList) request.getAttribute("authors");
				%>
				<%
					for (int i = 0; i < authors.size(); i++) {
						Author author = authors.get(i);
				%>
				<tr>
					<td><%=author.getAuthorId()%></td>
					<td><%=author.getAuthorName()%></td>
					<td><%=author.getAuthorAccount()%></td>
					<td><%=author.getAuthorPassword()%></td>
					<td align="center">
					<a href="<%=request.getContextPath() + "/updateAuthor.jsp?authorId=" + author.getAuthorId()%>" class="FunctionButton">修改</a> <a
						href="<%=request.getContextPath() + "/DeleteAuthorServlet?authorId=" + author.getAuthorId()%>" onClick="return delConfirm();" class="FunctionButton">删除</a></td>
						
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/addAuthor.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
