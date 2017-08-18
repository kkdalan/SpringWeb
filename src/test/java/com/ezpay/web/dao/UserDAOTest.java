package com.ezpay.web.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ezpay.web.dao.intf.IUserDAO;
import com.ezpay.web.dto.User;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {

	private ApplicationContext ac = null;
	private IUserDAO userDAO = null;

	public UserDAOTest() {
		ac = new ClassPathXmlApplicationContext("spring-servlet.xml");
	}

	@Override
	protected void setUp() {
		userDAO = (IUserDAO) ac.getBean("userDAO");
	}

	@Override
	protected void tearDown() {
		userDAO = null;
	}

	@Test
	public void testInsert() {
		try {
			String username = "Tom";
			String passwd = "xxxx";
			String email = "tom@neweb.com.tw";
			User user = new User();
			user.setUsername(username);
			user.setPasswd(passwd);
			user.setEmail(email);
			userDAO.insert(user);
		} catch (Exception e) {
			fail("[ Unit Test ] failed => " + e.toString());
		}
	}

	@Test
	public void testFindByName() {
		String username = "Tom";
		User user = userDAO.findByName(username);
		String actual = user.getUsername();
		String expected = "Tom";
		assertEquals(expected, actual);
	}

	@Test
	public void testFindByEmail() {
		String email = "tom@neweb.com.tw";
		User user = userDAO.findByEmail(email);
		String actual = user.getUsername();
		String expected = "Tom";
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdate() {
		try {
			String username = "Tom";
			User user = userDAO.findByName(username);
			user.setUsername(username);
			user.setPasswd("ooooo");
			user.setEmail("test@neweb.com.tw");
			userDAO.update(user);
		} catch (Exception e) {
			fail("[ Unit Test ] failed => " + e.toString());
		}
	}
	
	

}
