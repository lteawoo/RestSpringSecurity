package kr.taeu.restsecurity.member.dto;

import javax.validation.Valid;

import kr.taeu.restsecurity.member.domain.model.Email;
import kr.taeu.restsecurity.member.domain.model.Password;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * Objectmapper 사용시 기본생성자 필요함..
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignInRequest {
	@Valid
	private Email email;
	
	@Valid
	private Password password;
	
	public SignInRequest(@Valid Email email, @Valid Password password) {
		this.email = email;
		this.password = password;
	}
}
