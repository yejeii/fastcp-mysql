package com.example.fastcp.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcp.mysql.domain.member.dto.MemberDto;
import com.example.fastcp.mysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcp.mysql.domain.member.entity.Member;
import com.example.fastcp.mysql.domain.member.service.MemberReadService;
import com.example.fastcp.mysql.domain.member.service.MemberWriteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	// DI
	final private MemberWriteService memberWriteService;
	
	final private MemberReadService memberReadService;
	
	@PostMapping("/members")
	public MemberDto register(@RequestBody RegisterMemberCommand command) {
		System.out.println("C ---- \n" + command.email() + " " + command.nickname() + " " + command.birthday());
		
		var member = memberWriteService.register(command);		
		return memberReadService.toDto(member);
	}
	
	@GetMapping("/members/{id}")
	public MemberDto getMember(@PathVariable Long id) {
		return memberReadService.getMember(id);
	}
}
