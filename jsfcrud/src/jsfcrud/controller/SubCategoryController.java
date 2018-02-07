package jsfcrud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import jsfcrud.entity.Category;
import jsfcrud.entity.SubCategory;
import jsfcrud.service.CategoryService;
import jsfcrud.service.SubCategoryService;



@ManagedBean
@ViewScoped
public class SubCategoryController {


	private SubCategory subCategory;
	private SubCategory selectedSubCategory;

	private boolean itemIsSelected;

	private Category category;

	@ManagedProperty(value = "#{categoryService}")
	private CategoryService categoryService;

	private List<SubCategory> listSubCategory;

	private List<Category> listCategory;

	@ManagedProperty(value = "#{subCategoryService}")
	private SubCategoryService subCategoryService;

	public Category getCategory(Integer id) {
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




	public SubCategoryController() {

		category = new Category();
		subCategory = new SubCategory();
		listSubCategory = new ArrayList<SubCategory>();
		listCategory = new ArrayList<Category>();

	}

	@PostConstruct
	public void init() {
		listCategory = categoryService.getList();
		listSubCategory = subCategoryService.getList();
	}

	public void onRowSelect(SelectEvent event) {

		subCategory = (SubCategory) event.getObject();
		itemIsSelected = true;

	}

	public void refreshList() {
		listSubCategory = new ArrayList<SubCategory>();
		listSubCategory = subCategoryService.getList();
		listCategory = new ArrayList<Category>();
		listCategory = categoryService.getList();
		clean();
		itemIsSelected = false;
	}

	public void clean() {
		subCategory = new SubCategory();
		itemIsSelected = false;
	}

	public void save() {
	
	
		if (itemIsSelected == false) {
			subCategory.setCreateDate(new Date());
		} else {
			subCategory.setUpdateDate(new Date());
		}

		subCategoryService.save(subCategory);
		subCategory = new SubCategory();
		itemIsSelected = false;
		refreshList();
	}

	public void delete(SubCategory subCategory) {
		subCategoryService.delete(subCategory);
		refreshList();
		itemIsSelected = false;
	}




	public SubCategory getSubCategory() {
		return subCategory;
	}




	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}




	public SubCategory getSelectedSubCategory() {
		return selectedSubCategory;
	}




	public void setSelectedSubCategory(SubCategory selectedSubCategory) {
		this.selectedSubCategory = selectedSubCategory;
	}




	public boolean isItemIsSelected() {
		return itemIsSelected;
	}




	public void setItemIsSelected(boolean itemIsSelected) {
		this.itemIsSelected = itemIsSelected;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public List<SubCategory> getListSubCategory() {
		return listSubCategory;
	}




	public void setListSubCategory(List<SubCategory> listSubCategory) {
		this.listSubCategory = listSubCategory;
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




	public void setSubCategoryService(SubCategoryService subCategoryService) {
		this.subCategoryService = subCategoryService;
	}

	

	
	
}
