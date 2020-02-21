package kr.taeu.restsecurity.global.error.exception;

import kr.taeu.restsecurity.global.error.ErrorCode;

public class RequestConflictException extends BusinessException{
	public RequestConflictException(String message) {
		super(message, ErrorCode.REQUEST_CONFILICT_EXCEPTION);
	}
}
