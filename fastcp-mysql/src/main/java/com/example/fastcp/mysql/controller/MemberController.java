package com.example.fastcp.mysql.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcp.mysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcp.mysql.domain.member.entity.Member;
import com.example.fastcp.mysql.domain.member.service.MemberWriteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	// DI
	final private MemberWriteService memberWriteService;
	
	@PostMapping("/members")
	public Member register(@RequestBody RegisterMemberCommand command) {
		return memberWriteService.create(command);
	}
}
