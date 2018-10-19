package com.bwf.service;

import com.bwf.entity.MenusSort;

public interface IMenusSortService {
	int add(MenusSort ms);
	int update(MenusSort ms);
	MenusSort selectByUserId(Integer id);
}
