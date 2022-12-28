<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p>도서등록화면(addBookForm.jsp)</p>
<form action="insertBook.do">
	<table class="table">
		<tr>
			<th>도서코드</th>
			<td><input type="text" name="bookCode"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="bookTitle"></td>
		</tr>
		<tr>
			<th>저자</th>
			<td><input type="text" name="bookAuth"></td>
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="bookPress"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="bookPrice"></td>
		</tr>
		<tr>
			<td colspan="2"><a href="bookList.do"><input type = "submit" value="등록"></a>
							<input type = "reset" value="취소"></td>
		</tr>
		
		
	</table>

</form>