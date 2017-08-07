package com.ezpay.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ezpay.web.dto.User;

public class UserDAO implements IUserDAO {

     private HibernateTemplate hibernateTemplate = null;

     public void insert(User user) {
          hibernateTemplate.saveOrUpdate(user);
     }

     public User findByName(String username) {
          if(username.equals("")) {
               return null;
          }
          String queryString = "from User user where user.username='" + username + "'";
          List users = hibernateTemplate.find(queryString);
          if(users.size() == 0) {
               return null;
          } else {
               return (User)users.get(0);
          }

     }

     public User findByEmail(String email) {
          String queryString = "from User user where user.email='" + email + "'";
          List users = hibernateTemplate.find(queryString);
          if(users.size() == 0) {
               return null;
          } else {
               return (User)users.get(0);
          }

     }

     public void update(User user) {
          hibernateTemplate.update(user);
     }

     public HibernateTemplate getHibernateTemplate() {
          return hibernateTemplate;
     }

     public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
          this.hibernateTemplate = hibernateTemplate;
     }
}
