package com.example.fastcp.mysql.domain.member.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.util.Assert;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
	
	// 변경되면 안되는 값은 final로 설정
	final private Long id;
	
	private String nickname;
	
	final private String email;
	
	final private LocalDate birthday;
	
	// entity의 경우, 생성시간 -> 디버깅 때 도움이 됨
	final private LocalDateTime createdAt;
	
	// 닉네임 유효성 검사용
	final private static Long NAME_MAX_LENGTH = 10L;

	@Builder
	public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
		this.id = id;
		this.email = Objects.requireNonNull(email);
		this.birthday = Objects.requireNonNull(birthday);
		
		validateNickname(nickname);
		this.nickname = Objects.requireNonNull(nickname);
		
		this.createdAt = createdAt == null? LocalDateTime.now() : createdAt;
	}
	
	public void changeNickname(String to) {
		// Not Null 확인 및 유효성 검사
		Objects.requireNonNull(to);
		validateNickname(to);
		
		nickname = to;
	}
	
	private void validateNickname(String nickname) {
		Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과했습니다.");
	}
}
