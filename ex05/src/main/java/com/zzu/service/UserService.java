package com.zzu.service;

import com.zzu.domain.UserVO;
import com.zzu.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
