package com.bwf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.User;
import com.bwf.service.IUserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class test1 {
	@Autowired
	IUserService ius;
	
	@Test
	public void test(){
	User user=new User();
		user.setUserId(1);
		user.setNickname("你爸爸");
		System.out.println(user);
		ius.updateNickname(user);
		
		
	}
}
