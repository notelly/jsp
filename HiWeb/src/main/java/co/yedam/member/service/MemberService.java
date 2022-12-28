package co.yedam.member.service;

import java.util.List;

import co.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO loginCheck(String id, String pw);

	public int insertMember(MemberVO vo);
	
	public List<MemberVO> memberList();
}
