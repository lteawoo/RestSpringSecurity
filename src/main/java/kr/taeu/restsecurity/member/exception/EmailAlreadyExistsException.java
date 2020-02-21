package kr.taeu.restsecurity.member.exception;

import kr.taeu.restsecurity.global.error.exception.RequestConflictException;
import kr.taeu.restsecurity.member.domain.model.Email;

public class EmailAlreadyExistsException extends RequestConflictException {
	public EmailAlreadyExistsException(Email email) {
		super(email.getValue() + " is already exists");
	}
}
