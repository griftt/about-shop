package com.hc.shop.service;

import com.hc.shop.common.pojo.UIDataGrid;
import com.hc.shop.pojo.TbItem;

public interface ItemService {
	public TbItem getById(Long id);
	public UIDataGrid getItemList(Integer page, Integer row);
}
