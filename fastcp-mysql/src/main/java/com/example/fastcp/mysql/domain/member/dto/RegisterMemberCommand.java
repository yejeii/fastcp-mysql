package com.example.fastcp.mysql.domain.member.dto;

import java.time.LocalDate;

public record RegisterMemberCommand(
		String email,
		String nickname,
		LocalDate birthday
) {}
