package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.UserMapper;
import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserByLogin(User user) {
		return userMapper.getUserByLogin(user);
	}

	@Override
	public int updateNickname(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateNickname(user);
	}

	@Override
	public int updatePwd(User user) {
		// TODO Auto-generated method stub
		return userMapper.updatePwd(user);
	}

	@Override
	public User getUserByUserId(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.getUserByUserId(id);
	}
	
}
