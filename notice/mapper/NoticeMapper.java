package co.yedam.notice.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.common.Criteria;
import co.yedam.common.SearchVO;
import co.yedam.notice.vo.NoticeVO;

public interface NoticeMapper {
	public int insertNotice(NoticeVO vo);
	public NoticeVO searchNotice(int noticeId);
	public int addHitCount (int noticeId);
	public int updateNotice (NoticeVO vo);
	public int deleteNotice (int noticeId);
	//paging 처리를 위해서 전체건수를 계산하는 메소드
	public int noticeListPagingTotalCnt(SearchVO svo);
	public List<NoticeVO> noticeListPaging(Criteria cri);
	//forEachTest test
	public List<NoticeVO> forEachTest(List<NoticeVO> list);
	public int addCenterInfo(Map<String, Object> map);
	public int insertCenterInfo(List<Map<String, Object>> list);
	
	//이벤트 데이터 처리
	public List<Map<String, Object>> allEvents();
	public int addEvent(Map<String, Object> map);
	public int removeEvent(String title);
	
	//쇼핑몰
	public List<Map<String, Object>> productList();
}
