<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateMemberForm</title>
</head>
<body>
	<form action = "updateMemberServlet">
		아이디: <input type = "text" name = "id"><br>
		비밀번호: <input type = "text" name = "pw"><br>
		전화번호: <input type = "text" name = "phone"><br>
		주소: <input type = "text" name = "add"><br>
		<input type = "submit" value = "제출">
	</form>
</body>
</html>