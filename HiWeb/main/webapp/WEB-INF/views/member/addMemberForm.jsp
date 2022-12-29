<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>회원 정보 등록 기능</p>
<form action = "insertMember.do">
	<table class="table">
		<tr>
			<th>회원아이디</th>
			<td><input type="text" name="memId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="memPw"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="memName"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="memNum"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="memAddr"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="등록"></td>
	</table>
</form>