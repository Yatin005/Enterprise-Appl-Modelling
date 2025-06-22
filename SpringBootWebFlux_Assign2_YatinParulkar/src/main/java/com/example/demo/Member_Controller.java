package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class Member_Controller {

    @Autowired
    private Member_Services memberService;

    @PostMapping("/member")
    public Mono<Member> addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/member")
    public Flux<Member> getMembers() {
        return memberService.getAllMembers();
    }
}