<%@page import="www.novel.entity.Reader"%>
<%@page import="www.novel.entity.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.novel.dao.CommentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/bootstrap.css">
<%@ include file="source.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%
		String novelId = request.getParameter("novelId");
		if (request.getParameter("novelId") != null) {
			novelId = request.getParameter("novelId");
		} else if (request.getAttribute("comment") != null) {
			Comment comment = (Comment) request.getAttribute("comment");
			novelId = comment.getCommentNovelId() + "";
		}
		//根据当前的小说ID查询所有的评论

		CommentDao cDao = new CommentDao();
		ArrayList<Comment> comments = cDao.getCommentByNovelId(novelId);
	%>
	<style>
.container {
	width: 1000px;
}

.commentbox {
	width: 900px;
	margin: 20px auto;
	important;
}

.mytextarea {
	width: 100%;
	overflow: auto;
	word-break: break-all;
	height: 100px !important;
	color: #000;
	font-size: 1em;
	resize: none;
}

.comment-list {
	width: 900px;
	margin: 20px auto;
	clear: both;
	
}

.comment-list .comment-info {
/* 	position: relative;
	margin-bottom: 20px;
	margin-bottom: 20px; */
	border-bottom: 1px solid #ccc;
}

/* .comment-list .comment-info header {
	width: 10%;
	position: absolute;
}

.comment-list .comment-info header img {
	width: 100%;
	border-radius: 50%;
	padding: 5px;
} */

.comment-list .comment-info .comment-right {
	padding: 5px 0px 5px 11%;
}

.comment-list .comment-info .comment-right h3 {
	
}

.comment-list .comment-info .comment-right .comment-content-header {
	height: 25px;
}

.comment-list .comment-info .comment-right .comment-content-header span,
	.comment-list .comment-info .comment-right .comment-content-footer span
	{
	padding-right: 2em;
	color: #aaa;
}

.comment-list .comment-info .comment-right .comment-content-header span,
	.comment-list .comment-info .comment-right .comment-content-footer span.reply-btn,
	.send, .reply-list-btn {
	cursor: pointer;
}

.comment-list .comment-info .comment-right .reply-list {
	border-left: 3px solid #ccc;
	padding-left: 7px;
}

.comment-list .comment-info .comment-right .reply-list .reply {
	border-bottom: 1px dashed #ccc;
}

.comment-list .comment-info .comment-right .reply-list .reply div span {
	padding-left: 10px;
}

.comment-list .comment-info .comment-right .reply-list .reply p span {
	padding-right: 2em;
	color: #aaa;
}
</style>
	<script type="text/javascript">
		function isLogin() {
			alert("登录后可以评论");
		}
	</script>

	<div class="container">
		<!-- 评论框 -->
		<%
			//判断用户是否登录，已经登录则可以进行评论，否则弹出登录对话框
			Reader reader1 = new Reader();
			if (request.getSession().getAttribute("readers") != null) {
				reader1 = (Reader) request.getSession().getAttribute("readers");
		%>

		<form action="${pageContext.request.contextPath}/AddCommentServlet"
			method="get">
			<div class="commentbox">
				<input type="hidden" name="commentator"
					value="<%=reader1.getReaderName()%>"> <input type="hidden"
					name="comment_novelid" value="<%=novelId%>">

				<textarea name="commentContent" cols="80" rows="50"
					placeholder="来说几句吧......" class="mytextarea" id="content" required></textarea>
				<input type="submit" class="btn btn-info pull-right" value="评论">
				<!-- <div class="btn btn-info pull-right" id="comment">评论</div> -->
			</div>
		</form>

		<%
			} else {
		%>
		<div class="commentbox">
			<textarea cols="80" rows="50" placeholder="来说几句吧......"
				class="mytextarea" id="content"></textarea>
			<div class="btn btn-info pull-right" id="comment" onClick="isLogin()">评论</div>
		</div>
		<%
			}
		%>
		<!-- 评论框 -->
		<!-- 评论列表 -->
		<%
			for (int i = 0; i < comments.size(); i++) {
				Comment comment = comments.get(i);
		%>
		<div class="comment-list" style="margin-top: 0px;margin-bottom: 0px;">
			<div class="comment-info">
				<%-- <header> <img
					src="${pageContext.request.contextPath}/style/images/img.jpg"></header> --%>
				<div class="comment-right">
					<div style="display: inline-block;"><h3 style="text-align: left; margin-top: 10px;"><%=comment.getCommentator()%></h3>
					<div class="comment-content-header">
						<span><i class="glyphicon glyphicon-time"></i><%=comment.getCommentDate()%></span>
					</div></div>
					<p class="content"><%=comment.getCommentContent()%></p>
					<div class="reply-list"></div>
				</div>
			</div>
		</div>
		<%
			}
		%>
		<!-- 评论列表 -->
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/style/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/style/js/jquery.comment.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/style/js/bootstrap.min.js"></script>

<%@ include file="footer.jsp"%>


</body>
</html>