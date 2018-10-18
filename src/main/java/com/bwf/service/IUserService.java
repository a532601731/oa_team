package com.bwf.service;

import com.bwf.entity.User;

public interface IUserService {

	User getUserByLogin(User user);
	int updateNickname(User user);

}
