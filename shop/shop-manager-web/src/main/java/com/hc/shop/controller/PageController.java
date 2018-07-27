package com.hc.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/{path}")
	public String getModel(@PathVariable("path") String str) {
		return str;
	}
}
