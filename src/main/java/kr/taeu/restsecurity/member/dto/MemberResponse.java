package kr.taeu.restsecurity.member.dto;

import kr.taeu.restsecurity.member.domain.Member;
import kr.taeu.restsecurity.member.domain.model.Email;
import lombok.Getter;

@Getter
public class MemberResponse {
	private Email email;
	
	public MemberResponse(Member member) {
		this.email = member.getEmail();
	}
}
