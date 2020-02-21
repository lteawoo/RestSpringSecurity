package kr.taeu.restsecurity.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private String code;
	private String message;
	private int status;
	
	public ErrorResponse(final ErrorCode code) {
		this.code = code.getCode();
		this.message = code.getMessage();
		this.status = code.getStatus();
	}
	
	public ErrorResponse(final Exception e, final ErrorCode code) {
		this.code = code.getCode();
		this.message = e.getMessage();
		this.status = code.getStatus();
	}
}
