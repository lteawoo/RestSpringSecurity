package kr.taeu.restsecurity.member.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.taeu.restsecurity.global.error.exception.ObjectNotFoundException;
import kr.taeu.restsecurity.member.domain.model.Email;

public class EmailNotFoundException extends UsernameNotFoundException {
	public EmailNotFoundException(Email email) {
		super(email.getValue() + " is not found");
	}
}
