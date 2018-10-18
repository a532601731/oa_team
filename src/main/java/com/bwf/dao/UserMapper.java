package com.bwf.dao;

import com.bwf.entity.User;

public interface UserMapper {

	User getUserByLogin(User user);
	int updateNickname(User user);
}
