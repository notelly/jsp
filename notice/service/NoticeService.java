package co.yedam.notice.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.SearchVO;
import co.yedam.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList();
	//page에 따른 목록
	public List<NoticeVO> noticeListPaging(int pageNum, SearchVO svo);
	//page목록 계산을 위한 건수.
	public int noticeListPagingTotalCnt(SearchVO svo);
	//단건조회. 글번호 -> 글전체정보반환.
	public NoticeVO searchNotice(int noticeId);
	//인터페이스에 기능이 추가가되면 class에 기능을 꼭 추가해주어야한다.
	//override 할 것
	public int updateNotice(NoticeVO vo);
	//글정보수정
	public int insertNoitce(NoticeVO vo);
	//글추가
	public int deleteNotice(int noticeId);
	//차트용 데이터
	public Map<String, Integer> chartData();
	//이벤트 데이터 가지고오기
	public List<Map<String, Object>> allEvents();
	//이벤트 등록.
	//Map<String, Object> map 이것이 파라메터
	public int addEvent(Map<String, Object> map);
	//이벤트 삭제.
	public int removeEvent(String title);
	//쇼핑몰
	public List<Map<String, Object>> productList();
}
