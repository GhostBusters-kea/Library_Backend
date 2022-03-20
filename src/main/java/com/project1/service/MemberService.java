package com.project1.service;

import com.project1.dto.MemberRequest;
import com.project1.dto.MemberResponse;
import com.project1.entity.Member;
import com.project1.error.ClientException;
import com.project1.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberResponse> getMembers(){
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> new MemberResponse(member)).collect(Collectors.toList());
    }

    public MemberResponse getMember(String username) {
        Member member = memberRepository.findById(username).orElseThrow(()-> new ClientException("User not found", HttpStatus.NOT_FOUND));
        return new MemberResponse(member);
    }

    public MemberResponse addMember(MemberRequest body){
        if(memberRepository.existsById(body.getUsername())){
            throw new ClientException(("Username already exists"));
        }
        if(memberRepository.emailExist(body.getEmail())){
            throw new ClientException("An account with that email already exists");
        }
        Member memberNew = new Member(body);
        memberNew = memberRepository.save(memberNew);

        return new MemberResponse(memberNew.getUsername(), memberNew.getCreated());
    }

    public MemberResponse editMember(MemberRequest body, String username){
        if(!(memberRepository.existsById(username))){
            throw new ClientException("No Such member exists");
        }
        Member memberToEdit = new Member(body);
        memberToEdit.setUsername(username);
        memberRepository.save(memberToEdit);
        return new MemberResponse(memberToEdit);
    }

    public void deleteMember(String username){
        if(!(memberRepository.existsById(username))){
            throw new ClientException("No Such member exists");
        }
        memberRepository.deleteById(username);
    }

    public Member getMemberToReservation(String username){
        return memberRepository.findById(username).orElseThrow(()-> new ClientException("Member not found",HttpStatus.NOT_FOUND));

     }
}

