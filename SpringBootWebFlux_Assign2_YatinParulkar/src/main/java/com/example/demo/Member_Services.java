package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Member_Services {

    @Autowired
    private MemberRepository repo;

    // Add a new member
    public Mono<Member> addMember(Member member) {
        return repo.save(member);
    }

    // Get all members
    public Flux<Member> getAllMembers() {
        return repo.findAll();
    }

    // Get member by ID
    public Mono<Member> getMemberById(String id) {
        return repo.findById(id);
    }

    // Delete member by ID
    public Mono<Void> deleteMember(String id) {
        return repo.deleteById(id);
    }
}