<%@page import="www.novel.entity.NovelChapter"%>
<%@page import="www.novel.dao.NovelChapterDao"%>
<%@page import="www.novel.entity.Reader"%>
<%@page import="www.novel.dao.NovelDao"%>
<%@page import="www.novel.entity.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta http-equiv="Cache-Control" content="no-transform">
<title>深夜小说阅读网</title>

<%@ include file="source.jsp"%>
</head>
<body>
	<script>
		top_bar()
	</script>
	<%@ include file="header.jsp"%>
	<div class="main">
		<div id="centeri">
			<div class="block">
				<div class="blocktitle">
					<i></i>搜索结果
				</div>
				<div class="blockcontent">
					<ul class="update">
						<%
							NovelDao novelDao = new NovelDao();
							NovelChapterDao nChapterDao = new NovelChapterDao();
							ArrayList<Novel> novelBaseInfos = (ArrayList) request.getAttribute("novels");
							/* ArrayList<Novel> novelBaseInfos = (ArrayList) novelDao.getrecentUpdates(); */
							int len = 0;
							if (novelBaseInfos.size() >= 30) {
								len = 30;
							} else {
								len = novelBaseInfos.size();
							}
							for (int i = 0; i < len; i++) {
								Novel novel = novelBaseInfos.get(i);
								NovelChapter chapter = nChapterDao.getChaptersById(novel.getNovelId() + "");
						%>
						<li><p class="ul1">
								<a
									href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>">[<%=novel.getNovelClassify()%>]
								</a>&nbsp;&nbsp;《<a class="poptext"
									href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
									target="_blank"><%=novel.getNovelName()%></a>》
							</p>
							<p class="ul2">
								<a
									href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
									target="_blank"><%=chapter.getChapterName()%></a>
							</p>
							<p claass="ul3"><%=novel.getNovelAuthor()%></p><%=chapter.getChapterDateTime()%></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>
		<div class="cl" style="height: 8px;"></div>

		<%@ include file="footer.jsp"%>
</body>
</html>