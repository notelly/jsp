<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>bookList</h3>
<table class=table>
	<thead>
		<tr>
			<th>도서코드</th>
			<th>저자</th>
			<th>제목</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${bookList }">
			<tr>
				<td><a href="searchBook.do?bookCode=${vo.bookCode }">${vo.bookCode }</a></td>
				<td>${vo.bookAuthor }</td>
				<td>${vo.bookTitle }</td>
				<td>${vo.bookPress }</td>
				<td>${vo.bookPrice }</td>	
		</c:forEach>
	</tbody>
</table>
<p><a href="addbookForm.do"><input type="submit" value="등록화면"></a>
	<input type="submit" value="조회화면"></p>
