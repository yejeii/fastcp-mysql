package com.example.fastcp.mysql.domain.follow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.follow.entity.Follow;
import com.example.fastcp.mysql.domain.follow.repository.FollowRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FollowReadService {

	final private FollowRepository followRepository;
	
	public List<Follow> getFollowings(Long memberId) {
		return followRepository.findAllByFromMemberId(memberId);
	}
	
}
