package kr.taeu.restsecurity.member.exception;

import kr.taeu.restsecurity.global.error.exception.ObjectNotFoundException;
import kr.taeu.restsecurity.member.domain.model.Email;

public class EmailNotFoundException extends ObjectNotFoundException {
	public EmailNotFoundException(Email email) {
		super(email.getValue() + " is not found");
	}
}
