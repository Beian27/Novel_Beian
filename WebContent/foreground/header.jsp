<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.dao.NovelClassifyDao"%>
<%@page import="www.novel.entity.NovelClassify"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="www.novel.entity.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="main m_head">
	<div class="h_logo fl">
		<a href="${pageContext.request.contextPath}/foreground/index.jsp"><img
			src="${pageContext.request.contextPath}/style/images/logo.png"
			alt="深夜小说网"></a>
	</div>
	<%
		//判断用户是否登录，已经登录则可以进行评论，否则弹出登录对话框
		Reader reader = new Reader();
		String urls = "";
		String path = request.getContextPath();
		if (request.getSession().getAttribute("readers") != null) {
			urls = path + "/foreground/bookself.jsp";
		} else {
			urls = "javascript:showDialog()";
		}
	%>
	<div class="h_body fl">
		<div>
			<p class="fr">

				<%
				if (request.getSession().getAttribute("readers") == null) {
			%>
			
			<p class="fr">
				<a href="<%=urls%>" class="current">用户登录</a>&nbsp;&nbsp;|
| <a rel="nofollow" href="javascript:showRegitDialog()">用户注册</a>&nbsp;&nbsp;|
				<%
					} else {
				%>
			
			<p class="fr">
				<a href="" class="current">欢迎回来：&nbsp;${sessionScope.readers.readerName}&nbsp;&nbsp;|</a>
				<a href="${pageContext.request.contextPath}/foreground/ulogout.jsp"
					class="current">注销登录</a>&nbsp;&nbsp;
			</p>
			<%
				}
			%>
			</p>
		</div>
		<div>
			<dl class="fl">
			<li class="so">
				<form action="${pageContext.request.contextPath}/NovelSearchServlet"
					method="get">
					<input type="text" name="q" title="请输入小说名称">
						<input type="submit" value="搜索">
				</form>
				</li>
			</dl>
		</div>
	</div>
</div>
<div class="main m_menu">
	<ul>
		<li class="m_ml"></li>
		<li><a
			href="${pageContext.request.contextPath}/foreground/index.jsp">首页</a></li>
		<%
			NovelClassifyDao classifyDao = new NovelClassifyDao();
			ArrayList<NovelClassify> classifies = (ArrayList) classifyDao.allClassify(null);
			int max = 9;
			if(classifies.size()<9){
				max = classifies.size();
			}
			for (int i = 0; i < max; i++) {
				NovelClassify classify = classifies.get(i);
		%>
				<li><a
			href="${pageContext.request.contextPath}/foreground/articlelist.jsp?type=<%=classify.getNovelClassifyName()%>"><%=classify.getNovelClassifyName() %></a></li>
		<%
			}
		%>
		<li><a href="${pageContext.request.contextPath}/foreground/moreclassify.jsp">更多分类</a></li>
		<li><a href="${pageContext.request.contextPath}/Author/login.jsp">作者专区</a></li>
		<%
			if (request.getSession().getAttribute("readers") != null) {
		%>
		<li class="m_bc"><a id="wdsj" rel="nofollow" href="<%=urls%>"><img
				alt=""
				src="${pageContext.request.contextPath}/style/images/wamcc.png"></a></li>
		<%
			}
		%>

		<li class="m_mr"></li>
	</ul>
</div>
