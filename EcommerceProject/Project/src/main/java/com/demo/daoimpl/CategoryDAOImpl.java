package com.demo.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.CategoryDAO;
import com.demo.model.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	SessionFactory sessionFactory;

	public void createCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}

	public String getCategories() {
		
		return null;
	}

	public List<Category> list() {
		Session session=this.sessionFactory.getCurrentSession();
		System.out.println("here");
		@SuppressWarnings("unchecked")
		List<Category> getCategory = session.createQuery("from Category").list();
		return getCategory;
	}

	public Category getById(int id) {
		String q="from Category where id="+id;
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		List<Category> list=(List<Category>) query.list();
		return list.get(0);
	}

	public void delete(int id) {
		Category c=new Category();
		c.setId(id);
		sessionFactory.getCurrentSession().delete(c);
		
	}

}
