package com.example.fastcp.mysql.domain.member.util;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import com.example.fastcp.mysql.domain.member.entity.Member;

public class MemberFixtureFactory {

	static public Member create() {
		var param = new EasyRandomParameters();
		return new EasyRandom(param).nextObject(Member.class);
	}
	
	static public Member create(Long seed) {
		var param = new EasyRandomParameters().seed(seed);
		return new EasyRandom(param).nextObject(Member.class);
	}
}
