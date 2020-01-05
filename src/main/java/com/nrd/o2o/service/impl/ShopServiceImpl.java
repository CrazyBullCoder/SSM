package com.nrd.o2o.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nrd.o2o.dao.ShopDao;
import com.nrd.o2o.dto.ShopExecution;
import com.nrd.o2o.entity.Shop;
import com.nrd.o2o.enums.ShopStateEnum;
import com.nrd.o2o.exceptions.ShopOperationException;
import com.nrd.o2o.service.ShopService;
import com.nrd.o2o.util.ImageUtil;
import com.nrd.o2o.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	


	private void addShopImg(Shop shop, File shopImg) {
		// dest = "/upload/item/shop/" + shopId + "/"
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		// shopImgAddr =
		String shopImgAddr = ImageUtil.gererateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

	@Transactional
	@Override
	public ShopExecution addShop(Shop shop, File shopImg) {
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int efffectedNum = shopDao.insertShop(shop);
			if (efffectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				try {
					if (shopImg != null) {
						addShopImg(shop, shopImg);
					}
				} catch (Exception e) {
					throw new ShopOperationException("addShopImg error:" + e.getMessage());
				}
				efffectedNum = shopDao.updateShop(shop);
				if (efffectedNum <= 0) {
					throw new ShopOperationException("更新图片地址失败");
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

}
