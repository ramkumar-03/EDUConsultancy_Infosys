package com.educon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educon.model.user;

@Controller
public class userController {
	
	@RequestMapping("/loginpage")
	public String userLoginPage() {
		return "login";
	}
	
	@RequestMapping("/submitPage")
	public String userSubmitPage(@RequestParam("user")String user,@RequestParam("pwd") String pas,Model model) {
		if (user.equals("admin") && pas.equals("java")) {
			user obj = new user();
			obj.setUserName(user);
			obj.setPassword(pas);
			model.addAttribute("info",obj);
			return "success";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping("/success")
	public String userSuccessPage() {
	    return "success";
	}

}
