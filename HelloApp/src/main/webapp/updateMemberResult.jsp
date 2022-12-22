<%@page import="co.dev.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMemberResult.jsp</title>
</head>
<body>
	<%
		Member vo = (Member) request.getAttribute("memberInfo");
	%>
	
	<h3><%=vo.getMemberId() %>님의 정보가 수정되었습니다!</h3>
	<a href = "index.jsp">처음으로</a>
	
</body>
</html>