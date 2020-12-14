<%@page import="www.novel.entity.NovelClassify"%>
<%@page import="www.novel.dao.NovelClassifyDao"%>
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
					深夜小说网--更多小说分类
				</dt>
				<abbr> <bdo id="s_dd">
						<%
							NovelClassifyDao classifyDao1 = new NovelClassifyDao();
							ArrayList<NovelClassify> classifies1 = (ArrayList) classifyDao1.allClassify(null);
							for (int i = 0; i < classifies1.size(); i++) {
								NovelClassify classify = classifies1.get(i);
						%>
						<dd
							style="float: left; display: inline; padding: 20px 0 8px 21px; width: 20px; font-size: 15px; text-align: center;">
							<br> <a
								href="${pageContext.request.contextPath}/foreground/articlelist.jsp?type=<%=classify.getNovelClassifyName()%>"
								target="_blank"><%=classify.getNovelClassifyName()%></a>
						</dd>
						<%
							}
						%>
					</bdo>
				</abbr>
			</dl>
		</div>
	</div>

	<div class="cl" style="height: 8px;"></div>
	<%@ include file="footer.jsp"%>
</body>
</html>