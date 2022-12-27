package co.yedam.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	
	//현재페이지 12, 한페이지당 보여줄 수 있는 건수
	private Criteria cri;
	
	//매개값 Criteria cri //현재 페이지 정보와 한페이지당 가지고 있는 정보>,
	//int total //전체건수
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		//cri.getPageNum() 전체 페이지
		//cri.getAmount() 한페이지당 보여줄 건수
		// 12page => 20page
		// 12/10.0 >>double타입으로 만들어준이유 소수점까지 나타내라고/ Math.ceil(12/10.0) -> 2page*10 => 20page.
		this.endPage = (int) (Math.ceil(cri.getPageNum()/(cri.getAmount()*1.0)))*cri.getAmount(); //Math.ceil 올림
		this.startPage = this.endPage - (cri.getAmount() - 1);
		int realEnd = (int)(Math.ceil(total*1.0 / cri.getAmount()));
		//전체건수에*1.0/한페이지당 보여줄 건수
		
		if(this.endPage > realEnd)
			this.endPage = realEnd;
		
		//이전페이지가 존재하는지 여부
		this.prev = this.startPage >1;
		//마지막페이지 endPage가 존재하는지.
		this.next = this.endPage < realEnd;
	
	}
	
}
