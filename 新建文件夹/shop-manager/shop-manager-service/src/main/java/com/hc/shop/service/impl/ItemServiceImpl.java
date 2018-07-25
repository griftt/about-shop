package com.hc.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hc.shop.mapper.TbItemMapper;
import com.hc.shop.pojo.TbItem;
import com.hc.shop.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getById(Long id) {
		TbItem item = tbItemMapper.selectByPrimaryKey(id);
		return item;
	}

}
