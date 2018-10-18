package com.bwf.service;

import com.bwf.entity.User;

public interface IUserService {
	User getUserByUserId(Integer id);
	User getUserByLogin(User user);
	int updateNickname(User user);
	int updatePwd(User user);

}
