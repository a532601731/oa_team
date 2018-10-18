package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
import com.bwf.service.IUserService;

@Controller
@RequestMapping("usersetting")
public class UserSettingController {
	@Autowired
	IUserService ius;
	
	@GetMapping("show")
	public String show(Integer success,Integer errors,ModelMap modelmap){
		if(success!=null){
			modelmap.addAttribute("success",success);
		}
		if(errors!=null){
			modelmap.addAttribute("errors",errors);
		}
		System.out.println("用户进入账户设置界面");
		
		return "usersetting/show";
	}
	
	@GetMapping("modifyData")
	public String modifyData(){
		System.out.println("用户进入修改资料界面");
		
		return "usersetting/modifyData";
	}
	@PostMapping("doModifyData")
	public String doModifyData(String nickname,HttpSession session){
		User user=(User) session.getAttribute("user");
		user.setNickname(nickname);
		
		System.out.println("用户进行修改资料操作");
		if(ius.updateNickname(user)>0){
			return "redirect:/usersetting/show?success=1";
		}else{
			return "redirect:/usersetting/show?errors=1";
		}
	}
	@GetMapping("modifyPassword")
	public String modifyPassword(){
		System.out.println("用户进入修改密码界面");
		
		return "usersetting/modifyPassword";
	}
	@RequestMapping("doModifyPassword")
	public String doModifyPassword(){
		System.out.println("用户进行修改密码操作");
		
		return "redirect:/usersetting/show";
	}
	
}
