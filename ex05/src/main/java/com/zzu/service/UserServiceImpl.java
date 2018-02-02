package com.zzu.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zzu.domain.UserVO;
import com.zzu.dto.LoginDTO;
import com.zzu.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	
}
