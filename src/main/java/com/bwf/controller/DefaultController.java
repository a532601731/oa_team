package com.bwf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bwf.service.impl.UserService;

@Controller
public class DefaultController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "index")
	public String toIndex() {
		return "index";
	}
	
	@GetMapping("Top")
	public String toTop() {
		return "Top";
	}
	
	@GetMapping("Left")
	public String toLeft() {
		return "Left";
	}
	
	@GetMapping("Mgr")
	public String toMgr() {
		return "Mgr";
	}
	
}
