package com.bwf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bwf.entity.Auth;
import com.bwf.entity.User;

public class OrderUserAuthes {

	public static void order(User user, Integer order) {
		if(order == null) {
			return;
		}
		List<Auth> authes = user.getRole().getAuthes();
		Map<Integer, Auth> authMap = new HashMap<Integer, Auth>();
		for(Auth au: authes) {
			authMap.put(au.getAuthId(), au);
		}
		List<Auth> res = new ArrayList<Auth>();
		while(order > 0) {
			res.add(authMap.get(order & 7));
			order >>>= 3;
		}
		user.getRole().setAuthes(res);
	}
	
}
