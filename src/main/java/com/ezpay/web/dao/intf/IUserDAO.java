package com.ezpay.web.dao.intf;

import java.util.List;

import com.ezpay.web.dto.User;

public interface IUserDAO {

	public void insert(User user);

	public User findByName(String username);

	public User findByEmail(String email);

	public void update(User user);

	public List<User> findUsersByName(String username);

}
