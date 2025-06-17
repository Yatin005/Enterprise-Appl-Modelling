package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Member;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.MemberRepository;

import java.util.Date;

@Service
public class Member_Services {
    @Autowired private MemberRepository memberRepository;

    public Flux<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Mono<Member> getMemberById(long membId) {
        return memberRepository.findByMembId(membId);
    }

    public Mono<Member> createMember(Member member) {
        return memberRepository.save(member);
    }

    public Mono<Member> updateMember(long membId, Member member) {
        return memberRepository.findByMembId(membId)
                .flatMap(existingMember -> {
                    existingMember.setName(member.getName());
                    existingMember.setAddress(member.getAddress());
                    existingMember.setMembType(member.getMembType());
                    existingMember.setMembDate(member.getMembDate());
                    existingMember.setExpiryDate(member.getExpiryDate());
                    return memberRepository.save(existingMember);
                });
    }

    public Mono<Void> deleteMember(long membId) {
        return memberRepository.deleteByMembId(membId);
    }

    public Flux<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }

    public Flux<Member> getMembersByType(String membType) {
        return memberRepository.findByMembType(membType);
    }

    public Flux<Member> getActiveMembers() {
        return memberRepository.findByExpiryDateAfter(new Date());
    }

    public Flux<Member> getExpiredMembers() {
        return memberRepository.findByExpiryDateBefore(new Date());
    }

    public Mono<Member> renewMembership(long membId, Date newExpiryDate) {
        return memberRepository.findByMembId(membId)
                .flatMap(member -> {
                    member.setExpiryDate(newExpiryDate);
                    return memberRepository.save(member);
                });
    }
}