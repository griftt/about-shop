package com.hc.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.shop.common.pojo.UIDataGrid;
import com.hc.shop.mapper.TbItemMapper;
import com.hc.shop.pojo.TbItem;
import com.hc.shop.pojo.TbItemExample;
import com.hc.shop.service.ItemService;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getById(Long id) {
		TbItem item = tbItemMapper.selectByPrimaryKey(id);
		return item;
	}

	@Override
	public UIDataGrid getItemList(Integer page, Integer row) {
		PageHelper.startPage(page, row);
		System.out.println("page and row" + page + " " + row);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		System.out.println(list.size());
		
		PageInfo<TbItem> info = new PageInfo<>(list);
		UIDataGrid grid = new UIDataGrid();
		grid.setRows(list);
		grid.setTotal(info.getTotal());
		return grid;
	}

}
