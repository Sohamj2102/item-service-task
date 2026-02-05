package com.item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.item.exception.ItemNotFoundException;
import com.item.model.Item;

@Service
public class ItemServiceImpl implements IItemService {

	private List<Item> items=new ArrayList<>();
	private long idCounter=1;
	@Override
	public Item addItem(Item item) {
		item.setId(idCounter++);
		items.add(item);
		return item;
	}

	@Override
	public Item getItemById(Long id) {
		Item result = items.stream().filter(item->item.getId().equals(id))
		.findFirst()
		.orElseThrow(()->new ItemNotFoundException("Item not found with id,"+id));
		return result;
	}

}
