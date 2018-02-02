package com.zzu.persistence;

import com.zzu.domain.UserVO;
import com.zzu.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	
}
