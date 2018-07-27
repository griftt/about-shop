package com.hc.shop.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.shop.pojo.TbItem;
import com.hc.shop.pojo.TbItemExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-dao.xml")
public class TbItemMapperTest {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Test
	public void testSelectByExample() {
		PageHelper.startPage(1, 30);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		System.out.println(list.size());
		
		PageInfo<TbItem> info = new PageInfo<>(list);
		System.out.println(info);
		System.out.println(info.getTotal());
		System.out.println(info.getPageNum());
		System.out.println(info.getPages());
		System.out.println(info.getPageSize());
	}

}
