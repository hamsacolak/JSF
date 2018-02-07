package jsfcrud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jsfcrud.core.entity.BaseEntity;

@Entity
@Table(name = "tbl_category")
public class Category extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<SubCategory> subCategory;

	public String getName() {
		return name;
	}

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public void setName(String name) {
		this.name = name;
	}

}
