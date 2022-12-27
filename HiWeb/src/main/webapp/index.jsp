<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp의 바로밑 상위 파일이므로 그냥 바로 실행된다. (web-inf안에 있는게 아니다.) -->
	<h3>첫페이지.</h3>
	<jsp:forward page="main.do"></jsp:forward>
</body>
</html>