package com.project1.api;

import com.project1.dto.MemberRequest;
import com.project1.dto.MemberResponse;
import com.project1.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberResponse> getMembers(){return memberService.getMembers();}

    @GetMapping("/{username}")
    public MemberResponse getMember(@PathVariable String username){
        return memberService.getMember(username);
    }

    @PostMapping
    public MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    @PutMapping("/{username}")
    public MemberResponse editMember(@RequestBody MemberRequest body, @PathVariable String username){

        return memberService.editMember(body, username);
    }

    @DeleteMapping("/{username}")
    public void deleteMember(@PathVariable String username){
        memberService.deleteMember(username);
    }
}