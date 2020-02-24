package kr.taeu.restsecurity.member.exception;

import kr.taeu.restsecurity.global.error.exception.ObjectNotFoundException;
import kr.taeu.restsecurity.member.domain.model.Email;

public class MemberNotFoundException extends ObjectNotFoundException {
	public MemberNotFoundException(Email email) {
		super(email.getValue() + " is not found");
	}
}
