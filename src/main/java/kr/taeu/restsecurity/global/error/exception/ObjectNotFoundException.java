package kr.taeu.restsecurity.global.error.exception;

import kr.taeu.restsecurity.global.error.ErrorCode;

public class ObjectNotFoundException extends BusinessException {

	public ObjectNotFoundException(String message) {
		super(message, ErrorCode.OBJECT_NOT_FOUND);
	}
}
