package kr.taeu.restsecurity.global.security.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.taeu.restsecurity.global.error.ErrorCode;
import kr.taeu.restsecurity.global.error.ErrorResponse;
import kr.taeu.restsecurity.member.exception.EmailNotFoundException;
import lombok.extern.slf4j.Slf4j;

/*
 * 인증 실패에 대한 전략
 */
@Slf4j
public class RestAuthenticationFailuerHandler implements AuthenticationFailureHandler {
	private ObjectMapper objectMappger = new ObjectMapper();
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if(EmailNotFoundException.class == exception.getClass()) {
			ErrorResponse er = new ErrorResponse(ErrorCode.REQUEST_CONFILICT_EXCEPTION, exception);
			response.setStatus(HttpStatus.CONFLICT.value());
			//response.setContentType(MediaType.)
			response.getOutputStream().println(objectMappger.writeValueAsString(er));
		} else {
			log.info("틀림! ");
		}
	}
}