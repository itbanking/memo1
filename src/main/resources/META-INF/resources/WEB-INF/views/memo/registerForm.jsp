<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록페이지</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	 $( function() {
    	$( "#datepicker").datepicker({
    		dateFormat: 'yy-mm-dd'
    	});
  } );
	
</script>
</head>
<body>

	<form:form action="/memo/register" method="post" modelAttribute="memo">
		<label for="mno">글번호 : </label><form:input path="mno" type="text" readonly="true"/><br>
		<label for="title">제목 : </label><form:input path="title" type="text"/><br>
		<label for="mcontent">내용 : </label><br><form:textarea path="mcontent" rows="25" cols="100"/><br>
		<label for="mdate">작성일 : </label><form:input path="mdate" type="text" id="datepicker"/><br>
		<label for="membername">작성자 : </label><form:input path="membername" type="text"/><br>
		<input type="submit" value="저장하기">
	</form:form>

</body>
</html>