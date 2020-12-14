<%@page import="www.novel.entity.NovelChapter"%>
<%@page import="www.novel.dao.NovelChapterDao"%>
<%@page import="www.novel.dao.NovelDao"%>
<%@page import="www.novel.entity.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>深夜小说网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<%@ include file="source.jsp"%>

</head>
<body>

	<script>
		top_bar()
	</script>
	<!--中心区域-->
	<div class="main">
		<%@ include file="header.jsp"%>
		<%@ include file="left.jsp"%>
		<div id="centerm">
			<!--BOOKcat-->
			<div class="cl" style="height: 8px;"></div>
			<div class="bdtop"></div>
			<div class="bdsub">
				<dl id="content">
					<dt>文章列表</dt>
					<dd>
						<script>
							show_class2();
						</script>
						<table style="width: 736px;" cellspacing="1" cellpadding="0"
							bgcolor="#E4E4E4">
							<tbody>
								<tr bgcolor="#F2F2F2">
									<th width="18%" align="center">文章名称</th>
									<th width="20%" align="center">最新章节</th>
									<th width="12%" align="center">作者</th>
									<th width="12%" align="center">更新</th>
									<th width="6%" align="center">状态</th>
								</tr>
								<%
									NovelDao novelDao1 = new NovelDao();
									NovelChapterDao nChapterDao = new NovelChapterDao();
									String type = request.getParameter("type");
									System.out.println(type);

									ArrayList<Novel> list2 = (ArrayList) novelDao1.getTypeNovelList(type);
									if (!(list2.isEmpty())) {
										for (int i = 0; i < list2.size(); i++) {
											Novel novel = list2.get(i);
											 novel.setNovelChapter(nChapterDao.getChaptersById(novel.getNovelId() + ""));
								%>
								<tr bgcolor="#FFFFFF">
									<td class="L"><a
										href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"><%=novel.getNovelName()%></a></td>
									<td class="L"><a
										href="<%=request.getContextPath() + "/foreground/articledetail.jsp?novelId=" + novel.getNovelId()%>"
										title="<%=novel.getNovelName()%>" target="_blank"><%=novel.getNovelChapter().getChapterName()%></a></td>
									<td class="C"><%=novel.getNovelAuthor()%></td>
									<td class="C"><%=novel.getNovelChapter().getChapterDateTime()%></td>
									<td class="C"><%=novel.getNovelState()%></td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
						</table>
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