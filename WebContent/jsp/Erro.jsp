<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示</title>
<!-- 样式文件 -->
<link rel="stylesheet" type="text/css" href="/JavaWeb/css/erro.css"> 
</head>
<body>
<div>
	自动跳转中ing
</div>
<div>
	<% response.setHeader("refresh","3;url="+request.getAttribute("goto")); %>
	<!-- 错误提示 -->
	<%= request.getAttribute("erro")%>
	
</div>
<div>
	<!-- 链接跳转 -->
	<a href="<%= request.getAttribute("goto")%>">点击跳转</a>
	
</div>
</body>
</html>