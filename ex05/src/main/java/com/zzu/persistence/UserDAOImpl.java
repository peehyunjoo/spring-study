package com.zzu.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zzu.domain.UserVO;
import com.zzu.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	@Inject
	private SqlSession session;
	private static String namespace = "com.zzu.mapper.UserMapper";

	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login",dto);
	}
}
