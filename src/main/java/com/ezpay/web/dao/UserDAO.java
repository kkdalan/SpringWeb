package com.ezpay.web.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ezpay.web.dao.intf.IUserDAO;
import com.ezpay.web.dto.User;

public class UserDAO implements IUserDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void insert(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}

	public void update(User user) {
		hibernateTemplate.update(user);
	}

	public User findByName(String username) {
		if (username.equals("")) {
			return null;
		}
		String queryString = "from User user where user.username='" + username + "'";
		List users = hibernateTemplate.find(queryString);
		if (users.size() == 0) {
			return null;
		} else {
			return (User) users.get(0);
		}

	}

	public User findByEmail(String email) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("email", email));
		List<User> users = hibernateTemplate.findByCriteria(criteria);
		return (users.size() == 0) ? null : users.get(0);
	}

	public List<User> findUsersByName(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.like("username", username + "%"));
		List<User> users = hibernateTemplate.findByCriteria(criteria);
		return users;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
