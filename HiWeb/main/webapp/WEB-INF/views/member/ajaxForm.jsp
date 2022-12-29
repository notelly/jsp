<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="center">
		<h3>Ajax연습(ajaxForm.jsp)</h3>
		<table class="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="mid"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="mname"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" id="mphone"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="maddr"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" id="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><button class="btn btn-primary" id="addBtn">등록</button></td>
			</tr>

		</table>
	</div>
</div>
<div id='show'>
	 <!--아래에 구현 <table border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>memberId</td>
				<td>memberName</td>
				<td>memberPhone</td>
				<td>memberAddr</td>
			</tr>
		</tbody>
	</table>-->
</div>
<script src="js/ajax.js">
	//ajax.js로 다 이동
</script>