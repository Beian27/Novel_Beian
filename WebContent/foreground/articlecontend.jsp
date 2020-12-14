<%@page import="www.novel.entity.NovelChapter"%>
<%@page import="www.novel.dao.NovelChapterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Cache-Control" content="max-age=0">
<meta http-equiv="Cache-Control" content="no-siteapp">
<meta http-equiv="Cache-Control" content="no-transform">
<title>深夜小说网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">

<%@ include file="source.jsp"%>
</head>
<body style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;">
	<%@ include file="header.jsp"%>
	<%
		//小说ID
			String novelId = request.getParameter("novelId");
			//章节ID
			String chapterId = request.getParameter("chapterId");
			//标记链接，章节列表，上一页，下一页
			String strgoto = request.getParameter("goto");
			String url = "";
			NovelChapterDao chapterDao = new NovelChapterDao();
			NovelChapter nChapter = new NovelChapter();
			if (strgoto.equals("content") || strgoto == null) {
		nChapter = null;
		//小说内容详情
		nChapter = chapterDao.chapterdetail(chapterId);
			} else if (strgoto.equals("previous")) {
		nChapter = null;
		//上一章
		nChapter = chapterDao.Previous(chapterId, novelId);
		//如果已经是第一章，则跳回章节列表
		if (nChapter == null) {
				request.getRequestDispatcher("/foreground/chapterlist.jsp").forward(request, response);
			}
		} else if (strgoto.equals("next")) {
			nChapter = null;
			//下一章
			nChapter = chapterDao.next(chapterId, novelId);
			//如果是最后一章，则跳回章节列表
			if (nChapter == null) {
				request.getRequestDispatcher("/foreground/chapterlist.jsp").forward(request, response);
			}
		}
	%>
	<!-- 工具栏 -->
	<div class="main myset">
		<script>show_pagetop();</script>
	</div>
	<!-- 工具栏 -->
	<div id="a_main">
		<div class="bdtop"></div>
		<div class="bdsub" id="amain"
			style="background: rgb(255, 255, 255) none repeat scroll 0% 0%;">
			<dl>
				<dt>
					<p class="fr">
						<a rel="nofollow" href="Javascript:void(0);" onclick=""
							target="_blank">加入书架</a> | <a rel="nofollow"
							href="Javascript:void(0);" onclick="" target="_blank">推荐本书</a> |
						<a href="">返回书页</a>
					</p>
					<a href="">深夜小说网</a> -&gt; -&gt;
				</dt>
				<dd>
					<h1><%=nChapter.getChapterName()%></h1>
				</dd>
				<div class="adhtml">
					<script>show_htm1();</script>
				</div>
				<dd>
					<h3>
						<a
							href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=previous&novelId=<%=novelId%>&chapterId=<%=nChapter.getChapterId()%>">上一页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/foreground/chapterlist.jsp?novelId=<%=novelId%>">返回最新章节列表</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=next&novelId=<%=novelId%>&chapterId=<%=nChapter.getChapterId()%>">下一页</a>
					</h3>
				</dd>
				<dd id="contents" style="font-size: 22px; color: rgb(0, 0, 0);">

					&nbsp;&nbsp;&nbsp;&nbsp;</dd>
				<div class="adhtml">
					<script>show_htm2();</script>
				</div>
				<dd id="contents" style="font-size: 22px; color: rgb(0, 0, 0);">
					<br>
					<%=nChapter.getChapterContent()%>
				</dd>
				<div class="adhtml">
					<script>show_htm3();</script>
				</div>
				<dd id="tipscent"></dd>
				<dd id="footlink">
					<a
						href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=previous&novelId=<%=novelId%>&chapterId=<%=nChapter.getChapterId()%>">上一页</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/foreground/chapterlist.jsp?novelId=<%=novelId%>">返回最新章节列表</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/foreground/articlecontend.jsp?goto=next&novelId=<%=novelId%>&chapterId=<%=nChapter.getChapterId()%>">下一页</a>
				</dd>
				<div class="adhtml">
					<script>show_htm4();</script>
				</div>
				<dd id="tipsfoot"></dd>
			</dl>
			<div class="cl"></div>
		</div>
	</div>
	<div class="cl" style="height: 8px;"></div>
	<%@ include file="footer.jsp"%>
	<script>show_pagebottom();</script>

	<script type="text/javascript">
	var timer, speed = 5,
	currentpos = 1,
	d = document,
	$ = function(x) {
	    return d.getElementById(x);
	},
	bcolor = $('bcolor');
	var bccolor = $('bccolor');
	var txtcolor = $('txtcolor');
	var fonttype = $('fonttype');
	var scrollspeed = $('scrollspeed');
	function setSpeed() {
	    speed = parseInt(scrollspeed.value);
	    if (speed < 1 || speed > 10) {
	        speed = 5;
	        scrollspeed.value = 5;
	    }
	}
	function stopScroll() {
	    clearInterval(timer);
	}
	function beginScroll() {
	    timer = setInterval("scrolling()", 300 / speed);
	}
	function scrolling() {
	    var currentpos = window.pageYOffset || d.documentElement.scrollTop || d.body.scrollTop || 0;
	    window.scroll(0, ++currentpos);
	    var nowpos = window.pageYOffset || d.documentElement.scrollTop || d.body.scrollTop || 0;
	    if (currentpos != nowpos) clearInterval(timer);
	}
	function setCookies(cookieName, cookieValue, expirehours) {
	    var today = new Date();
	    var expire = new Date();
	    expire.setTime(today.getTime() + 3600000 * 356 * 24);
	    d.cookie = cookieName + '=' + escape(cookieValue) + ';expires=' + expire.toGMTString() + '; path=/';
	}
	function ReadCookies(cookieName) {
	    var theCookie = '' + d.cookie;
	    var ind = theCookie.indexOf(cookieName);
	    if (ind == -1 || cookieName == '') return '';
	    var ind1 = theCookie.indexOf(';', ind);
	    if (ind1 == -1) ind1 = theCookie.length;
	    return unescape(theCookie.substring(ind + cookieName.length + 1, ind1));
	}
	function saveSet() {
	    setCookies("bcolor", bcolor.options[bcolor.selectedIndex].value);
	    setCookies("bccolor", bccolor.options[bccolor.selectedIndex].value);
	    setCookies("txtcolor", txtcolor.options[txtcolor.selectedIndex].value);
	    setCookies("fonttype", fonttype.options[fonttype.selectedIndex].value);
	    setCookies("scrollspeed", scrollspeed.value);
	}
	function loadSet() {
	    var tmpstr;
	    tmpstr = ReadCookies("bcolor");
	    bcolor.selectedIndex = 0;
	    if (tmpstr != "") {
	        for (var i = 0; i < bcolor.length; i++) {
	            if (bcolor.options[i].value == tmpstr) {
	                bcolor.selectedIndex = i;
	                break;
	            }
	        }
	    }
	    tmpstr = ReadCookies("bccolor");
	    bccolor.selectedIndex = 0;
	    if (tmpstr != "") {
	        for (var i = 0; i < bccolor.length; i++) {
	            if (bccolor.options[i].value == tmpstr) {
	                bccolor.selectedIndex = i;
	                break;
	            }
	        }
	    }
	    tmpstr = ReadCookies("txtcolor");
	    txtcolor.selectedIndex = 0;
	    if (tmpstr != "") {
	        for (var i = 0; i < txtcolor.length; i++) {
	            if (txtcolor.options[i].value == tmpstr) {
	                txtcolor.selectedIndex = i;
	                break;
	            }
	        }
	    }
	    tmpstr = ReadCookies("fonttype");
	    fonttype.selectedIndex = 2;
	    if (tmpstr != "") {
	        for (var i = 0; i < fonttype.length; i++) {
	            if (fonttype.options[i].value == tmpstr) {
	                fonttype.selectedIndex = i;
	                break;
	            }
	        }
	    }
	    tmpstr = ReadCookies("scrollspeed");
	    if (tmpstr == '') tmpstr = 5;
	    scrollspeed.value = tmpstr;
	    setSpeed();
	    d.body.style.background = bcolor.options[bcolor.selectedIndex].value;
	    var contentsobj = $('contents');
	    contentsobj.style.fontSize = fonttype.options[fonttype.selectedIndex].value;
	    contentsobj.style.color = txtcolor.options[txtcolor.selectedIndex].value;
	    $('amain').style.background = bcolor.options[bccolor.selectedIndex].value;
	}
	d.onmousedown = stopScroll;
	d.ondblclick = beginScroll;
	loadSet();
	</script>

</body>
</html>