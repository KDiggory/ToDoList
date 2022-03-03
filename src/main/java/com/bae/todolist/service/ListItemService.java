package com.bae.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.todolist.entity.ListItem;
import com.bae.todolist.entity.ListType;
import com.bae.todolist.repo.ListItemRepo;


@Service
public class ListItemService {

	public ListItemRepo repo;


	public ListItemService(ListItemRepo repo) {
		super();
		this.repo = repo;
	}


	public ListItem createListItem(ListItem listItem ) {
		return this.repo.save(listItem);
	}
	
	public ListItem updateListItem(ListItem listItem, Integer id) {
		ListItem toUpdate = this.repo.findById(id).get();
		toUpdate.setName(listItem.getName());
		toUpdate.setDetails(listItem.getDetails());
		toUpdate.setListType(listItem.getListType());
		return this.repo.save(toUpdate);
	}
	
	public boolean deleteListItem(Integer id, Object object) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public List<ListItem> getAllListItems() {
		return this.repo.findAll();
		
	}
	public List<ListItem> getListItemsFromList(ListType list) {	
		return this.repo.findByList(list);
	}
	
	
}
