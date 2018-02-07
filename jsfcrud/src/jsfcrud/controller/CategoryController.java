package jsfcrud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import jsfcrud.entity.Category;
import jsfcrud.service.CategoryService;

@ManagedBean
@SessionScoped
public class CategoryController {

	private Category category;

	private Category selectedCategory;

	private boolean itemIsSelected;

	private List<Category> listCategory;

	@ManagedProperty(value = "#{categoryService}")
	private CategoryService categoryService;

	public Category get(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("no id provided");
		}
		for (Category cat : listCategory) {
			if (id.equals(cat.getId())) {
				return cat;
			}
		}
		return null;
	}

	@PostConstruct
	public void init() {

		listCategory = categoryService.getList();
	}

	public CategoryController() {
		category = new Category();
		listCategory = new ArrayList<Category>();
	}

	public boolean isItemIsSelected() {
		return itemIsSelected;
	}

	public void setItemIsSelected(boolean itemIsSelected) {
		this.itemIsSelected = itemIsSelected;
	}

	public void onRowSelect(SelectEvent event) {
		category = (Category) event.getObject();
		itemIsSelected = true;
	}

	public void refreshList() {
		listCategory = new ArrayList<Category>();
		listCategory = categoryService.getList();
		clean();
		itemIsSelected = false;
	}

	public void clean() {
		category = new Category();
		itemIsSelected = false;
	}

	public void save() {

		if (itemIsSelected == false) {
			category.setCreateDate(new Date());
		} else {
			category.setUpdateDate(new Date());
		}
		categoryService.save(category);
		category = new Category();
		itemIsSelected = false;
		refreshList();
	}

	public void delete(Category category) {
		categoryService.delete(category);
		refreshList();
		itemIsSelected=false;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	

	
	
}
