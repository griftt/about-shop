package com.hc.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.shop.pojo.TbItem;
import com.hc.shop.service.ItemService;

@Controller
@RequestMapping("/json")
public class JsonController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/getItem/{item_id}")
	@ResponseBody
	public TbItem getItem(@PathVariable("item_id") Long id) {
		TbItem item = itemService.getById(id);
		return item;
	}

}
