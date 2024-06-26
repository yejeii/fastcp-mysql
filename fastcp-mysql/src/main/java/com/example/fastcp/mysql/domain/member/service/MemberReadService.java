package com.example.fastcp.mysql.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.member.dto.MemberDto;
import com.example.fastcp.mysql.domain.member.dto.MemberNicknameHistoryDto;
import com.example.fastcp.mysql.domain.member.entity.Member;
import com.example.fastcp.mysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcp.mysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcp.mysql.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberReadService {

	final private MemberRepository memberRepository;
	
	final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;
	
	public MemberDto getMember(Long id) {
		var member =  memberRepository.findById(id).orElseThrow();
		return toDto(member);
	}
	
	public List<MemberDto> getMembers(List<Long> ids) {
		var members = memberRepository.findAllbyIdIn(ids);
		return members.stream().map(this::toDto).toList();
	}
	
	public List<MemberNicknameHistoryDto> getNicknameHistories(Long memberId) {
		return memberNicknameHistoryRepository
				.findAllByMemberId(memberId)
				.stream()
				.map(this::toDto)
				.toList();
	}
	
	public MemberDto toDto(Member member) {
		return new MemberDto(member.getId(), 
				member.getEmail(), 
				member.getNickname(), 
				member.getBirthday());
	}
	
	private MemberNicknameHistoryDto toDto(MemberNicknameHistory history) {
		return new MemberNicknameHistoryDto(
				history.getId(), 
				history.getMemberId(), 
				history.getNickname(), 
				history.getCreatedAt()
		);
	}
	
}
