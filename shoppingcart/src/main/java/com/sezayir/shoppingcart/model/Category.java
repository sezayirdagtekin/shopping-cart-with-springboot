package com.sezayir.shoppingcart.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sezayir
 *
 */
public class Category {

	private String uuid;
	private String title;
	private Category parent;
	
	public Category() {
		
	}

	public Category(String title, Category parent) {
		this.uuid = UUID.randomUUID().toString();
		this.title = title;
		this.parent = parent;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
