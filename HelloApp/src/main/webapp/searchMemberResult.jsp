<%@page import="co.dev.member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchMemberResult.jsp</title>
</head>
<body>

	<%
		Member vo = (Member) request.getAttribute("memberInfo");
	%>
	<h3><%=vo.getMemberId() %>님의 정보</h3>
	<p>비밀번호: <%=vo.getMemberPw() %></p>
	<p>연락처: <%=vo.getMemberPhone() %></p>
	<p>주소: <%=vo.getMemberAddr() %></p>
	<p>입니다</p>

 	<a href = "index.jsp">처음으로</a>
</body>
</html>