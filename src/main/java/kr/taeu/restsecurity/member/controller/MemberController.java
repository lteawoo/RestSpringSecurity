package kr.taeu.restsecurity.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "hello!";
	}
}
