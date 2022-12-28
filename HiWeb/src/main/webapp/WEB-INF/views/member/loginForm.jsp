<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 조건문을 쓰려면 위 구문을 써야함 -->
<h3>로그인화면(loginForm.jsp)</h3>

<c:if test="${not empty msg}">
	<p>메세지: ${msg }</p>
</c:if>

<form action="loginCheck.do" method="post"> <!-- 00은 값을 다 넘겨서 비번이랑 주소에 다뜸 post로 값을 안보이게 만들어준다. -->
	<table class="table">
		<tr>
			<th>아이디</th><td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" value="로그인">
						  <input type="reset" value="취소">
			</td>
		</tr>
	
	</table>
</form>