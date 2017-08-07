package com.ezpay.web.dao;

import com.ezpay.web.dto.User;

public interface IUserDAO {

     public void insert(User user);

     public User findByName(String username);

     public User findByEmail(String email);

     public void update(User user);

}
