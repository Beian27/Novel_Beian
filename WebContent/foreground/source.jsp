<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/style-1.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/style.css"
	type="text/css">

<script src="${pageContext.request.contextPath}/style/push.js"></script>
<script
	src="https://hm.baidu.com/hm.js?f040723b21992f74b48618af56517fbb"></script>
<script src="${pageContext.request.contextPath}/style/js/push.js"></script>
<script src="${pageContext.request.contextPath}/style/js/hm.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/style/js/xiaoshuo.js"></script>
<script type="text/javascript">
function uaredirect(murl){  
 try{  
 if(document.getElementById("bdmark") != null) {  
 return 
 }  
 var urlhash = window.location.hash;  
 if(!urlhash.match("fromapp")){  
 if((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iPad)/i))){  
location.replace(murl);  
 }  
}  
}catch(err){}  
}  
uaredirect("${pageContext.request.contextPath}/foreground/index.jsp");  
</script>