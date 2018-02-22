package com.demo.dao;

import java.util.List;

import com.demo.model.Category;

public interface CategoryDAO {
	
	public void createCategory(Category category);
	public String getCategories();
	public List<Category> list();
	public Category getById(int id);
	public void delete(int id);
	

}
