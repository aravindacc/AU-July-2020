package com.maven.webapp.cart.service.impl;

import com.maven.webapp.cart.service.CartDao;
import com.maven.webapp.cart.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.webapp.cart.model.Item;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;

	public long addNewItem(Item item) {
		return cartDao.addNewItem(item);
	}
	

	public List<Item> searchItem(String name) {
		return cartDao.searchItem(name);
	}
	public List<Item> getAll()
	{
		return cartDao.getAll();
	}


	@Override
	public List<Item> getTopTen() {
		return cartDao.getTopTen();
	}


	@Override
	public boolean deleteItem(int id) {
		return cartDao.deleteItem(id);
	}
}