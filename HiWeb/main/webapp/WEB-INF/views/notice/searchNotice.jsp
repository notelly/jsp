<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>상세화면.</h3>
<form name="myFrm" action="updateNotice.do">
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
			<td><input type="text" name="title" value="${vo.noticeTitle }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="subject" cols=30 rows=5>${vo.noticeSubject }</textarea></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${vo.hitCount }</td>
		</tr>
		<c:choose>
			<c:when test="${id == vo.noticeWriter }">
				<tr>
					<td colspan="2">
					<input class="btn btn-primary" type="submit" value="수정">
					<input class="btn btn-primary" type="button" value="삭제" onclick="delFunc()"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2">
					<input class="btn btn-primary" disabled type="submit" value="수정">
					<input class="btn btn-primary" disabled type="button" value="삭제" onclick="delFunc()"></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</form>
<script>
	function delFunc() {
		let myFrm = document.querySelector('form[name="myFrm"]');
		myFrm.action = "deleteNotice.do"; //누르면 deleteNotice.do가 실행된다.
		myFrm.submit(); //form submit 이벤트 발생.
	}
</script>