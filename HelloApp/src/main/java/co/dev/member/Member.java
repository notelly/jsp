package co.dev.member;

public class Member {
	/* 221213 Member 클래스 생성
		hr / hr  Member Table 기반 작성
		MEMBER_ID    NOT NULL VARCHAR2(10) 
		MEMBER_PW    NOT NULL VARCHAR2(20) 
		MEMBER_ADDR           VARCHAR2(50) 
		MEMBER_RANK           CHAR(1)      
		MEMBER_PHONE          NUMBER(13)
	*/
	
	//필드
	private String memberId;
	private String memberPw;
	private String memberPhone;
	private String memberAddr;
	private String memberRank;
	
	
	
	//생성자
	//메소드
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberAddr=" + memberAddr
				+ ", memberRank=" + memberRank + ", memberPhone=" + memberPhone + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
