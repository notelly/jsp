package co.yedam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;
import co.yedam.member.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	Statement smt;
	
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO loginCheck(String id, String pw) {
		//값이 있으면 뭐고 없으면 null이 나오도록
		String sql = "select * from member where member_id=? and member_pw=?";
		conn = DAO.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id")); //"member_id" DB 컬럼 이름
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAddr(rs.getString("member_addr"));
				vo.setMemberPhone(rs.getString("member_phone"));
				vo.setMemberGrade(rs.getString("member_rank"));
				
				return vo;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}
	
	//회원등록
	public int insertMember(MemberVO vo) {
		System.out.println(vo);
		String sql ="insert into member(member_id, member_pw, member_phone, member_addr, member_name) "
				+ "values(?, ?, ?, ?, ?)";
		conn = DAO.getConn();
		int rs = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			psmt.setString(3, vo.getMemberPhone());
			psmt.setString(4, vo.getMemberAddr());
			psmt.setString(5, vo.getMemberName());
			
			rs = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		System.out.println(rs +"건 입력");
		return rs;
	}
	
	
	//회원조회
	
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		MemberVO vo = null;
		conn = DAO.getConn();
		String sql = "SELECT * FROM(SELECT ROWNUM rn, a. * FROM member a WHERE a.member_rank = 'User')";
		try {
			smt = conn.createStatement();
			rs = smt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAddr(rs.getString("member_addr"));
				vo.setMemberPhone(rs.getString("member_phone"));
				list.add(vo);
				
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
		return list;

	}
	
	
	//페이징 들어간 회원조회
	public List<MemberVO> memberListpaging(int page) {
		List<MemberVO> list = new ArrayList<>();
		MemberVO vo = null;
		int start = page+(page-1)*10;
		int end = page*10;
		
		String sql = "SELECT * FROM(SELECT ROWNUM rn, a. * FROM member a WHERE a.member_rank = 'User') WHERE rn between ? and ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberId(rs.getString("member_pw"));
				vo.setMemberName(rs.getNString("meber_name"));
				vo.setMemberId(rs.getString("member_addr"));
				vo.setMemberId(rs.getString("member_phone"));
				list.add(vo);
				
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
		return list;

	}
	//회원 삭제
	public int deleteMember(String id) {
		String sql = "delete from member where member_id = ?";
		conn = DAO.getConn();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			r = psmt.executeUpdate(); //처리된 건수를 받는 것
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
	//회원 정보 수정
	public int updateMember(MemberVO vo) {
		String sql = "update member set member_addr=?, member_phone=? where member_id=?";
		conn = DAO.getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberAddr());
			psmt.setString(2, vo.getMemberPhone());
			psmt.setString(3, vo.getMemberId());
			
			return psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}
	

	
}
