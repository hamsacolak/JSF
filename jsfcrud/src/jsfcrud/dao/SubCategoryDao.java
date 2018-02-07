package jsfcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jsfcrud.entity.SubCategory;

public interface SubCategoryDao extends JpaRepository<SubCategory, Integer> {
	
	@Query("SELECT p FROM SubCategory p where p.category.id=:categoryId")
	public List<SubCategory> getListByCategoryId(@Param("categoryId") int  categoryId);
	
}
