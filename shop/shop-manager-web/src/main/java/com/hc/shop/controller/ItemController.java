package com.hc.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.shop.common.pojo.UIDataGrid;
import com.hc.shop.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/list")
	@ResponseBody
	public UIDataGrid getItemList(Integer page, Integer rows) {
		return itemService.getItemList(page, rows);
	}

}
