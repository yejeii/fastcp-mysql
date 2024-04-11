package com.example.fastcp.mysql.domain.member.service;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcp.mysql.domain.member.entity.Member;
import com.example.fastcp.mysql.domain.member.entity.MemberNicknameHistory;
import com.example.fastcp.mysql.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.fastcp.mysql.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

	// DI
	final private MemberRepository memberRepository;
	
	final private MemberNicknameHistoryRepository memberNicknameHistoryRepository;
	
	public Member register(RegisterMemberCommand command) {
		/* 
		 * 목표 - 회원정보(이메일, 닉네임, 생년월일)을 등록한다.
		 * 	   - 닉네임은 10자를 넘길 수 없다.
		 * 파라미터 - memberRegisterCommand
		 * 
		 * val member = Member.of(memberRegisterCommand)
		 * memberRepository.save(member)
		 */		
		
		var member = Member.builder()
				.email(command.email())
				.nickname(command.nickname())
				.birthday(command.birthday())
				.build();
		
		var saveMember = memberRepository.save(member);
		saveMemberNicknameHistory(saveMember);
		return saveMember;
	}
	
	public void changeNickname(Long memberId, String nickname) {
		/*
		 * 1. 회원 이름 변경
		 * 2. 변경 내역 저장한다.
		 */
		var member = memberRepository.findById(memberId).orElseThrow();
		member.changeNickname(nickname);
		memberRepository.save(member);

		// TODO : 변경 내역 히스토리를 저장한다.
		saveMemberNicknameHistory(member);
		
	}

	private void saveMemberNicknameHistory(Member member) {
		var history = MemberNicknameHistory
				.builder()
				.memberId(member.getId())
				.nickname(member.getNickname())
				.build();

		memberNicknameHistoryRepository.save(history);
	}
}