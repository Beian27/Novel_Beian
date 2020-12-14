<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="div1">
    <p></p>
</div>
<button id="btn1">获取html</button>
<script type="text/javascript" src="${pageContext.request.contextPath}/style/wangEditor.min.js""></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1')
    editor.create()
    document.getElementById('btn1').addEventListener('click', function () {
        // 读取 html
        alert(editor.txt.html())
    }, false)
</script>