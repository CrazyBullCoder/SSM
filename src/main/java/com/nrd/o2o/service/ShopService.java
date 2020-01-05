package com.nrd.o2o.service;

import java.io.File;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.nrd.o2o.dto.ShopExecution;
import com.nrd.o2o.entity.Shop;

public interface ShopService {
	//ShopExecution addShop(Shop shop, CommonsMultipartFile  shopImg);
	ShopExecution addShop(Shop shop, File  shopImg);
}
