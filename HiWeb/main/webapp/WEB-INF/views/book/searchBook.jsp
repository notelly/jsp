<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>상세화면(bookDetail)</h3>

	<table class="table">
		<tr>
			<th>도서코드</th>
			<td><input type="text" name="bookCode" value="${bookCode }">
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="bookTitle" value="${vo.bookTitle }">
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="bookAuthor" value="${vo.bookAuthor }">
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="bookPress" value="${vo.bookPress }">
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="bookPrice" value="${vo.bookPrice }">
		</tr>
	</table>
	<p><input type="submit" value="수정">
		<input type="submit" value="삭제"></p>
