package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Member_Services;


@RestController
@RequestMapping("/api/members")
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