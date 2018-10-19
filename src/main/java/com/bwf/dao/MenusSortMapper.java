package com.bwf.dao;

import com.bwf.entity.MenusSort;

public interface MenusSortMapper {
	int add(MenusSort ms);
	int update(MenusSort ms);
	MenusSort selectByUserId(Integer id);
}
