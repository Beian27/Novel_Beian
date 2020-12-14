<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 尾部 -->
<div class="main footer">
	<div class="bdtop">
		<i></i><span title="0.056211"></span>
	</div>
	<div class="ftc">
		深夜小说网没有弹窗广告，所有小说都能免费阅读。找好看的小说网站，就到深夜小说网。 <br>Copyright © <a
			href="${pageContext.request.contextPath}/foreground/index.jsp">深夜小说网</a>
		All Rights Reserved. <br>
		<script>
			show_foot1();
		</script>
		<script src="${pageContext.request.contextPath}/style/js/pc_pf.js"
			language="JavaScript"></script>
		<script src="${pageContext.request.contextPath}/style/js/pc_pf.js"
			language="JavaScript"></script>
		<script
			src="${pageContext.request.contextPath}/style/js/pf.js?ab_key=k24"></script>
		<script src="${pageContext.request.contextPath}/style/js/pf.htm"></script>

	</div>
</div>
<!-- 尾部 -->

<!-- 登录 -->
<div class="ui-mask" id="mask" onselectstart="return false"
	style="display: none; width: 1920px; height: 1080px;"></div>
<form action="${pageContext.request.contextPath}/log" method="post">
	<div class="ui-dialog" id="dialogMove" onselectstart="return false;"
		style="display: none; left: 532px; top: 312px;">
		<div class="ui-dialog-title" id="dialogDrag"
			onselectstart="return false;">
			登录通行证
			<a onclick="hideDialog()" style="padding-left: 220px;">关闭</a>
		</div>
		<div class="ui-dialog-content">
			<div class="ui-dialog-l40 ui-dialog-pt15">
				<input class="ui-dialog-input ui-dialog-input-username" type="text"
					name="account" placeholder="账号（必填）" required="required">
			</div>
			<div class="ui-dialog-l40 ui-dialog-pt15">
				<input class="ui-dialog-input ui-dialog-input-password"
					type="password" name="password" placeholder="密码（必填）"
					required="required">
			</div>
			<div class="ui-dialog-l40">
				<a href="#">&nbsp;</a>
			</div>
			<div>
				<input type="submit" class="ui-dialog-submit" value="登录">
			</div>
			<div class="ui-dialog-l40">
				<a href="#">&nbsp;</a>
			</div>
		</div>
	</div>
</form>
<!-- 注册 -->
<div class="ui-mask" id="mask1" onselectstart="return false"
	style="display: none; width: 1920px; height: 1080px;"></div>
<form action="${pageContext.request.contextPath}/ReaderAddServlet"
	method="post">
	<div class="ui-dialog" id="dialogMove1" onselectstart="return false;"
		style="display: none; left: 531.5px; top: 311.5px;">
		<div class="ui-dialog-title" id="dialogDrag1"
			onselectstart="return false;">
			注册通行证 <a onclick="hideRegitDialog()" style="padding-left: 220px;">关闭</a>
		</div>
		<div class="ui-dialog-content">
			<div class="ui-dialog-l40 ui-dialog-pt15">
				<input placeholder="用户名（必填）"
					class="ui-dialog-input ui-dialog-input-username" type="text"
					name="readerName" required="required">
			</div>
			<div class="ui-dialog-l40 ui-dialog-pt15">
				<input placeholder="账号（必填）" required="required"
					class="ui-dialog-input ui-dialog-input-username" type="text"
					name="readerAccount">
			</div>
			<div class="ui-dialog-l40 ui-dialog-pt15">
				<input class="ui-dialog-input ui-dialog-input-password"
					placeholder="密码（必填）" type="text" type="password" name="readerPassword"
					required="required"> 
					<input type="hidden" name="zzzq" value="qd">
			</div>
			<div class="ui-dialog-l40">
				<a href="#">&nbsp;</a>
			</div>
			<div>
				<input type="submit" class="ui-dialog-submit" value="立即注册">
			</div>
			<div class="ui-dialog-l40">
				<a href="#">&nbsp;</a>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var dialogInstace, onMoveStartId; //	用于记录当前可拖拽的对象

	//	获取元素对象	
	function g(id) {
		return document.getElementById(id);
	}

	//	自动居中元素（el = Element）
	function autoCenter(el) {
		var bodyW = document.documentElement.clientWidth;
		var bodyH = document.documentElement.clientHeight;

		var elW = el.offsetWidth;
		var elH = el.offsetHeight;

		el.style.left = (bodyW - elW) / 2 + 'px';
		el.style.top = (bodyH - elH) / 2 + 'px';

	}

	//	自动扩展元素到全部显示区域
	function fillToBody(el) {
		el.style.width = document.documentElement.clientWidth + 'px';
		el.style.height = document.documentElement.clientHeight + 'px';
	}

	//	Dialog实例化的方法
	function Dialog(dragId, moveId) {

		var instace = {};

		instace.dragElement = g(dragId); //	允许执行 拖拽操作 的元素
		instace.moveElement = g(moveId); //	拖拽操作时，移动的元素

		instace.mouseOffsetLeft = 0; //	拖拽操作时，移动元素的起始 X 点
		instace.mouseOffsetTop = 0; //	拖拽操作时，移动元素的起始 Y 点

		instace.dragElement.addEventListener('mousedown', function(e) {
			var e = e || window.event;
			dialogInstace = instace;
			instace.mouseOffsetLeft = e.pageX - instace.moveElement.offsetLeft;
			instace.mouseOffsetTop = e.pageY - instace.moveElement.offsetTop;
			// instace.moveElement.style.zIndex = zIndex ++;
		})

		return instace;
	}

	//	在页面中侦听 鼠标弹起事件
	document.onmouseup = function(e) {

		dialogInstace = false;
		clearInterval(onMoveStartId);

	}

	//	在页面中侦听 鼠标移动事件
	document.onmousemove = function(e) {
		var e = e || window.event;
		var instace = dialogInstace;
		if (instace) {

			var maxX = document.documentElement.clientWidth
					- instace.moveElement.offsetWidth;
			var maxY = document.documentElement.clientHeight
					- instace.moveElement.offsetHeight;

			instace.moveElement.style.left = Math.min(Math.max(
					(e.pageX - instace.mouseOffsetLeft), 0), maxX)
					+ "px";
			instace.moveElement.style.top = Math.min(Math.max(
					(e.pageY - instace.mouseOffsetTop), 0), maxY)
					+ "px";
		}
		if (e.stopPropagation) {
			e.stopPropagation();
		} else {
			e.cancelBubble = true;
		}
	};

	//	拖拽对话框实例对象
	Dialog('dialogDrag', 'dialogMove');
	Dialog('dialogDrag1', 'dialogMove1');

	function onMoveStart() {

	}

	//	重新调整对话框的位置和遮罩，并且展现
	function showDialog() {
		g('dialogMove').style.display = 'block';
		g('mask').style.display = 'block';
		autoCenter(g('dialogMove'));
		fillToBody(g('mask'));
	}
	//	重新调整对话框的位置和遮罩，并且展现
	function showRegitDialog() {
		g('dialogMove1').style.display = 'block';
		g('mask1').style.display = 'block';
		autoCenter(g('dialogMove1'));
		fillToBody(g('mask1'));
	}

	//	关闭对话框
	function hideDialog() {
		g('dialogMove').style.display = 'none';
		g('mask').style.display = 'none';
	}
	//	关闭对话框
	function hideRegitDialog() {
		g('dialogMove1').style.display = 'none';
		g('mask1').style.display = 'none';
	}
</script>