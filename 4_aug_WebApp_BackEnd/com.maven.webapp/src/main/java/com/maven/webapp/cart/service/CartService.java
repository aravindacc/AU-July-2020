package com.maven.webapp.cart.service;


import java.util.List;

import com.maven.webapp.cart.model.Item;

public interface CartService {
	public long addNewItem(Item item);
	public List<Item> searchItem(String name);
	public List<Item> getAll();
	public List<Item> getTopTen();
	public boolean deleteItem(int id);
}
