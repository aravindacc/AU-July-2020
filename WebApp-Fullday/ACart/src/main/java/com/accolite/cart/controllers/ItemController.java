package com.accolite.cart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.cart.models.Item;
import com.accolite.cart.service.ICartService;

@RestController
public class ItemController {

	@Autowired 
	ICartService iCartService;
	
	@GetMapping("test")
	public String test() {
		return "Test success";
	}
	
	@RequestMapping(value = "/item/add", method = RequestMethod.POST, consumes = "application/json")
	public long addItem(@RequestBody Item item) {
		return iCartService.addNewItem(item);
	}
	
	@GetMapping("/item/search/{keyTxt}")
	public Item searchByName(@PathVariable("keyTxt") String keyTxt) {
		return iCartService.searchItem(keyTxt);
	}
	
	@PostMapping(value = "/item/update", consumes = "application/json")
	public Item updateItem(@RequestBody Item item) {
		return iCartService.updateItem(item);
	}
	
	@GetMapping("/item/getAll")
	public List<Item> getAll() {
		return iCartService.getAll();
	}
	
	@GetMapping("/item/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		return iCartService.delete(id);
	}
	
	@GetMapping("/item/getRecentItems")
	public List<Item> getRecentItems() {
		return iCartService.getRecentItems();
	}
}
