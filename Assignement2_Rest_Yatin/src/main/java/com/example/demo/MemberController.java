package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/member")
    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }
	
	@GetMapping("/member/{id}")
	public Optional<Member> getMemberById(@PathVariable long id) {
		return memberRepository.findById(id);
	}
	
	@PostMapping("/member")
    public Member addMember(@Validated @RequestBody Member member) {
        return memberRepository.save(member);
    }
}