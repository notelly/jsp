package co.yedam.member.service.impl;

import java.util.List;

import co.yedam.member.dao.MemberDAO;
import co.yedam.member.service.MemberService;
import co.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao = MemberDAO.getInstance(); //? DAO의 값을 가지고 온다...?
	
	
	@Override
	public MemberVO loginCheck(String id, String pw) {
		return dao.loginCheck(id, pw);
	}


	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}


	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

}
