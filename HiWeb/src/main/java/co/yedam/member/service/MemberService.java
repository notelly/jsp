package co.yedam.member.service;

import co.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO loginCheck(String id, String pw);
}
