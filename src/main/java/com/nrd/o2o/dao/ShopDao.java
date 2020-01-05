package com.nrd.o2o.dao;

import com.nrd.o2o.entity.Shop;
public interface ShopDao {
	/**
	 * 新增shop
	 * @author admin
	 *
	 */
	int insertShop(Shop shop);
	
	int updateShop(Shop shop);
}
