package com.zzu.persistence;

import java.util.Date;

import com.zzu.domain.UserVO;
import com.zzu.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
