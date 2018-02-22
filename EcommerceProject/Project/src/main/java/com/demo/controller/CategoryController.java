package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Category;
import com.demo.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/category")
	public String getCategoryPage(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", categoryService.list());
		return "category";
	}
	
	@RequestMapping(value="/addcategory", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category) {
		categoryService.createCategory(category);
		return"redirect:/category";
	}
	@RequestMapping("/editCategory-{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		model.addAttribute("category", this.categoryService.getById(id));
		return "category";
	}
	
	@RequestMapping("/deleteCategory-{id}")
	public String deleteCategory(@PathVariable("id") int id, Model model) {
		categoryService.delete(id);
		
		return "redirect:/category";
	}
	
	
	
}
