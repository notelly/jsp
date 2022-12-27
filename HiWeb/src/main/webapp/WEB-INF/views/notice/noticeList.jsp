<%@page import="co.yedam.notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<h3>공지사항 목록 페이지.</h3>
페이지 정보: ${pageNum }, ${searchCondition }, ${keyword }
<form action="noticeList.do" method="post">
<select name="searchCondition">
	<option disable>::선택하세요;;</option>
	<option value="writer" ${searchvo.searchCondition == 'writer' ? 'selected' : '' }>작성자</option>
	<option value="title"  ${searchvo.searchCondition == 'title' ? 'selected' : '' }>제목</option>
	<option value="subject"  ${searchvo.searchCondition == 'subject' ? 'selected' : '' }>내용</option>
	
</select>
<input type="text" name="keyword" value="${searchvo.keyword }">
<input type="submit" value="조회">
</form>
<br>
<table class=table>
	<thead>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>글내용</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${noticeList }">
			<tr>
				<td><a href="searchNotice.do?num=${vo.noticeId }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}&pageNum=${pageDTO.cri.pageNum}">${vo.noticeId }</a></td>
				<td>${vo.noticeWriter }</td>
				<td>${vo.noticeTitle }</td>
				<td>${vo.noticeSubject }</td>
				<td>${vo.noticeDate }</td>
				<td>${vo.hitCount }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p></p>
<div class="center">
	<div class="pagination">
		<c:if test="${pageDTO.prev }">
			<a href="noticeList.do?pageNum=${pageDTO.startPage-1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">&laquo;</a>
		</c:if>
		<!-- 반복문 쓰겠다 forEach jstel로 쓴 반복문 var ="item" item 뒤에 값을 item 넣어준다.-->
		<c:forEach var="item" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
			<c:choose>
				
				<c:when test="${pageDTO.cri.pageNum == item }">
					<a class="active" href="noticeList.do?pageNum=${item }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a>
				</c:when> 
				<c:otherwise>
					<a href="noticeList.do?pageNum=${item }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">${item }</a>
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
		<c:if test="${pageDTO.next }">
			<a href="noticeList.do?pageNum=${pageDTO.endPage+1 }&searchCondition=${searchvo.searchCondition}&keyword=${searchvo.keyword}">&raquo;</a>
		</c:if>
	</div>
</div>