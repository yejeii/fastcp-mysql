package com.example.fastcp.mysql.application.usecase;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.follow.service.FollowWriteService;
import com.example.fastcp.mysql.domain.member.service.MemberReadService;

import lombok.AllArgsConstructor;

/* 
 * 도메인 서비스의 흐름을 제어하는 역할
 */
@AllArgsConstructor
@Service
public class CreateFollowMemberUsecase {

	final private MemberReadService memberReadService;
	final private FollowWriteService followWriteService;
	
	public void execute(Long fromMemberId, Long toMemberId) {
		/*
		 * 1. 입력받은 memberId로 회원조회
		 * 2. FollowWriteService.create() 호출
		 */
		var fromMember = memberReadService.getMember(fromMemberId);
		var toMember = memberReadService.getMember(toMemberId);
		
		followWriteService.create(fromMember, toMember);
	}
}
