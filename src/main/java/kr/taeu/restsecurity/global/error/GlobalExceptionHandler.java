package kr.taeu.restsecurity.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.taeu.restsecurity.global.error.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/*
	 * 비지니스 로직에서 발생하는 예외 처리
	 */
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
		final ErrorResponse response = new ErrorResponse(e, e.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
	}
}
