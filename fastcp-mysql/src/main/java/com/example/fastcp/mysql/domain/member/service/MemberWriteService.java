package com.example.fastcp.mysql.domain.member.service;

import org.springframework.stereotype.Service;

import com.example.fastcp.mysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcp.mysql.domain.member.entity.Member;
import com.example.fastcp.mysql.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberWriteService {

	// DI
	final private MemberRepository memberRepository;
	
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
		
		return memberRepository.save(member);
	}
}