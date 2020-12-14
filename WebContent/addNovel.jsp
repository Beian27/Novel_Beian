
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.util.BeetlSQLUtil"%>
<%@page import="www.novel.entity.NovelClassify"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
.img-responsive {
	display: block;
	height: auto;
	max-width: 100%;
}
</style>
</head>
<body>
	<%
		//获取小说类型
		List<NovelClassify> novelClassifies = new ArrayList<NovelClassify>();
		novelClassifies = BeetlSQLUtil.getSQLManager().all(NovelClassify.class);
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
					<!-- 表单内容 -->
					<form action="${pageContext.request.contextPath}/NovelAddSerlvet"
						method="post" id="forms">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<!-- <input type="hidden" name="novelId" value="addNovel"> -->
								<td width="80px">小说标题：</td>
								<td><input type="text" required name="noveltitle"
									class="InputStyle" /> *</td>
							</tr>
							<tr>
								<td width="80px">内容简介：</td>
								<td>
									<div id="editor"></div> <input type="hidden" name="text.value"
									id="txt" />
								</td>
							</tr>
							<tr>
								<td width="80px">作者：</td>
								<td><input required="required" type="text"
									name="novelauthor" class="InputStyle" /> *</td>
							</tr>
							<tr>
								<td width="80px">小说类型：</td>
								<td><select name="novelclassify" style="width: 80px">
										<%
											for (int i = 0; i < novelClassifies.size(); i++) {
												NovelClassify nClassify = novelClassifies.get(i);
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
							<tr>
								<td></td>
								<td><img class="img-responsive" alt=""
									src="${sessionScope.msg}"> <input type="hidden"
									name="image" value="${sessionScope.msg}"></td>
							</tr>
						</table>
					</form>
					<!-- 表单操作 -->
					<div>
						<form action="${pageContext.request.contextPath}/UploadServlet"
							method="post" enctype="multipart/form-data" target="frameName"
							id="uploadimgform">
							<input type="file" id="file" name="file" class="upload"
								onchange="validate_img(this);">
						</form>
						<iframe id="id_iframe" name="frameName" style="display: none;">
							<img alt="" src="${sessionScope.msg}">
						</iframe>
					</div>
				</div>
			</div>
		</div>

		<div id="InputDetailBar">
			<button class="FunctionButtonInput">添加</button>
			<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
		<!-- 		富文本 -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/style/wangEditor.min.js"></script>
			
		<script type="text/javascript">
			var E = window.wangEditor
			var editor = new E('#editor')
			editor.create();
			$("button").click(function() {
				var html = editor.txt.html();
				//获取小说简介的html格式文本
				$("#txt").val(html);
				//判断是否需要提交表单
				isEmpty();
			});
			//判断小说标题或小说作者是否为空
			function isEmpty() {
				if (forms.noveltitle.value == ''
					|| forms.novelauthor.value == '') {
					alert("小说标题或小说作者不能为空");
					return false;
				} else {
					$("#forms").submit();
					return true;
				}
			}
			//上传图片
			function validate_img(ele) {
				$('#uploadimgform').submit();
			}
		</script>

	</div>
</body>
</html>
