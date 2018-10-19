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
import com.bwf.entity.MenusSort;
import com.bwf.entity.User;
import com.bwf.service.IMenusSortService;

@Controller
@RequestMapping("menus")
public class MenusController {
	@Autowired
	IMenusSortService imss;
	
	@GetMapping("show")
	public String show(Integer success,ModelMap modelmap){
		System.out.println("用户进入菜单设置页面");
		if(success!=null){
			modelmap.addAttribute("success",success);
		}
		return "menus/show";
	}
	
	@PostMapping("sort")
	public String sort(Integer[] order,HttpSession session,Integer[] authIds){
		System.out.println("用户进行修改菜单顺序操作");
		User user=(User) session.getAttribute("user");		
		List<Auth> authes=user.getRole().getAuthes();
		//获取菜单名Id的List,用来判断该用户有没有该菜单
		List<Integer> authesId=new ArrayList<Integer>();
		for(Auth auth:authes){
			authesId.add(auth.getAuthId());
		}	
		//获取排序对应的菜单Id排序的数组,此时菜单就是 ID：45 2134  从前往后排了
		List<Integer> sort2=new ArrayList<Integer>();
		for(int i=0;i<order.length;i++){			//
			sort2.add(authIds[order[i]-1]);			
		}				
		String newmenus="";
		//排序完之后判断有没有这个菜单，没有则在排序里面删除这个，此时完成菜单重排
		for(int i=0;i<sort2.size();i++){
			newmenus+=sort2.get(i)+",";
			if(!authesId.contains(sort2.get(i))){
				sort2.remove(i);
			}			
		}
		List<Auth> newauthes=new ArrayList<Auth>();
		//将重排的所有替换到老user里
		for(int i=0;i<sort2.size();i++){
			newauthes.add(authes.get(sort2.get(i)-1));			
		}
		user.getRole().setAuthes(newauthes);
		
		session.setAttribute("user", user);
		//数据库更新数据操作
		MenusSort ms=new MenusSort();
		ms.setUserId(user.getUserId());
		ms.setNewMenus(newmenus);
		System.out.println(newmenus);
		imss.update(ms);
		
		return "redirect:/index?success=1";
	}
	
}
