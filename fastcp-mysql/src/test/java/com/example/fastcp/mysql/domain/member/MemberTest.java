package com.example.fastcp.mysql.domain.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.fastcp.mysql.domain.member.util.MemberFixtureFactory;

public class MemberTest {
	
	@DisplayName("회원은 닉네임을 변경할 수 있다")
	@Test
	public void testChangeNickname() {
//		LongStream.range(0, 10)
//			.mapToObj(MemberFixtureFactory::create)
//			.forEach(Member -> {
//				System.out.println(Member.getNickname());
//			});		
		
		var member = MemberFixtureFactory.create();
		var expected = "pnu";
		
		member.changeNickname(expected);
		
		Assertions.assertEquals(expected, member.getNickname());
	}

	@DisplayName("회원은 닉네임을 10자를 초과할 수 없다")
	@Test
	public void testNicknameMaxLength() {

		var member = MemberFixtureFactory.create();
		var overMaxLengthName = "pnupnupnupnu";
		
		Assertions.assertThrows(
				IllegalArgumentException.class, 
				() -> member.changeNickname(overMaxLengthName)
		);
		
	}

}
