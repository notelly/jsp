package co.yedam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.common.DAO;
import co.yedam.member.vo.MemberVO;

public class MemberDAO {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
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
	
}
