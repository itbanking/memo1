<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageMemos</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<c:forEach var="memos" items="${page.memos}">
		<a href="/memo/item/${memos.mno}">${memos.mno}</a> , ${memos.title}, ${memos.mcontent}, ${memos.mdate}, ${memos.membername} <br>
	</c:forEach>
		<c:forEach var="i" begin="${page.pagination.firstPage}" end="${page.pagination.lastPage}" >
		<a href="/memo/page/${i}">${i}</a>
	</c:forEach>
	
</body>
</html>