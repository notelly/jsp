<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>공지사항 등록 페이지</p>
<form action="insertNotice.do" >
	<!-- 작성자, 제목, 내용, 등록완성. 결과페이지: 목록(noticeList.jsp) -->
	<table class="table">
		<tr>
			<th>작성자</th>
			<td><input type = "text" name="writer"></td>	
		</tr>
		<tr>
			<th>제목</th>
			<td><input type = "text" name="title"></td>	
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="subject" cols=30 rows=5></textarea></td>	
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="등록"></td>
		</tr>
	</table>
</form>