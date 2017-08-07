package com.ezpay.web.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ezpay.web.dto.Bookmark;
import com.ezpay.web.dto.User;

public class BookmarkDAO implements IBookmarkDAO {

     private HibernateTemplate hibernateTemplate = null;

     public void insert(User user) {
          hibernateTemplate.saveOrUpdate(user);
     }

     public List findUserUrl(String username) {
          String queryString = "select bm.url from Bookmark as bm where bm.username='" + username + "'";
          List list = hibernateTemplate.find(queryString);
          return list;
     }

     public void addUserUrl(String username, String url) {
          Bookmark bm = new Bookmark();
          bm.setUsername(username);
          bm.setUrl(url);
          hibernateTemplate.saveOrUpdate(bm);
     }

     public void deleteUserUrls(String username, String[] urls) {
          for(int i = 0; i < urls.length; i++) {
               String queryString = "from Bookmark as bm where (bm.username='" + username + "') and (bm.url='" + urls[i] + "')";
               List list = hibernateTemplate.find(queryString);
               hibernateTemplate.delete(list.get(0));
          }
     }

     public HibernateTemplate getHibernateTemplate() {
          return hibernateTemplate;
     }

     public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
          this.hibernateTemplate = hibernateTemplate;
     }
}
