<%@page import="www.novel.dao.NovelChapterDao"%>
<%@page import="www.novel.entity.NovelChapter"%>
<%@page import="www.novel.dao.RecommendationDao"%>
<%@page import="www.novel.entity.Recommendation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>小说详细 - 最新章节 - 深夜小说网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<%@ include file="source.jsp"%>
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
</script>
<style>
.pl {
	background: #F2F2F2;
	padding-left: 10px;
}
</style>
</head>
<body onload="checkForm()">
	<%@ include file="header.jsp"%>
	<script>
		top_bar()
	</script>

	<!--中心区域-->
	<div class="main">
		<%@ include file="left.jsp"%>
		<div onload="checkForm()">
			<input type="hidden" name="message"
				value="<%=request.getAttribute("message")%>">
		</div>
		<%
			Novel novel = new Novel();
			String novelId = "";
			//推荐数

			//判断是从哪传来的ID
			if (request.getParameter("novelId") != null) {
				novelId = request.getParameter("novelId").toString();
			} else if (request.getAttribute("novel") != null) {
				novel = (Novel) request.getAttribute("novel");
				novelId = novel.getNovelId() + "";
			}
			RecommendationDao rDao = new RecommendationDao();
			int week = rDao.getRecoNumerByweek();
			int month = rDao.getRecoNumerByMonth();
			int count = rDao.getAllRecoNumer(novelId);
			novel = novelDao.noveldesc(novelId);
		%>
		<div id="centerm">
			<!--BOOKcat-->
			<div class="cl" style="height: 8px;"></div>
			<div class="bdtop"></div>
			<div class="bdsub">
				<dl id="content">
					<div class="adhtml">
						<script>
							show_book();
						</script>
					</div>
					<dd>
						<h1><%=novel.getNovelName()%></h1>
					</dd>
					<dd>
						<div class="fl">
							<a class="hst" href=""><img
								style="padding: 7px; border: 1px solid #E4E4E4; width: 120px; height: 150px; margin: 0 25px 0 15px;"
								alt="<%=novel.getNovelName()%>" src="<%=novel.getNovelImage()%>"></a>
						</div>
						<div class="fl" style="width: 550px;">

							<p></p>
							<table id="at" cellspacing="1" cellpadding="0" bgcolor="#E4E4E4">
								<tbody>
									<tr>

										<th>小说类别</th>
										<td>&nbsp;<%=novel.getNovelClassify()%></td>

										<th>小说作者</th>
										<td>&nbsp;<%=novel.getNovelAuthor()%></td>
										<th>小说状态</th>
										<td>&nbsp;<%=novel.getNovelState()%></td>
									</tr>
									<tr>
										<th>总推荐数</th>
										<td>&nbsp;<%=count%></td>
										<th>本月推荐</th>
										<td>&nbsp;<%=month%></td>
										<th>本周推荐</th>
										<td>&nbsp;<%=week%></td>
									</tr>
									<tr>
									<%
										NovelChapterDao nChapterDao = new NovelChapterDao();
										NovelChapter chapter = nChapterDao.getChaptersById(novel.getNovelId() + "");
										String chapterDatatime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
										if (chapter != null) {
											chapterDatatime = chapter.getChapterDateTime();
										}
									%>
										<th>最后更新</th>
										<td>&nbsp;<%=chapterDatatime%></td>
									</tr>
								</tbody>
							</table>
							<p></p>
							<p class="btnlinks">
								<%
									//判断用户是否登录，已经登录则可以进行，否则弹出登录对话框
									Reader reader1 = new Reader();
									String url = "";
									String path1 = request.getContextPath();
									if (request.getSession().getAttribute("readers") != null) {
										reader1 = (Reader) request.getSession().getAttribute("readers");
										url = reader1.getReaderId() + "";
									} else {
										url = "javascript:showDialog()";
									}
									if (novelDao.noveldetail(novelId) == null) {
								%>
								<a class="read" onclick="javascript:alert('该书暂无章节');">最新章节</a>
								<%
									} else {
								%>
								<a class="read"
									href="${pageContext.request.contextPath}/foreground/chapterlist.jsp?novelId=<%=novelId %>"
									title="<%=novel.getNovelName() %>最新章节">最新章节</a>
								<%
									}
								%>

								<%
									//判断用户是否登录
									if (request.getSession().getAttribute("readers") != null) {
								%>
								<a onclick="javascript:alert('加入书架成功！');"
									href="<%=request.getContextPath() + "/AddBookToBookshelfServlet?novelId=" + novelId + "&readerId="
						+ url%>">加入书架</a>
								<%
									} else {
								%>
								<a href="javascript:return false;"
									onclick="javascript:alert('未登录！');">加入书架</a>
								<%
									}
								%>


								<a onclick="javascript:alert('推荐成功！');"
									href="<%=request.getContextPath() + "/AddRecommendationServlet?novelId=" + novelId%>">推荐本书</a>
								<a
									href="${pageContext.request.contextPath}/foreground/novelcomment.jsp?novelId=<%=novelId%>">小说评论</a>
							</p>

						</div>
					</dd>
					<div class="cl"></div>
					<!-- Baidu Button END -->
					<div class="cl"></div>
					<dd style="padding: 10px 30px 0 25px;">
						<p class="pl">
							<b>内容简介：</b>
						</p>
						<table style="padding: 5px 5px 5px 5px;" width="740px"
							cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<tr>

									<td style="padding: 5px 5px 5px 5px;" align="right"><script>
										show_book2();
									</script></td>

									<td style="padding: 5px 5px 5px 5px;" align="left"><script>
										show_book2();
									</script></td>
								</tr>
							</tbody>
						</table>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<%=novel.getNovelDesc()%><br>
						</p>
						<p style="display: none" id="sidename">
							分享书籍《<%=novel.getNovelName()%>》作者：<%=novel.getNovelAuthor()%></p>
						<p style="height: 10px;"></p>
						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;关键字：<u><%=novel.getNovelName()%> <%=novel.getNovelAuthor()%></u>
							<u><%=novel.getNovelName()%>全文阅读</u> <u><%=novel.getNovelName()%>最新章节</u>
						</p>
						<p style="height: 10px;"></p>

					</dd>
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