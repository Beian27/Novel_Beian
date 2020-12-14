<%@page import="www.novel.dao.NovelDao"%>
<%@page import="www.novel.entity.NovelChapter"%>
<%@page import="java.util.List"%>
<%@page import="www.novel.entity.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.dao.NovelChapterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>全文阅读 - 深夜小说网</title>
<%@ include file="source.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta http-equiv="Cache-Control" content="no-transform">
</head>
<body>
	<%@ include file="header.jsp"%>
	<%
		//根据小说ID获取内容
		String novelId = request.getParameter("novelId");
		Novel novel = new Novel();
		NovelDao nDao = new NovelDao();
		novel = nDao.noveldetail(novelId);
		
	%>
	<%
		//判断用户是否登录，已经登录则可以进行，否则弹出登录对话框
		Reader reader1 = new Reader();
		String url = "";
		String path1 = request.getContextPath();
		if (request.getSession().getAttribute("readers") != null) {
			reader1 = (Reader) request.getSession().getAttribute("readers");
			//返回读者的ID
			url = reader1.getReaderId() + "";
		} else {
			//弹出登录框
			url = "javascript:showDialog()";
		}
	%>
	<div id="a_main">
		<div class="bdtop"></div>
		<div class="bdsub">
			<dl>
				<dt>
					<p class="fr">
						<%
							//判断用户是否登录
							if (request.getSession().getAttribute("readers") != null) {
								//登录后链接可用
						%>
						<a rel="nofollow"
							href="<%=request.getContextPath() + "/AddBookToBookshelfServlet?novelId=" + novelId + "&readerId="
						+ url%>">加入书架</a>
						<%
							} else {
								//链接不可用，提示
						%>
						<a rel="nofollow" href="javascript:void(0) ;"
							onclick="javascript:alert('未登录！');">加入书架</a>
						<%
							}
						%>
						| <a rel="nofollow" onclick="javascript:alert('推荐成功！');"
							href="<%=request.getContextPath() + "/AddRecommendationServlet?novelId=" + novelId%>">推荐本书</a>
						| <a
							href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novelId%>">返回书页</a>
					</p>

					<a href="${pageContext.request.contextPath}/foreground/index.jsp">主页</a>-&gt;
					<a href=""><%=novel.getNovelClassify()%></a> -&gt; <a href=""><%=novel.getNovelName()%></a>

				</dt>
				<dd>
					<h1><%=novel.getNovelName()%>最新章节
					</h1>
				</dd>
				<div class="adlist">
					<script>
						show_list();
					</script>
				</div>
				<dd>
					<h3>
						作者：<%=novel.getNovelAuthor()%></h3>
					<br>
					<h3>
						更新时间：<%=novel.getNovelChapter().getChapterDateTime()%></h3>
				</dd>
				<dd></dd>

				<table id="at" cellspacing="1" cellpadding="0" bgcolor="#E4E4E4">
					<tbody>
						<%
							NovelChapterDao nChapterDao = new NovelChapterDao();
							ArrayList<Novel> novels = nChapterDao.getChapters(novelId);
							if (novels.size() < 5) {
						%>
						<tr>
						<%
						for (int i = 0; i < novels.size(); i++) {
							novel = novels.get(i);
						%>
							<td class="L"><a href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=content&chapterId=<%=novel.getNovelChapter().getChapterId()%>&novelId=<%=novel.getNovelId() %>"><%=novel.getNovelChapter().getChapterName()%></a></td>
					<%
						}
					%>
						</tr>
						<%
							} else {
								//判断列表上是否满足每行5列，不满足则最后加1行
								int rows = novels.size() % 5 == 0 ? novels.size() / 5 : novels.size() / 5 + 1;
								novel = new Novel();
								//总行数
								for (int i = 0; i < rows; i++) {

									List<Novel> list2 = new ArrayList<Novel>();
						%><tr>
							<!-- 遍历每行五列 -->
							<%
								try {
											list2 = novels.subList(5 * i, 5 * (i + 1));
											for (int j = 0; j < list2.size(); j++) {
												novel = list2.get(j);
							%>

							<td class="L"><a
								href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=content&chapterId=<%=novel.getNovelChapter().getChapterId()%>&novelId=<%=novel.getNovelId() %>"><%=novel.getNovelChapter().getChapterName()%></a></td>
							<%
								}
							%>
							<%
								} catch (IndexOutOfBoundsException e) {
											//遍历最后一行
											list2 = novels.subList(5 * i - 1, novels.size());
											for (int j = 0; j < list2.size(); j++) {
												novel = list2.get(j);
							%>
							<!-- 最后一行 -->
							<td class="L"><a
								href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=content&novelId=<%=novel.getNovelId() %>&chapterId=<%=novel.getNovelChapter().getChapterId()%>"><%=novel.getNovelChapter().getChapterName()%></a></td>
							<!-- 最后一行 -->
							<%
								}
							%>
							<%
								}
							%>
						</tr>
						<%
							}
							}
						%>


					</tbody>
				</table>
				<script>
					show_list2();
				</script>
				<dd class="tags">
					<b>Tags：</b>
					<%=novel.getNovelName()%>最新章节&nbsp;&nbsp;|
					<%=novel.getNovelName()%>全文阅读 &nbsp;&nbsp;|<%=novel.getNovelName()%>&nbsp;&nbsp;|
					<%=novel.getNovelAuthor()%>
				</dd>

			</dl>
		</div>
	</div>
	<div class="cl" style="height: 8px;"></div>
	<!-- 尾部 -->
	<%@ include file="footer.jsp"%>

</body>
</html>