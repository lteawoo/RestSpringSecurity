package kr.taeu.restsecurity.member.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidPasswordException extends BadCredentialsException {
	public InvalidPasswordException() {
		super("Invalid Password");
	}
}
