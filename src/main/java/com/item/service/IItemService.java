package com.item.service;

import com.item.model.Item;

public interface IItemService {

	Item addItem(Item item);
	Item getItemById(Long id);
}
