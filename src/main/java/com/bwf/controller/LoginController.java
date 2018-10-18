package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
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
	
	@GetMapping(value={"", "login"})
	public String login(Integer error, ModelMap modelMap) {
		modelMap.addAttribute("error", error);
		return "user/login";
	}
	
	@PostMapping("dologin")
	public String doLogin(User user, HttpSession session, ModelMap modelMap) {
		user = userService.getUserByLogin(user);
		if(user == null) {
			return "redirect:/user/login?error=1";
		}
		System.out.println(user);
		Integer order = orderService.getOrderByUserId(user.getUserId());
		OrderUserAuthes.order(user, order);
		session.getAttribute("user");
		session.setAttribute("user", user);
		return "redirect:/index";
	}
}
