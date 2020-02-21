package kr.taeu.restsecurity.member.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.taeu.restsecurity.member.domain.Member;
import kr.taeu.restsecurity.member.dto.MemberResponse;
import kr.taeu.restsecurity.member.dto.SignUpRequest;
import kr.taeu.restsecurity.member.service.MemberDetailsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	private final MemberDetailsService memberDetailsService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "hello!";
	}
	
	@PostMapping("/signup")
	public MemberResponse signUp(@RequestBody @Valid final SignUpRequest signUpRequest) {
		final Member member = this.memberDetailsService.createMember(signUpRequest);
		
		return new MemberResponse(member);
	}
}
