<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>상세화면.</h3>
<form action="updateNotice.do"> 
	<input type="hidden" name="num" value="${vo.noticeId}">
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
	<!-- 글번호 작성자 제목 etc를 가지고 와야함. -->
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${vo.noticeId }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.noticeWriter }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type = "text" name="title" value="${vo.noticeTitle }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="subject" cols=30 rows=5>${vo.noticeSubject }</textarea></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hitCount }</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
