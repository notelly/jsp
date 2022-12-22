<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 회원조회화면(form): id => 2. 조회처리 서블릿: 디비검색 결과-> 3. 회원조회처리결과화면(form) -->
	
	<form action = "getMember"> <!-- getMemberServlet으로 이미 구현해뒀다. -->
		조회할 아이디: <input type = "text" name = "id"><br>
		<input type = "submit" value = "조회">
		
	
	</form>
	
</body>
</html>