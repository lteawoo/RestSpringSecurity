package kr.taeu.restsecurity.member.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.taeu.restsecurity.member.dao.MemberDetailsRepository;
import kr.taeu.restsecurity.member.domain.Member;
import kr.taeu.restsecurity.member.domain.model.Password;
import kr.taeu.restsecurity.member.dto.SignUpRequest;
import kr.taeu.restsecurity.member.exception.EmailAlreadyExistsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService{
	private final MemberDetailsRepository memberDetailsRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public Member createMember(SignUpRequest signUpRequest) {
		boolean isExists = this.memberDetailsRepository.existsByEmail(signUpRequest.getEmail());
		
		if(isExists) {
			//이메일 중복 처리
			throw new EmailAlreadyExistsException(signUpRequest.getEmail());
		}
		
		//비밀번호 암호화
		SignUpRequest cryptedReq = new SignUpRequest(signUpRequest.getEmail(),
				new Password(passwordEncoder.encode(signUpRequest.getPassword().getValue())),
				signUpRequest.getRole());
		
		return this.memberDetailsRepository.save(cryptedReq.toEntity());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
}
