<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>helloWorld</h3>
	<form action = "addMemberServlet" method ="post"> <%-- 이 페이지를 요청하겠습니다.의 의미 --%>
		<table border = "1">
			<tr>
				<th>ID:</th>
				<td><input type = "text" name = "id" value = "user1"></td>
			</tr>
			<tr>
				<th>PW:</th>
				<td><input type = "password" name = "pw"></td>
			</tr>
			<tr>
				<th>Phone:</th>
				<td><input type = "text" name = "phone"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type = "text" name = "add"></td>
			</tr>
			<tr>
				<th>Rank:</th>
				<td><input type = "text" name = "rank"></td>
			</tr>
			<tr>
				<td colspan = "2"><input type = "submit" value = "저장"></td>
				
			</tr>
		</table>
	</form>
	
</body>
</html>