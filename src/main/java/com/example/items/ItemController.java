package com.example.items;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	protected Logger logger = Logger.getLogger(ItemController.class
			.getName());
	protected ItemRepository itemRepository;

	@Autowired
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@RequestMapping(value="/item", method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@RequestMapping(value="/item", method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@RequestMapping(value="/item/first", method = RequestMethod.GET)
	public Item getFirstItemInStatusNew() {
		return itemRepository.findItemsByStatus(ItemStatus.NEW).get(0);
	}
	
	@RequestMapping(value="/item/{id}", method = RequestMethod.GET)
	public Item getItem(@PathVariable Long id) {
		return itemRepository.findOne(id);
	}
	
	@RequestMapping(value="/items", method = RequestMethod.GET)
	public List<Item> findAllItems() {
		return itemRepository.findAll();
	}
	
	@RequestMapping(value="/items/{status}", method = RequestMethod.GET)
	public List<Item> findItemsbyStatus(@PathVariable ItemStatus status) {
		return itemRepository.findItemsByStatus(status);
	}

	@RequestMapping(value="/item", method = RequestMethod.DELETE)
	public void deleteItem(@RequestBody Item item) {
		itemRepository.delete(item);
	}
}
