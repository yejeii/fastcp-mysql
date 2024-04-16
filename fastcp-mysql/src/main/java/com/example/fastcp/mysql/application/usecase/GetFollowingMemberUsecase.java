package com.example.fastcp.mysql.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.follow.entity.Follow;
import com.example.fastcp.mysql.domain.follow.service.FollowReadService;
import com.example.fastcp.mysql.domain.member.dto.MemberDto;
import com.example.fastcp.mysql.domain.member.service.MemberReadService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetFollowingMemberUsecase {

	final private MemberReadService memberReadService;
	final private FollowReadService followReadService;
	
	public List<MemberDto> execute(Long memberId) {
		/*
		 * 1. fromMemberId = memberId -> Follow List 조회
		 * 2. 1번을 순회하면서 회원정보 찾으면 된다 
		 */
		var followings = followReadService.getFollowings(memberId);
		var followMemberIds = followings.stream().map(Follow::getToMemberId).toList();
		return memberReadService.getMembers(followMemberIds);
		
	}
}
