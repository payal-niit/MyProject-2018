package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.daoimpl.CategoryDAOImpl;
import com.demo.model.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	public void createCategory(Category category) {
		categoryDAOImpl.createCategory(category);
	}
	public String getCategories() {
		return categoryDAOImpl.getCategories();
	}
	public List<Category> list() {
		return categoryDAOImpl.list();
	}
	public Category getById(int id) {
		return categoryDAOImpl.getById(id);
	}
	public void delete(int id) {
		categoryDAOImpl.delete(id);
	}

}
