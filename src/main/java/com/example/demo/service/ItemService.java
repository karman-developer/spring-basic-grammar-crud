package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository itemRepository;

	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> findAll(){
		return this.itemRepository.findAll();
	}
	
	public Item save(ItemForm itemForm) {
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setPrice(itemForm.getPrice());
		return this.itemRepository.save(item);
	}

	public Item findById(Integer id) {
		Optional<Item> optionalItem = this.itemRepository.findById(id);
		Item item = optionalItem.get();
		return item;
	}
	
	public Item update(Integer id, ItemForm itemForm) {
		Item item = this.findById(id);
		item.setName(itemForm.getName());
	    item.setPrice(itemForm.getPrice());
	    return this.itemRepository.save(item);
	}
	
	public Item delete(Integer id) {
		Item item = this.findById(id);
		item.setDeletedAt(LocalDateTime.now());
		return this.itemRepository.save(item);
	}
	
	public List<Item> findByDeletedAtIsNull(){
		return this.itemRepository.findByDeletedAtIsNull();
	}
}
