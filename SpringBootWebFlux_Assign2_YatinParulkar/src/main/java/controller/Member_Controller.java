package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import model.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.Member_Services;

import java.util.Date;

@RestController
@RequestMapping("/api/members")
public class Member_Controller {
    @Autowired private Member_Services memberService;

    @GetMapping
    public Flux<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{membId}")
    public Mono<Member> getMemberById(@PathVariable long membId) {
        return memberService.getMemberById(membId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Member> createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("/{membId}")
    public Mono<Member> updateMember(@PathVariable long membId, @RequestBody Member member) {
        return memberService.updateMember(membId, member);
    }

    @DeleteMapping("/{membId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMember(@PathVariable long membId) {
        return memberService.deleteMember(membId);
    }

    @GetMapping("/name/{name}")
    public Flux<Member> getMembersByName(@PathVariable String name) {
        return memberService.getMembersByName(name);
    }

    @GetMapping("/type/{membType}")
    public Flux<Member> getMembersByType(@PathVariable String membType) {
        return memberService.getMembersByType(membType);
    }

    @GetMapping("/active")
    public Flux<Member> getActiveMembers() {
        return memberService.getActiveMembers();
    }

    @GetMapping("/expired")
    public Flux<Member> getExpiredMembers() {
        return memberService.getExpiredMembers();
    }

    @PostMapping("/{membId}/renew")
    public Mono<Member> renewMembership(@PathVariable long membId, @RequestBody Date newExpiryDate) {
        return memberService.renewMembership(membId, newExpiryDate);
    }
}