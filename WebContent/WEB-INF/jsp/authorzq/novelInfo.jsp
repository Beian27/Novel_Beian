<%@page import="www.novel.entity.Novel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
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
					src="style/images/title_arrow.gif" /> 小说列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/NovelListServlet"
			method="post">
			<input type="text" name="q" title="请输入小说名称"> <input
				type="submit" value="搜索"> <input type="hidden" name="zzzq"
				value="zzzq">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td align="center">小说编号</td>
					<td align="center">小说标题</td>
					<td align="center">小说作者</td>
					<td align="center">小说分类</td>
					<td align="center">状态</td>
					<td align="center">操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<%
					ArrayList<Novel> novelBaseInfos = (ArrayList) request.getAttribute("novelBaseInfos");
					for (int i = 0; i < novelBaseInfos.size(); i++) {
						Novel novelBaseInfo = novelBaseInfos.get(i);
				%>
				<tr class="TableDetail1">
					<td align="center"><%=novelBaseInfo.getNovelId()%></td>
					<td align="center"><%=novelBaseInfo.getNovelName()%></td>
					<td align="center"><%=novelBaseInfo.getNovelAuthor()%></td>
					<td align="center"><%=novelBaseInfo.getNovelClassify()%></td>
					<td align="center"><%=novelBaseInfo.getNovelState()%></td>
					<td align="center"><a
						href="<%=request.getContextPath() + "/updateNovelBaseInfo.jsp?zzzq=zzzq&novelBaseInfoId="
						+ novelBaseInfo.getNovelId()%>"
						class="FunctionButton">修改</a> <a
						href="<%=request.getContextPath() + "/DeleteNovelServlet?zzzq=zzzq&novelBaseInfoId="
						+ novelBaseInfo.getNovelId()%>"
						onClick="return delConfirm();" class="FunctionButton">删除</a>
						<a class="FunctionButton" href="${pageContext.request.contextPath}/Author/addChapter.jsp?novelId=<%=novelBaseInfo.getNovelId()%>">添加章节</a></td>
					
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/Author/addNovel.jsp?">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
