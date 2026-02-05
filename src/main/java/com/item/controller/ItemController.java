package com.item.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.item.model.Item;
import com.item.service.IItemService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

	private IItemService service;
	
	@PostMapping
	public ResponseEntity<Item> addItem(@Valid  @RequestBody Item item){
		Item result = service.addItem(item);
		return new ResponseEntity<>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id){
		Item item = service.getItemById(id);
		return new ResponseEntity<>(item,HttpStatus.OK);
	}
	
}
