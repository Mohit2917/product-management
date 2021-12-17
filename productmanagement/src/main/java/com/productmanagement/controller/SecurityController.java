package com.productmanagement.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class SecurityController {

//	@RequestMapping(value = "/username", method = RequestMethod.GET)
//	@ResponseBody
	public String currentUserName() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return name;
	}
	

}
