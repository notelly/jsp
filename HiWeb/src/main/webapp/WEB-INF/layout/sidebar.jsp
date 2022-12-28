<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="border-end bg-white" id="sidebar-wrapper">
	<c:choose>
		<c:when test="${not empty id }">
		    <div class="sidebar-heading border-bottom bg-light">${name }님, ${msg }</div>
		
		</c:when>
		<c:otherwise>
			<div class="sidebar-heading border-bottom bg-light">손님입니다.</div>
		</c:otherwise>
	</c:choose>
		
    <div class="list-group list-group-flush">
	<c:choose>
		<c:when test="${not empty id }">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logOut.do">로그아웃</a>
		</c:when>
		<c:otherwise>
		
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
		</c:otherwise>
	</c:choose>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="noticeList.do">공지사항목록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addNotice.do">공지사항등록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addMemberForm.do">회원등록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원목록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="addbookForm.do">도서등록</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="bookList.do">도서목록</a>
    </div>
</div>