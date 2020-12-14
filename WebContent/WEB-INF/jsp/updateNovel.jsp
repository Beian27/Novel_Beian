<%@page import="www.novel.entity.NovelClassify"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.entity.Novel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>后台管理</title>
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
		<form id="forms" action="${pageContext.request.contextPath}/NovelUpdateSerlvet"
			method="post">

			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="${pageContext.request.contextPath}/style/images/item_point.gif">
				小说信息添加&nbsp;
			</div>

			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<%
							Novel novelBaseInfo = (Novel) request.getAttribute("novelBaseInfo");
							ArrayList<NovelClassify> classifies = (ArrayList) request.getAttribute("novelClassifies");
						%>
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<input type="hidden" name="novelId"
									value="<%=novelBaseInfo.getNovelId()%>">
								<td width="80px">小说标题：</td>
								<td><input required="required" type="text"
									name="noveltitle" class="InputStyle"
									value=<%=novelBaseInfo.getNovelName()%> /> *</td>
							</tr>
							<tr>
								<td width="80px">内容简介：</td>
								<td>
									<div id="editor"></div> <input type="hidden"
									name="text.value" id="txt" />								
								</td>
							</tr>
							<tr>
								<td width="80px">作者：</td>
								<td><input required="required" type="text"
									name="novelauthor" class="InputStyle"
									value=<%=novelBaseInfo.getNovelAuthor()%> readonly="readonly" />
									*</td>
							</tr>
							<tr>
								<td width="80px">小说类型：</td>
								<td><select name="novelclassify" style="width: 80px">
										<%
											for (int i = 0; i < classifies.size(); i++) {
												NovelClassify nClassify = classifies.get(i);
										%>
										<option><%=nClassify.getNovelClassifyName()%></option>

										<%
											}
										%>
								</select> *</td>
							</tr>
							<tr>
								<td width="80px">状态：</td>
								<td><select name="novelstate" style="width: 80px">
										<option>完本</option>
										<option>连载中</option>
								</select> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<button type="button" id="btnHtml"
					class="FunctionButtonInput">修改</button> 
					<input id="content"
					name="text" type="hidden" value=""> <a
					href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	var E = window.wangEditor
	var editor = new E('#editor')
	// 或者 var editor = new E( document.getElementById('#editor') )
	editor.create();
	editor.txt.html('<%=novelBaseInfo.getNovelDesc()%>');
	$("#btnHtml").click(function() {
		var html = editor.txt.html();
		$("#txt").val(html);
		isEmpty();
	});
	//判断小说标题或小说作者是否为空
	function isEmpty() {
		if (forms.noveltitle.value == '') {
			alert("小说标题不能为空");
			return false;
		} else {
			$("#forms").submit();
			return true;
		}
	}
	</script>
</body>
</html>
