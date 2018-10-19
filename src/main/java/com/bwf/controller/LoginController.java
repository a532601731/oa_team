package com.bwf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.Auth;
import com.bwf.entity.User;
import com.bwf.service.IMenusSortService;
import com.bwf.service.impl.OrderService;
import com.bwf.service.impl.UserService;
import com.bwf.util.OrderUserAuthes;

@Controller
@RequestMapping("user")
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;
	@Autowired
	IMenusSortService imss;

	@GetMapping(value = { "", "login" })
	public String login(Integer error, ModelMap modelMap) {
		modelMap.addAttribute("error", error);
		return "user/login";
	}

	@PostMapping("dologin")
	public String doLogin(User user, HttpSession session, ModelMap modelMap, Integer success) {
		if (success != null) {
			modelMap.addAttribute("success", success);
		}
		user = userService.getUserByLogin(user);
		if (user == null) {
			return "redirect:/user/login?error=1";
		}
		System.out.println(user);
		Integer order = orderService.getOrderByUserId(user.getUserId());
		OrderUserAuthes.order(user, order);
		session.getAttribute("user");
		// 获取菜单栏顺序操作

		String newme = imss.selectByUserId(user.getUserId()).getNewMenus();
		String[] authIds1 = newme.split(",");
		Integer[] authIds = new Integer[authIds1.length];
		for (int i = 0; i < authIds.length; i++) {
			authIds[i] = Integer.parseInt(authIds1[i]);
		}
		// Integer order=new Integer{1,2,3,4,5,6,7};
		Integer[] order1 = { 1, 2, 3, 4, 5, 6, 7 };

		List<Auth> authes = user.getRole().getAuthes();
		// 获取菜单名Id的List,用来判断该用户有没有该菜单
		List<Integer> authesId = new ArrayList<Integer>();
		for (Auth auth : authes) {
			authesId.add(auth.getAuthId());
		}
		// 获取排序对应的菜单Id排序的数组,此时菜单就是 ID：45 2134 从前往后排了
		List<Integer> sort2 = new ArrayList<Integer>();
		for (int i = 0; i < order1.length; i++) { //
			sort2.add(authIds[order1[i] - 1]);
		}
		// 排序完之后判断有没有这个菜单，没有则在排序里面删除这个，此时完成菜单重排
		for (int i = 0; i < sort2.size(); i++) {

			if (!authesId.contains(sort2.get(i))) {
				sort2.remove(i);
			}
		}
		List<Auth> newauthes = new ArrayList<Auth>();
		// 将重排的所有替换到老user里
		for (int i = 0; i < sort2.size(); i++) {
			newauthes.add(authes.get(sort2.get(i) - 1));
		}
		user.getRole().setAuthes(newauthes);

		session.setAttribute("user", user);

		return "redirect:/index";
	}
}
