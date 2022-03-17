package com.project1.service;

import com.project1.dto.MemberRequest;
import com.project1.dto.MemberResponse;
import com.project1.entity.Member;
import com.project1.repository.MemberRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = new MemberService(memberRepository);
    }

    @Test
    void getMembers() {
        Mockito.when(memberRepository.findAll()).thenReturn(List.of(
                new Member("a", "a@mail.dk", "aaa", "af", "al", "avej", "aby", "2000"),
                new Member("b", "b@mail.dk", "bbb", "bf", "bl", "bvej", "bby", "2000"),
                new Member("c", "c@mail.dk", "ccc", "cf", "cl", "cvej", "cby", "2000")
        ));
        List<MemberResponse> members = memberService.getMembers();
        assertEquals(3, members.size());
    }

    @Test
    void getMember() {
        Member member = new Member("a", "a@mail.dk", "aaa", "af", "al", "avej", "aby", "2000");
        Mockito.when(memberRepository.findById("a")).thenReturn(Optional.of(member));
        MemberResponse memRes = memberService.getMember("a");
        assertEquals("a@mail.dk", memRes.getEmail());
    }

    @Test
    void addMember() {
        Member memberWithId = new Member("a", "a@mail.dk", "aaa", "af", "al", "avej", "aby", "2000");
        Mockito.when(memberRepository.save(any(Member.class))).thenReturn(memberWithId);
        MemberResponse res = memberService.addMember(new MemberRequest(memberWithId.getUsername(), memberWithId.getPassword(),
                memberWithId.getEmail(), memberWithId.getFirstName(), memberWithId.getLastName(), memberWithId.getStreet(),
                memberWithId.getCity(), memberWithId.getZip()));
        assertEquals("a", res.getUsername());
    }

    @Test
    void editMember() {
    }

    @Test
    void deleteMember() {
    }
}