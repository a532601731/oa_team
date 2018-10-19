package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.MenusSortMapper;
import com.bwf.dao.OrderMapper;
import com.bwf.entity.MenusSort;
import com.bwf.service.IMenusSortService;
import com.bwf.service.IOrderService;

@Service
public class MenusSortServiceImpl implements IMenusSortService {

	@Autowired
	MenusSortMapper msm;
	@Override
	public int update(MenusSort ms) {
		// TODO Auto-generated method stub
		return msm.update(ms);
	}
	@Override
	public int add(MenusSort ms) {
		// TODO Auto-generated method stub
		return msm.add(ms);
	}
	@Override
	public MenusSort selectByUserId(Integer id) {
		// TODO Auto-generated method stub
		return msm.selectByUserId(id);
	}

	

}
