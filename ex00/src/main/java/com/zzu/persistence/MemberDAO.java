package com.zzu.persistence;

import com.zzu.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	public  void insertMember(MemberVO vo);
//	public MemberVO readMembers(String)
}
