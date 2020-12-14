<%@page import="www.novel.entity.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.dao.NovelDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>深夜小说网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<%@ include file="source.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/page_common.js"></script>
</head>
<body onload="checkForm()">
	<%@ include file="header.jsp"%>
	<%
		reader = new Reader();
		reader = (Reader) request.getSession().getAttribute("readers");
		NovelDao novelDao = new NovelDao();
		ArrayList<Novel> novels = novelDao.getMyBookSelfList(reader.getReaderId() + "");
	%>

	<script>
		function checkForm() {
			var flag = true;
			var message = form1.message.value;
			if (message != 'null') {
				alert(message);
				flag = false;
			}
			return flag;
		}
		top_bar()
	</script>
	<div onload="checkForm()">
		<input type="hidden" name="message"
			value="<%=request.getAttribute("message")%>">
	</div>
	<!--中心区域-->
	<div class="main">

		<div>

			<!--BOOKcat-->

			<div class="cl" style="height: 8px;"></div>
			<div class="bdtop"></div>
			<div class="bdsub">
				<dl id="content">

					<script language="javascript">
						function check_confirm() {
							var checkform = document
									.getElementById('checkform');
							var checknum = 0;
							for (var i = 0; i < checkform.elements.length; i++) {
								if (checkform.elements[i].name == 'checkid[]'
										&& checkform.elements[i].checked == true)
									checknum++;
							}
							if (checknum == 0) {
								alert('请先选择要操作的书目！');
								return false;
							}
							var newclassid = document
									.getElementById('newclassid');
							if (newclassid.value == -1) {
								if (confirm('确实要将选中书目移出书架么？'))
									return true;
								else
									return false;
							} else {
								return true;
							}
						}
					</script>

					<table class="grid" width="100%" align="center">
						<tr align="left">

							<th width="15%">文章名称</th>
<!-- 							<th width="30%">最新章节</th>
							<th width="30%">类别</th>
							<th width="20%">添加时间</th> -->
							<th width="7%">操作</th>
						</tr>
						<%
							for (int i = 0; i < novels.size(); i++) {
								Novel novel = novels.get(i);
						%>
						<tr>
							<td><a href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>" target="_blank"><%=novel.getNovelName()%></a>
							</td>
<%-- 							<td><span><a href="" target="_blank"><%=novel.getNovelChapter().getChapterName()%></a></span></td>
							<td><span><a href="" target="_blank"></a><%=novel.getNovelClassify()%></span>
							</td>
							<td><%=novel.getNovelChapter().getChapterDateTime() %></td>  --%>
							<td class="nowrap"><a
								href="<%=request.getContextPath() + "/DeleteServletBookSelf?novelId=" + novel.getNovelId()%>"
								onClick="return delConfirm();" class="FunctionButton">删除</a></td>
						</tr>
						<%
							}
						%>
					</table>
				</dl>
				<div class="cl" style="padding-top: 10px;"></div>
			</div>

			<!--BOOKcat-->


		</div>
		<!--中间部分DIV结束-->


	</div>
	<!--中心区域结束-->


	<div class="cl" style="height: 8px;"></div>
<%@ include file="footer.jsp"%>
</body>
</html>