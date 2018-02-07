package jsfcrud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jsfcrud.dao.SubCategoryDao;
import jsfcrud.entity.SubCategory;


@Service
@Transactional
public class SubCategoryService {

	@Autowired
	private SubCategoryDao subCategoryDao;

	public void delete(SubCategory subCategory) {
		subCategoryDao.delete(subCategory);
	}

	public void delete(int id) {
		subCategoryDao.delete(id);
	}

	public void save(SubCategory subCategory) {
		subCategoryDao.save(subCategory);
	}

	public List<SubCategory> getList() {
		return subCategoryDao.findAll();
	}

	public SubCategory getSubCategoryById(int id) {
		return subCategoryDao.findOne(id);
	}
	
	public List<SubCategory> getListByMainCategoryId(int id){
		return subCategoryDao.getListByCategoryId(id);
	}
}

