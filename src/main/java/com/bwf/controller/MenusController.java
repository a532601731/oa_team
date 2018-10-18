package com.bwf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menus")
public class MenusController {
	
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入菜单设置页面");
		
		return "menus/show";
	}
	
}
