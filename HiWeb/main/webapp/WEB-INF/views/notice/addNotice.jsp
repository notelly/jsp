<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>공지사항 등록 페이지</p>
<form action="insertNotice.do">
	<!-- 작성자, 제목, 내용, 등록완성. 결과페이지: 목록(noticeList.jsp) -->
	<table class="table">
				<tr>
					<th>작성자</th>
					<td><input type="hidden" name="writer" value="${id }">${id }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="subject" cols=30 rows=5></textarea></td>
				</tr>
		<c:choose>
			<c:when test="${empty id }">
				<tr>
					<td colspan="2"><input disabled type="submit" value="등록"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2"><input type="submit" value="등록"></td>
				</tr>
			</c:otherwise>

		</c:choose>
	</table>




</form>