package com.maven.webapp.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maven.webapp.cart.model.Item;
import com.maven.webapp.cart.service.CartService;

@RestController
public class ItemController {

	@Autowired
	CartService cartService;
	
	@PostMapping(value = "/item/add", consumes = "application/json")
	public long addItem(@RequestBody Item item) {
		return cartService.addNewItem(item);
	}
	
	@PostMapping(value = "/item/update", consumes = "application/json")
	public long updateItem(@RequestBody Item item) {
		return cartService.updateItem(item);
	}
	
	
	@GetMapping(value = "/item/search/{nameOrCategory}")
	public List<Item> searchItem(@PathVariable("nameOrCategory") String nameOrCategory)
	{
		return cartService.searchItem(nameOrCategory);
	}
	
	@GetMapping(value = "/item/delete/{id}")
	public boolean deleteItem(@PathVariable("id") int id)
	{
		return cartService.deleteItem(id);
	}
	
	@GetMapping("/item/getAll")
	public List<Item> getAll() {
		return cartService.getAll();
	}
	
	@GetMapping("/item/getTopTen")
	public List<Item> getTopTen() {
		return cartService.getTopTen();
	}

	@GetMapping("test")
	public String test() {
		return "Test success";
	}
	
	
}