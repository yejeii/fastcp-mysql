package com.example.fastcp.mysql.domain.follow.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.example.fastcp.mysql.domain.follow.entity.Follow;
import com.example.fastcp.mysql.domain.follow.repository.FollowRepository;
import com.example.fastcp.mysql.domain.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FollowWriteService {
	
	final private FollowRepository followRepository;
	
	public void create(MemberDto fromMember, MemberDto toMember) {
		/*
		 * from, to 회원 정보를 받아서
		 * 저장...
		 * from - to 대상이 같으면 안되니 validate 추가할 것
		 */
		Assert.isTrue(!fromMember.id().equals(toMember.id()), "From, To 회원이 동일합니다.");
		
		var follow = Follow.builder()
			.fromMemberId(fromMember.id())
			.toMemberId(toMember.id())
			.build();
		
		followRepository.save(follow);
	}
}
