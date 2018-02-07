package jsfcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jsfcrud.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer> {

}