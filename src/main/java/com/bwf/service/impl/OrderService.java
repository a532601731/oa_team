package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.OrderMapper;
import com.bwf.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public Integer getOrderByUserId(int userId) {
		return orderMapper.getOrderByUserId(userId);
	}

}
