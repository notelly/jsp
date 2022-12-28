<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>회원목록(memberList.do)</h3>
<table class=table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
				<th>주소</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${memberList }">
				<tr>
					<td>${vo.memberId}</td>
					<td>${vo.memberName}</td>
					<td>${vo.memberPhone}</td>
					<td>${vo.memberAddr}</td>
				<c:choose>
					<c:when test="${rank == 'Admin' }">
						<td><input type="submit" value="삭제"></td>
					</c:when>
					<c:otherwise>
						<td><input disabled type="submit" value="삭제"></td>
					</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</tbody>

</table>