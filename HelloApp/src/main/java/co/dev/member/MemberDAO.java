package co.dev.member;

import java.util.ArrayList;
import java.util.List;
import co.dev.common.DAO;



public class MemberDAO extends DAO { // 어디 패키지에 있는 앤지 확실하게 확인하기.

	// 로그인 - login()
	// 회원 등록 - insertMember()
	// 회원 조회 - getMemberList()
	// 회원 탈퇴 - deleteMember()
	// 회원 수정 - updateMember()
	// 로그아웃 - logout()

	// 싱글톤이 있어야 함.
	private static MemberDAO memberDao = null;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}

	// 1. 로그인 - ID / PW
	// 아이디와 비밀번호가 일치해야지 로그인 할 수 있음
	public Member login(Member member) { // String Id만 넘겨도 되고 옆은 객체를 다 넘긴것
		try {
			conn();
			//String sql = "SELECT * FROM member WHERE member_id = ? AND member_Rank = 'N'"; 관리자 조회할때 추가해주면 된다. 일반회원은 Y
			String sql = "SELECT * FROM member WHERE member_id = ?"; // ? 에 ID 삽입 >> 내가 입력한 ID
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());

			rs = pstmt.executeQuery();

			// 정상적으로 회원 정보가 조회 된 경우
			if (rs.next()) { // rs.next 결과가 존재한다. 그럼 값을 넣어주면 된다.
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberRank(rs.getString("member_rank"));
				member.setMemberPhone(rs.getString("member_phone"));
			} else { // 회원 정보가 조회가 안된 이유
				member = null; // 아이디가 없으면 null 아무것도 띄우지 않음
			}

		} catch (Exception e) {
				e.printStackTrace(); //예외처리 db쪽 문제를 보여준다.
		} finally {
			disconn();
		}
		return member; // 정상적으로 아이디가 조회됐다면 값을 가지고 있음.
	}

	//회원 조회
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member member = null;
		
		try {
			conn();
			String sql = "SELECT * FROM member"; //회원 전체 조회
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //5번 돌아가면서 한줄식 리스트에 데이터를 넣게 됨
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberRank(rs.getString("member_rank"));
				list.add(member);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return list;
	}
	
	//회원 등록
	public int insertMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = " INSERT INTO member VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddr());
			pstmt.setString(5, member.getMemberRank());
			
			result = pstmt.executeUpdate();
					
			//중복된 아이디 잡아내기
			//String sql = "SELECT * FROM member WHERE member_id = ?"; 여기서 값이 나오면 아이디가 있는 것. 그럼 만들 수 없음
			//MemberService >>
			
					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	//회원 탈퇴
	public int deleteMember(String id) {
		int result = 0 ;
		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 수정 
	public int updateMember(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE member set member_pw = ?, member_phone = ?, member_addr = ? WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberPhone());
			pstmt.setString(3, member.getMemberAddr());
			pstmt.setString(4, member.getMemberId());
			
			result = pstmt.executeUpdate(); //1이면 정상적인 업데이트 0이면 업데이트 실패
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}

	public Member getMember(String id) {
		Member member = null;
		
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id = '" + id +"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberAddr(rs.getString("member_addr"));
				member.setMemberRank(rs.getString("member_rank"));
				member.setMemberPhone(rs.getString("member_phone"));
			} else { // 회원 정보가 조회가 안된 이유
				member = null; // 아이디가 없으면 null 아무것도 띄우지 않음
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
	
	
	
}
