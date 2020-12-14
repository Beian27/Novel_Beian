<%@page import="www.novel.entity.Novel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.dao.NovelDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="left">
	<div class="block">
		<div class="blocktitle wsd">
			<i></i>会员推荐
		</div>
		<div class="blockcontent">
			<ul class="ultop">
				<%
					NovelDao novelDao = new NovelDao();
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
</div>