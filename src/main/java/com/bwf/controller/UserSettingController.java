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
	public String doModifyPassword(String oldpwd,String newpwd,HttpSession session){
		System.out.println("用户进行修改密码操作");
		User user=(User) session.getAttribute("user");
		//防止用户此时第二次修改密码，而他没有退出登录，导致的旧密码在session中没有更新的问题
		User user1=ius.getUserByUserId(user.getUserId());
		if(user1.getPassword().equals(oldpwd)){
			user1.setPassword(newpwd);
			if(ius.updatePwd(user1)>0){
				//修改密码成功
				return "redirect:/usersetting/show?success=2";
			}else{
				//修改密码失败
				return "redirect:/usersetting/show?errors=3";
			}
		}else
		{//因为老密码输入错误，导致的修改密码失败
			return "redirect:/usersetting/show?errors=2";
			}
		
	}
	
}
