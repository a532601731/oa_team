package com.bwf.test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bwf.entity.MenusSort;
import com.bwf.entity.User;
import com.bwf.service.IMenusSortService;
import com.bwf.service.IUserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class test1 {
	@Autowired
	IUserService ius;
	@Autowired
	IMenusSortService imss;
	@Test
	public void test(){
//		MenusSort ms=new MenusSort();
//		ms.setUserId(1);
//		ms.setNewMenus("1,2,3,4,5,6,7");
//		System.out.println(imss.update(ms));
		System.out.println(imss.selectByUserId(1));
	}
}
