package com.example.fastcp.mysql.domain.member.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterMemberCommand(
		@JsonProperty("email")
		String email,
		@JsonProperty("nickname")
		String nickname,
		@JsonProperty("birthday")
		LocalDate birthday
) {}
