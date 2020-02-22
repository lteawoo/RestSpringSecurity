package kr.taeu.restsecurity.global.error;

import java.util.List;

import org.springframework.validation.BindingResult;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private String code;
	private String message;
	private List<FieldError> errors;
	private int status;
	
	public ErrorResponse(final ErrorCode code) {
		this.code = code.getCode();
		this.message = code.getMessage();
		this.status = code.getStatus();
	}
	
	public ErrorResponse(final ErrorCode code, final Exception e) {
		this(code);
		this.message = e.getMessage();
	}
	
	public ErrorResponse(final ErrorCode code, final BindingResult bindingResult) {
		this(code);
		this.errors = FieldError.parse(bindingResult);
	}
}
