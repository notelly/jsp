/**
	js/ajax.js

 */
//헤더 타이틀.
let titles = ['아이디', '이름', '연락처', '주소', '삭제', '수정'];
let columns = ['memberId', 'memberName', 'memberPhone', 'memberAddr'];

//member값을 하나 던져주면 tr을 생성해주는 함수.
function makeTr(member = {}) { //member={}객체 타입이라는 의미
	//데이터를 가지고 오면 루틴돌면서 tr을 생성하고 보여주는거
	let tr = document.createElement('tr');
	for (let column of columns) { //밖에서 호출했기 때문에columns가 뭔지 모른다. let title과 let columns를 밖으로 빼준다.
		th = document.createElement('td');
		th.innerText = member[column];
		tr.append(th);

	}
	//삭제버튼
	th = document.createElement('td'); //td를 먼저 만들어주고 button을 만든다.
	let btn = document.createElement('button')
	btn.addEventListener('click', memberDeleteAjax)
	//밑에 memberDeleteAjax 함수 선언 memberDeleteAjax()이렇게 X 이건 순차적으로 진행됨. () 호출하는 거임 >> memberDeleteAjax click 했을 때 실행된다.
	btn.innerText = '삭제'
	th.append(btn)
	tr.append(th);


	//수정버튼
	th = document.createElement('td');
	btn = document.createElement('button')
	btn.addEventListener('click', memberModifyForm)
	btn.innerText = '수정'
	th.append(btn);
	tr.append(th);

	return tr; //함수를 호출한 영역으로 반환하겠다.

}






//member리스트. 원래 ajaxForm.jsp에 있던 내용을 이리로 옮김
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'memberListAjaxJackson.do'); //'get', '요기에'.do로 서블릿 요청할꺼임 //이게 json뭐시기를 가지고 오는 방법임
//insert update delete도 가능하다.
xhtp.send();
xhtp.onload = function() {
	console.log(xhtp);
	console.log(JSON.parse(xhtp.response));
	//parse 메소드: json 문자열을  -> javascrip object로 변경하겠다는 뜻
	let result = JSON.parse(xhtp.response);
	//헤더타이틀
	//table 생성
	let tbl = document.createElement('table');
	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');
	let tr = document.createElement('tr');
	//thead의 타이틀 지정.
	for (let title of titles) {
		let th = document.createElement('th');
		th.innerText = title;
		tr.append(th);
	}
	thd.append(tr); //<thead><tr>....</tr></thead>

	//tbody의 값을 지정.
	for (let i = 0; i < result.length; i++) {
		let tr = makeTr(result[i]);
		tbd.append(tr);

	}

	//table의 하위에 thead, tbody위치
	tbl.append(thd, tbd);
	console.log(tbl);
	//div요소의 하위에 만든 table 지정.
	tbl.setAttribute('border', '1');
	tbl.className = 'table'; //<table class="table"> ... </table>
	document.getElementById('show').append(tbl);
}

//등록버튼에다 클릭 이벤트를 추가
//버튼태그를 찾아야한다.
document.getElementById('addBtn').addEventListener('click', addMemberAjax);
//확인하고 싶다면 console.log를 쳐서 값을 맞게 가지고 오는지 콘솔에서 확인 할 수 있다.

//등록버튼 Ajax호출.
function addMemberAjax() {
	let id = document.getElementById('mid').value; //값을 가지고 오는 거임
	let name = document.getElementById('mname').value; //values가 아니라 value임
	let phone = document.getElementById('mphone').value; //script에서 값을 못가지고 오면 undefined라고 뜬다.
	let addr = document.getElementById('maddr').value;
	let pass = document.getElementById('pass').value;

	const member = { //자스에서는 이게 오브젝트
		memberId: id,
		memberName: name,
		memberAddr: addr,
		memberPhone: phone,
		memberPw: pass
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('post', 'addMemberAjax.do'); // 전송정보를 body에 담아서 전송.
	//addMemberAjax.do는 몸체가 아니라 헤더방식에 보내는거?
	addAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	//많은 데이터가 들어가면 header에 데이터 타입을 이렇에 매칭 시켜줘야한다.
	addAjax.send('id=' + id + '&name=' + name + '&addr=' + addr +   '&phone=' + phone + '&pass=' + pass);
	addAjax.onload = function() {
		console.log(addAjax.response)
		let result = JSON.parse(addAjax.response)
		if (result.retCode == 'Success') {
			alert('정상 처리 완료.')
			document.querySelector('#show tbody').append(makeTr(member));
		} else if (result.retCode == 'Fail') {
			alert('처리 중 에러.')
		}
	}
}

// 삭제 버튼을 누르면 클릭시 이벤트가 발생한다.
function memberDeleteAjax() {
	console.log(this.parentElement.parentElement.firstChild.innerText);
	let user = this.parentElement.parentElement.firstChild.innerText;
	let btn = this;
	//db삭제. 화면 제거.
	const xhtp = new XMLHttpRequest();
	xhtp.open('get', 'deleteMemberAjax.do?id=' + user) //get방식으로 페이지를 요청하겠다.
	//this.a a는 event를 받는 대상
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.response) // 정상적으로 실행되면 retCode = Success, 실패하면 retCode = Fail
		//이게 되도록 MemberDeleteAjax.java에 구현 해둠
		let result = JSON.parse(xhtp.response);
		if (result.retCode == 'Success') {
			alert('정상적으로 처리가 완료되었습니다.')
			btn.parentElement.parentElement.remove(); //화면에서 제거
			// btn의 부모는 td td의 부모는 tr. tr을 화면에서 제거한다.
		} else if (result.retCode == 'Fail') {
			alert('처리 중 오류가 발생하였습니다.')
		}

	}

}

//수정화면
function memberModifyForm() {
	let tr = this.parentElement.parentElement;
	let mid = tr.children[0].textContent;
	let mname = tr.children[1].textContent;
	let mphone = tr.children[2].textContent;
	let maddr = tr.children[3].textContent;

	const member = { //자스에서는 이게 오브젝트
		memberId: mid,
		memberName: mname,
		memberAddr: maddr,
		memberPhone: mphone
	}

	let newTr = document.createElement('tr');
	for (let column of columns) {
		let td = document.createElement('td');
		if (column == 'memberAddr' || column == 'memberPhone') {
			let inp = document.createElement('input');
			inp.value = member[column];
			td.append(inp);
		} else {
			td.innerText = member[column];
		}
		newTr.append(td);
	}
	//버튼등록.
	//삭제버튼
	td = document.createElement('td'); //td를 먼저 만들어주고 button을 만든다.
	let btn = document.createElement('button')
	btn.addEventListener('click', memberDeleteAjax)
	//밑에 memberDeleteAjax 함수 선언 memberDeleteAjax()이렇게 X 이건 순차적으로 진행됨. () 호출하는 거임 >> memberDeleteAjax click 했을 때 실행된다.
	btn.innerText = '삭제'
	btn.disabled = true;
	td.append(btn)
	newTr.append(td);


	//수정버튼
	td = document.createElement('td');
	btn = document.createElement('button')
	btn.addEventListener('click', memberUpdateAjax)
	btn.innerText = '변경'
	td.append(btn);
	newTr.append(td);


	tr.replaceWith(newTr); //tr.replaceWith(newTr) tr요소 대신에 newTr로 대체하겠다.
}

function memberUpdateAjax() {
	let tr = this.parentElement.parentElement;
	let id = tr.children[0].textContent;
	let addr = tr.children[3].firstChild.value;
	let phone = tr.children[2].firstChild.value;
	const modAjax = new XMLHttpRequest();
	modAjax.open('post', 'modMemberAjax.do'); // 전송정보를 body에 담아서 전송.
	//addMemberAjax.do는 몸체가 아니라 헤더방식에 보내는거?
	modAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	//많은 데이터가 들어가면 header에 데이터 타입을 이렇에 매칭 시켜줘야한다.
	modAjax.send('id=' + id + '&addr=' + addr + '&phone=' + phone);
	modAjax.onload = function() {
		console.log(modAjax.response)
		let result = JSON.parse(modAjax.response)
		console.log(result);
		if (result.retCode == 'Success') {
			alert('정상 처리 완료.')
			let newTr = makeTr(result.memberInfo)
			tr.replaceWith(newTr)
			//document.querySelector('#show tbody').append(makeTr(member));
		} else if (result.retCode == 'Fail') {
			alert('처리 중 에러.')
		}
	}
}


