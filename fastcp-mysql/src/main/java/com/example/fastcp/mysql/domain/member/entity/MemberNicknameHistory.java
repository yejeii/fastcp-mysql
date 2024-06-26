package com.example.fastcp.mysql.domain.member.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberNicknameHistory {
	
	final private Long id;
	final private Long memberId;
	final private String nickname;
	final private LocalDateTime createdAt;

	@Builder
	public MemberNicknameHistory(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
		this.id = id;
		this.memberId = Objects.requireNonNull(memberId);
		this.nickname = Objects.requireNonNull(nickname);
		this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
	}

	
}
