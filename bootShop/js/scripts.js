/*!
* Start Bootstrap - Shop Homepage v5.0.5 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
fetch('../productList.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result)
		//일일이 치는 건 힘들어서 못함
		for (let i = 0; i < result.length; i++) {
			let template = document.querySelector('.col.mb-5').cloneNode(true);
			console.log(template.querySelector('h5'));
			template.querySelector('h5').innerText = result[i].PROD_NAME;
			template.querySelector('img').setAttribute('src', '../images/' + result[i].IMAGE);
			//원가격, 할인가격.
			template.querySelector('span:nth-of-type(1)').innerText = result[i].ORIG_PRICE;
			template.querySelector('span:nth-of-type(2)').innerText = result[i].SALE_PRICE;
			//평점.
			let sItem = template.querySelector('div.d-flex');

			for (let j = 0; j < 5; j++) {
				let star = document.createElement('div');
				if (j < Math.floor(result[i].LIKE_IT)) {
					star.className = 'bi-star-fill'; //온별
				} else if (j < result[i].LIKE_IT) {
					star.className = 'bi-star-half'; //반별	
				} else {
					star.className = 'bi-star'; //공별.
				}
				sItem.children[j].replaceWith(star)
			}

			document.querySelector('.col.mb-5').parentElement.append(template);
		}
			document.querySelector('.col.mb-5').style.display = 'none';
	})
	.catch(reject => console.log(reject))


/*let template = document.querySelector('.col.mb-5');
let parentEl = template.parentElement;
for (let i = 0; i<5; i++){
	template = document.querySelector('.col.mb-5').cloneNode(true); //cloneNode 앞에 요소를 똑같이 복사하겠습니다. 하위요소까지 전부다.
	parentEl.append(template);
}*/