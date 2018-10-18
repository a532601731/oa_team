package com.bwf.dao;

import com.bwf.entity.User;

public interface UserMapper {

	User getUserByLogin(User user);
	User getUserByUserId(Integer id);
	int updateNickname(User user);
	int updatePwd(User user);
}
