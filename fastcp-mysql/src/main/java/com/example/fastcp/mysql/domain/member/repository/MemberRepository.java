package com.example.fastcp.mysql.domain.member.repository;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.fastcp.mysql.domain.member.entity.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
	
	// DI
	final private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Member save(Member member) {
		/*
		 * member id를 보고 갱신 또는 삽입을 정함
		 * 반환값은 id를 담아서 반환한다
		 */
		if (member.getId() == null) {
			return insert(member);
		}
		
		return update(member);
	}
	
	private Member insert(Member member) {
		// JDBC Template 사용
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate())
				.withTableName("Member")
				.usingGeneratedKeyColumns("id");
		
		SqlParameterSource params = new BeanPropertySqlParameterSource(member);
		
		var id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
		
		return Member
				.builder()
				.id(id)
				.email(member.getEmail())
				.nickname(member.getNickname())
				.birthday(member.getBirthday())
				.createdAt(member.getCreatedAt())
				.build();
	}
	
	private Member update(Member member) {
		// TODO: implemented
		return member;
	}
}
