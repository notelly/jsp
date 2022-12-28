package co.yedam.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberPhone;
	private String memberAddr;
	private String memberGrade;
	private String image;
	private String memberName;
}
