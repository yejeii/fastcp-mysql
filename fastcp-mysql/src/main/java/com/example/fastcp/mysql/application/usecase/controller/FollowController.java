package com.example.fastcp.mysql.application.usecase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcp.mysql.application.usecase.CreateFollowMemberUsecase;
import com.example.fastcp.mysql.application.usecase.GetFollowingMemberUsecase;
import com.example.fastcp.mysql.domain.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
	
	final private CreateFollowMemberUsecase createFollowMemberUsecase;
	final private GetFollowingMemberUsecase getFollowingMemberUsecase;
	
	@PostMapping("/{fromId}/{toId}")
	public void create(@PathVariable Long fromId, @PathVariable Long toId) {
		System.out.println(String.format("Follow.C ---- \n %s, %s", fromId, toId));
		
		createFollowMemberUsecase.execute(fromId, toId);
	}
	
	@GetMapping("/members/{fromId}")
	public List<MemberDto> create(@PathVariable Long fromId) {
		System.out.println(String.format("Follow.C ---- \n %s", fromId));
		
		return getFollowingMemberUsecase.execute(fromId);
	}
	

}
