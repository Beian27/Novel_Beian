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
	<div class="main board">
		<div class="bdtop"></div>
		<div class="bdsub">
			<dl id="s_dl">
				<dt>
					<p id="s_dt"></p>
					深夜小说网排行榜
				</dt>
				<abbr><bdo id="s_dd">
						<%
							NovelDao novelDao = new NovelDao();
							ArrayList<Novel> novels = (ArrayList) novelDao.getNovels();

							for (int i = 0; i < novels.size(); i++) {
								Novel novel = novels.get(i);
						%>
						<dd>
							<a
								href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>">
								<img src="<%=novel.getNovelImage()%>"
								alt="<%=novel.getNovelName()%>">
							</a><br> <a
								href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
								target="_blank"><%=novel.getNovelName()%></a>
						</dd>
						<%
							}
						%>

					</bdo></abbr>
			</dl>
		</div>
	</div>
	<div class="main">
		<div id="centeri">
			<div class="block">
				<div class="blocktitle">
					<i></i>最近更新
				</div>
				<div class="blockcontent">
					<ul class="update">
						<%
							NovelChapterDao nChapterDao = new NovelChapterDao();
							ArrayList<Novel> novelBaseInfos = (ArrayList) novelDao.getrecentUpdates();
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
						<li class="more"><a
							href="${pageContext.request.contextPath}/foreground/articlelist.jsp?type=zjgx">更多...</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="right">
			<div class="block">
				<div class="blocktitle">
					<span>总推荐榜</span>
				</div>
				<div class="blockcontent">
					<ul class="ultop">
						<%
							ArrayList<Novel> list = (ArrayList) novelDao.getRecommendationList();
							for (int i = 0; i < list.size(); i++) {
								Novel novel = list.get(i);
						%>
						<li><p><%=novel.getRecommendation().getRecommendationNovelCount()%></p>
							<a
							href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
							target="_blank"><%=novel.getNovelName()%></a></li>
						<%
							}
						%>
						<li style="list-style: none; text-align: right; border: none;"><a
							href="${pageContext.request.contextPath}/foreground/articlelist.jsp?type=tjxs">更多...</a></li>
					</ul>
				</div>
			</div>
			<div class="block">
				<div class="blocktitle">
					<span>最新小说</span>
				</div>
				<div class="blockcontent">
					<ul class="ultop">
						<%
							ArrayList<Novel> list1 = (ArrayList) novelDao.getlatestNovelList();
							int length = 0;
							if (list1.size() >= 17) {
								length = 17;
							} else {
								length = list1.size();
							}
							for (int i = 0; i < length; i++) {
								Novel novel = list1.get(i);
								NovelChapter chapter = nChapterDao.getChaptersById(novel.getNovelId() + "");
								String chapterDatatime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
								if (chapter != null) {
									chapterDatatime = chapter.getChapterDateTime();
								}
						%>
						<li><p><%=chapterDatatime%></p> <a
							href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
							target="_blank"><%=novel.getNovelName()%></a></li>
						<%
							}
						%>
						<li style="list-style: none; text-align: right; border: none;"><a
							href="${pageContext.request.contextPath}/foreground/articlelist.jsp?type=zxxs">更多...</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="cl" style="height: 8px;"></div>

	<%@ include file="footer.jsp"%>
</body>
</html>