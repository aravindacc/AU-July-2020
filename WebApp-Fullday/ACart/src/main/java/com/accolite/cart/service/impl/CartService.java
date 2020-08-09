package com.accolite.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.cart.dao.ICartDao;
import com.accolite.cart.models.Item;
import com.accolite.cart.service.ICartService;

@Service
public class CartService implements ICartService {

	@Autowired
	ICartDao iCartDao;
	
	public long addNewItem(Item item) {
		return iCartDao.addNewItem(item);
	}

	@Override
	public Item searchItem(String keyTxt) {
		return iCartDao.searchItem(keyTxt);
	}

	@Override
	public Item updateItem(Item item) {
		int rowsAffected = iCartDao.updateItem(item);
		if(rowsAffected == 1)
			return item;
		return null;
	}

	@Override
	public List<Item> getAll() {
		return iCartDao.getAll();
	}

	@Override
	public boolean delete(int id) {
		int rowsAffected = iCartDao.delete(id);
		if(rowsAffected == 1)
			return true;
		return false;
	}
	
	@Override
	public List<Item> getRecentItems() {
		return iCartDao.getRecentItems();
	}

}
