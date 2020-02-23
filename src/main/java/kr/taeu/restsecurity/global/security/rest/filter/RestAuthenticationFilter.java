package kr.taeu.restsecurity.global.security.rest.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.taeu.restsecurity.member.dto.SignInRequest;

public class RestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public RestAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if(!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: " + request.getMethod());
		}
		
		/* dto로 받는 것..이 이상한 건가 */
		SignInRequest signInRequest = new ObjectMapper().readValue(request.getReader(), SignInRequest.class);
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword());
		
		return getAuthenticationManager().authenticate(authentication);
	}

}
