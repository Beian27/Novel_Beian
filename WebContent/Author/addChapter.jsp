
<%@page import="www.novel.util.BeetlSQLUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.entity.NovelClassify"%>
<%@page import="www.novel.entity.Author"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>作者专区</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/page_common.js"></script>
<!--引入 jquery.js-->
<script
	src="${pageContext.request.contextPath}/style/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>

<!--引入 fontawesom-4.2.0-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/fontawesome-4.2.0/css/font-awesome.min.css">
<!--[if IE]>
    <link rel="stylesheet" type="text/css" href="fontawesome-4.2.0/css/font-awesome-ie7.min.css">
    <![endif]-->

<link
	href="${pageContext.request.contextPath}/style/css/common_style_blue.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/index_1.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/wangEditor.js"></script>
<script type="text/javascript">
	function openWin() {
		window.open('common_page_list.html');
		this.close();
	}
</script>
</head>
<body>
	<%
		//获取当前作者
		Author author = (Author) request.getSession().getAttribute("author");
		//获取小说类型
		List<NovelClassify> novelClassifies = new ArrayList<NovelClassify>();
		novelClassifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
		String novelId = request.getParameter("novelId");
	%>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				添加
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="${pageContext.request.contextPath}/AddChapterServlet"
			method="post" id="form">
			<input type="hidden" name="zzzq" value="zzzq">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="${pageContext.request.contextPath}/style/images/item_point.gif">
				小说章节信息添加&nbsp;
			</div>

			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<input type="hidden" name="novelId" value="<%=novelId%>">
								<td width="80px">章节标题：</td>
								<td><input required="required" type="text"
									name="chaptertitle" class="InputStyle" value= /> *</td>
							</tr>
							<tr>
								<td width="80px">章节内容</td>
								<td>
									<div id="editor">
										<p>
											欢迎使用wangEditor富文本编辑器
										</p>
									</div> <input type="hidden" name="text.value" id="txt" />
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<button class="FunctionButtonInput">添加</button>
				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>

		<!-- 富文本 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/style/wangEditor.min.js"></script>
		<script type="text/javascript">
			var E = window.wangEditor
			var editor = new E('#editor')
			// 或者 var editor = new E( document.getElementById('#editor') )
			editor.create();
			$("button").click(function() {
				var html = editor.txt.html();
				$("#txt").val(html);
				$("#form").submit();
			})
		</script>

	</div>
</body>
</html>
