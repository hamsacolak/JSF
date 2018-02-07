package jsfcrud.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jsfcrud.dao.CategoryDao;
import jsfcrud.entity.Category;



@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public void delete(Category category) {
		categoryDao.delete(category);
	}
	

	public void delete(int id) {
		categoryDao.delete(id);
	}
	
	public void save(Category category)
	{
		categoryDao.save(category);
	}
	
	public List<Category> getList(){
		return categoryDao.findAll();
	}
	
	public Category getCategoryById(int id) {
		return categoryDao.findOne(id);
	}
}

