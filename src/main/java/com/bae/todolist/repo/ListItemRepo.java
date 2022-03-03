package com.bae.todolist.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bae.todolist.entity.ListItem;
import com.bae.todolist.entity.ListType;

public interface ListItemRepo extends MongoRepository<ListItem, Integer>   {

	List<ListItem> findByList(ListType list);



}
