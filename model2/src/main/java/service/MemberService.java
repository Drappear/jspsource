package service;

import dto.MemberDTO;

public interface MemberService{
	// DAO의 CRUD 메소드 호출
		int create(MemberDTO memberDto);

		MemberDTO read(MemberDTO memberDto);

		int update(MemberDTO memberDto);

		int delete(MemberDTO memberDto);
}
