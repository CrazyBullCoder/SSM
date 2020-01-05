package com.nrd.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nrd.o2o.BaseTest;
import com.nrd.o2o.dto.ShopExecution;
import com.nrd.o2o.entity.Area;
import com.nrd.o2o.entity.PersonInfo;
import com.nrd.o2o.entity.Shop;
import com.nrd.o2o.entity.ShopCategory;
import com.nrd.o2o.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{

	@Autowired
	private ShopService shopService;
	@Test
	public void testAddShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		shop.setOwner(owner);
		area.setAreaId(2);
		shop.setArea(area);
		shopCategory.setShopCategoryId(1L);
		shop.setShopCategory(shopCategory);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺1");
		shop.setShopDesc("test1");
		shop.setShopAddr("test1");
		shop.setPhone("test1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("E:\\Pictures\\1.jpg");
		//ShopExecution se = shopService.addShop(shop,shopImg);
		//assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}
