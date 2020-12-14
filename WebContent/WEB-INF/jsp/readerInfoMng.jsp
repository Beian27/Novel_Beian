<%@page import="www.novel.entity.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
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
				读者列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/ReaderListServlet"
			method="get">
			<input type="text" name="q" title="请输入读者名"> <input
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
					<td>读者号</td>
					<td>读者名</td>
					<td>读者账号</td>
					<td>读者密码</td>
					<td>操&nbsp;作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<%
					ArrayList<Reader> readers = (ArrayList) request.getAttribute("readers");
					for (int i = 0; i < readers.size(); i++) {
						Reader reader = readers.get(i);
				%>
				<tr class="TableDetail1">
					<td><%=reader.getReaderId()%>&nbsp;</td>
					<td><%=reader.getReaderName()%>&nbsp;</td>
					<td><%=reader.getReaderAccount()%>&nbsp;</td>
					<td><%=reader.getReaderPassword()%>&nbsp;</td>
					<td><a
						href="<%=request.getContextPath() + "/updateReader.jsp?readerId=" + reader.getReaderId()%>"
						class="FunctionButton">修改</a> <a
						href="<%=request.getContextPath() + "/DeleteReaderServlet?readerId=" + reader.getReaderId()%>"
						onClick="return delConfirm();" class="FunctionButton">删除</a></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/addReader.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
