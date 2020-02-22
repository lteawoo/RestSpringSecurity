package kr.taeu.restsecurity.member.dto;

import javax.validation.Valid;

import kr.taeu.restsecurity.member.domain.model.Email;
import kr.taeu.restsecurity.member.domain.model.Password;
import lombok.Getter;

@Getter
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
