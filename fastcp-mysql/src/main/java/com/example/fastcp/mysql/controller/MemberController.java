package com.example.fastcp.mysql.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcp.mysql.domain.member.dto.MemberDto;
import com.example.fastcp.mysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.fastcp.mysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcp.mysql.domain.member.service.MemberReadService;
import com.example.fastcp.mysql.domain.member.service.MemberWriteService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

	// DI
	final private MemberWriteService memberWriteService;
	
	final private MemberReadService memberReadService;
	
	@PostMapping
	public MemberDto register(@RequestBody RegisterMemberCommand command) {
		System.out.println("C ---- \n" + command.email() + " " + command.nickname() + " " + command.birthday());
		
		var member = memberWriteService.register(command);		
		return memberReadService.toDto(member);
	}
	
	@GetMapping("/{id}")
	public MemberDto getMember(@PathVariable Long id) {
		System.out.println("C ---- \n" + id);
		
		return memberReadService.getMember(id);
	}
	
	@PostMapping("/{id}/name")
	public MemberDto changeNickname(@PathVariable Long id, @RequestBody String nickname) {
		System.out.println(String.format("C ---- \n %s, %s", id, nickname));
		
		memberWriteService.changeNickname(id, nickname);
		return memberReadService.getMember(id);
	}
	
	@GetMapping("/{memberId}/nickname-histories")
	public List<MemberNicknameHistoryDto> getNicknamehistories(@PathVariable Long memberId) {
		System.out.println(String.format("C ---- \n %s", memberId));
		
		return memberReadService.getNicknameHistories(memberId);
	}
}
