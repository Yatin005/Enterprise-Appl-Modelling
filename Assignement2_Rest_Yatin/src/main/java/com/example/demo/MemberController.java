package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
}