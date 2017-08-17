package com.ezpay.web.dao.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.ezpay.web.dto.test.Bookmark;
import com.ezpay.web.dto.test.FavoriteBookmark;
import com.ezpay.web.dto.test.User;

public class UserBookmarkDAO {

	public static void main(String args[]) throws Exception {

		 testDeleteUsersByHQL();
		 testCreateBookmarksWithUsers();
		 testCreateBookmarkWithComments();
		 testQueryBookmarksWithUsersAndComments();//To fix
		 testCreateUserFavorites();
		 testCreateUserFavoriteBookmarks();
		 testQueryUsersWithBookmarks();
		 testDeleteUserFavoriteBookmarks();
		 testCreateUserByRelexiveLink();
		 testQueryUsersWithActualUser();
		 testCreateUserEditingHistoryAndShowing();
		 testQueryUsersByCriteria();
		 testQueryUsersByCriteriaWithAssociation();
		 testQueryUsersByExample();
		 testQueryObjectsByHQL();
		 testQueryUsersByHQL();
		 testAggragationFunctionByHQL();
		 
	}

	private static void testDeleteUsersByHQL() throws Exception {

		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Test delete users by HQL");
			System.out.println("-----------------------------------------");

			String hql = "from User user where user.username <> ? ";
			Query query = session.createQuery(hql);
			int j = 0;
			query.setString(j++, "test");
			List items = query.list();
			for(Object item: items){
				User user = (User) item;
				session.delete(item);
			}
			tx.commit();
			System.out.println("[ok] Successfully delete users (except \'test\')");
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}
	
	private static void testAggragationFunctionByHQL() throws Exception {

		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			System.out.println("-----------------------------------------");
			System.out.println("Test Aggragation Function by HQL");
			System.out.println("-----------------------------------------");

			String hql = "select count(*), max(user.username), min(user.username)"
					+ " from User user where user.username like ? ";
			Query query = session.createQuery(hql);
			int j = 0;
			query.setString(j++, "Kim Sori.__");
			Object[] results = (Object[]) query.uniqueResult();
			System.out.println("Summary information");
			System.out.println("         Total users = " + results[0]);
			System.out.println("            Max user = " + results[1]);
			System.out.println("            Min user = " + results[2]);

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersByHQL() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			System.out.println("-----------------------------------------");
			System.out.println("Query users by HQL");
			System.out.println("-----------------------------------------");

			String hql = "from User user " 
						+ " where user.username like ? " 
						+ " order by user.username desc ";
			Query query = session.createQuery(hql);
			int j = 0;
			query.setString(j++, "Kim Sori.__");
			List list = query.list();
			for(Object item : list){
				System.out.println("User: " + ((User) item).getUsername());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryObjectsByHQL() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			System.out.println("-----------------------------------------");
			System.out.println("Query objects by HQL");
			System.out.println("-----------------------------------------");

			List list = session.createQuery("from java.lang.Object").list();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Object: " + list.get(i));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersByExample() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Users by example");
			System.out.println("-----------------------------------------");

			User aUser = new User("Kim Sori");
			Example example = Example.create(aUser);
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(example);
			criteria.addOrder(Order.desc("username"));

			List list = criteria.list();
			for (int i = 0; i < list.size(); i++) {
				User user = (User) list.get(i);
				System.out.println("User: \"" + user.getUsername());
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersByCriteriaWithAssociation() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Users by criteria with association");
			System.out.println("-----------------------------------------");

			Criteria criteria = session.createCriteria(User.class);
			Criteria bookmarkCcriteria = criteria.createCriteria("bookmarks");
			bookmarkCcriteria.add(Expression.like("url", "%google%"));

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.desc("username"));

			List list = criteria.list();
			for (int i = 0; i < list.size(); i++) {
				User user = (User) list.get(i);
				System.out.println("User: \"" + user.getUsername());
				// System.out.println("User: \"" + user.getUsername() + "\"" +
				// listUserBookmarks(user.getBookmarks()));
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersByCriteria() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Users by criteria");
			System.out.println("-----------------------------------------");

			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Expression.like("username", "%Sori%"));

			Disjunction any = Expression.disjunction();
			any.add(Expression.isNotNull("lastUser"));
			any.add(Expression.in("username", new Object[] { "Kim Sori.3", "Kim Sori.1" }));
			criteria.add(any);

			Conjunction all = Expression.conjunction();
			all.add(Expression.like("username", "%Sori.%"));
			all.add(Expression.in("username", new Object[] { "Kim Sori.4", "Kim Sori.2", "Kim Sori.1" }));
			all.add(any);
			criteria.add(all);

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.desc("username"));

			List<User> users = criteria.list();
			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);
				System.out.println(user.getUsername());
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateUserEditingHistoryAndShowing() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Create user editing history");
			System.out.println("-----------------------------------------");

			User oldUser;
			oldUser = getUser("Kim Sori", true, session);

			System.out.println("## Editing user: " + oldUser.getUsername());
			int c = 15;
			for (int i = 0; i < c; i++) {
				User newUser;
				newUser = getUser("Kim Sori." + i, true, session);
				newUser.setLastUser(oldUser);
				session.update(newUser);
				oldUser = newUser;
			}
			tx.commit();

			System.out.println("## Show user history, username = " + oldUser.getUsername());
			List<String> records = new ArrayList<String>();
			String username = "Kim Sori.14";
			User aUser = getUser(username, false, session);
			User lastUser;
			for (; aUser != null;) {
				lastUser = aUser.getLastUser();
				if (lastUser != null) {
					records.add("User: " + aUser.getUsername() + " ( last = " + lastUser.getUsername() + " )");
					username = lastUser.getUsername();
				} else {
					records.add("User: " + aUser.getUsername() + " ( last = " + lastUser + " )");
					username = null;
				}
				aUser = getUser(username, false, session);
			}

			System.out.println("## SHOW HISTORY ##");
			for (String record : records) {
				System.out.println(record);
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersWithActualUser() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Users with actual users");
			System.out.println("-----------------------------------------");
			List users = findUsersByUsername("Jerry.3", session);
			for (Iterator iter = users.iterator(); iter.hasNext();) {
				User aUser = (User) iter.next();
				System.out.println(
						"User: " + aUser.getUsername() + ", actual user = " + aUser.getActualUser().getUsername());
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateUserByRelexiveLink() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Create users by relexive link");
			System.out.println("-----------------------------------------");

			User user, aliasUser;
			user = getUser("Jerry", true, session);

			aliasUser = getUser("Jerry.1", true, session);
			aliasUser.setActualUser(user);
			session.update(aliasUser);

			aliasUser = getUser("Jerry.2", true, session);
			aliasUser.setActualUser(user);
			session.update(aliasUser);

			aliasUser = getUser("Jerry.3", true, session);
			aliasUser.setActualUser(user);
			session.update(aliasUser);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testDeleteUserFavoriteBookmarks() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Delete user favorite bookmarks");
			System.out.println("-----------------------------------------");

			User user;
			user = getUser("Jerry", true, session);
			user.getFavoriteBookmarks().remove(0);
			session.update(user);
			// session.delete(user);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateUserFavoriteBookmarks() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Add user favorite bookmarks");
			System.out.println("-----------------------------------------");

			User user;
			user = new User("Jerry", new HashSet(), new ArrayList());
			addUserFavoriteBookmarks(user,
					getFavoriteBookmark("https://www.github.com", "favorite URL.1", true, session));
			addUserFavoriteBookmarks(user,
					getFavoriteBookmark("https://www.github-1.com", "favorite URL.2", true, session));
			addUserFavoriteBookmarks(user,
					getFavoriteBookmark("https://www.github-2.com", "favorite URL.3", true, session));

			session.save(user);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateUserFavorites() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Add user favorites");
			System.out.println("-----------------------------------------");

			User user;
			user = new User("Alan", new ArrayList());
			addUserFavorites(user, getBookmark("https://openhome.cc", true, session));
			addUserFavorites(user, getBookmark("https://openhome-a.cc", true, session));
			addUserFavorites(user, getBookmark("https://openhome-b.cc", true, session));
			session.save(user);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateBookmarksWithUsers() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Add Bookmarks with users");
			System.out.println("-----------------------------------------");
			Bookmark bookmark;
			bookmark = new Bookmark("http://www.google.com.tw", new HashSet());
			addBookmarkUser(bookmark, getUser("DOG", true, session));
			addBookmarkUser(bookmark, getUser("CAT", true, session));
			session.save(bookmark);

			bookmark = new Bookmark("http://www.yahoo.com.tw", new HashSet());
			addBookmarkUser(bookmark, getUser("CAT", true, session));
			addBookmarkUser(bookmark, getUser("Pig", true, session));
			session.save(bookmark);

			bookmark = new Bookmark("https://com.ezpay.com.tw", new HashSet());
			session.save(bookmark);

			bookmark = new Bookmark("https://org.springframework.com", new HashSet());
			addBookmarkUser(bookmark, getUser("Tiger", true, session));
			addBookmarkUser(bookmark, getUser("Snake", true, session));
			addBookmarkUser(bookmark, getUser("Monkey", true, session));
			session.save(bookmark);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryBookmarksWithUsersAndComments() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Bookmarks with users");
			System.out.println("-----------------------------------------");
			List bookmarks = findBookmarksByUrl("http://www.google.com.tw", session);
			for (Iterator iter = bookmarks.iterator(); iter.hasNext();) {
				Bookmark aBookmark = (Bookmark) iter.next();
//				System.out.println("Bookmark: \"" + aBookmark.getUrl() + "\"" + listBookmarkUsernames(aBookmark.getUsers()));
				System.out.println("Bookmark: " + aBookmark.getUrl());
				for (Iterator comIter = aBookmark.getComments().iterator(); comIter.hasNext();) {
					System.out.println("Bookmark: " + aBookmark.getUrl() + " -> comments: " + comIter.next());
				}
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testQueryUsersWithBookmarks() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Query Users with bookmarks");
			System.out.println("-----------------------------------------");
			List users = findUsersByUsername("CAT", session);
			for (Iterator iter = users.iterator(); iter.hasNext();) {
				User aUser = (User) iter.next();
				System.out.println("User: \"" + aUser.getUsername() + "\"" + listUserBookmarks(aUser.getBookmarks()));
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	private static void testCreateBookmarkWithComments() throws Exception {
		Configuration config = new Configuration();
		config.addClass(User.class).addClass(Bookmark.class);

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println("-----------------------------------------");
			System.out.println("Add Bookmarks with comments");
			System.out.println("-----------------------------------------");
			Bookmark bookmark;
			bookmark = new Bookmark("http://www.google.com.tw", new HashSet(), new HashSet());
			addBookmarkComment(bookmark, "comment 1");
			addBookmarkComment(bookmark, "comment 2");
			addBookmarkComment(bookmark, "comment 3");
			session.save(bookmark);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	public static List findUsersByUsername(String username, Session session) {
		Query query = session.getNamedQuery("com.ezpay.web.usersByUsername");
		query.setString("username", username);
		return query.list();
	}

	public static String listUserBookmarks(Set bookmarks) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = bookmarks.iterator(); iter.hasNext();) {
			Bookmark bookmark = (Bookmark) iter.next();
			result.append((result.length() == 0) ? "(" : ",\n            ");
			result.append(bookmark.getUrl());
		}
		if (result.length() > 0) {
			result.append(") ");
		}
		return result.toString();
	}

	public static List findBookmarksByUrl(String url, Session session) {
		Query query = session.getNamedQuery("com.ezpay.web.bookarksByUrl");
		query.setString("url", url);
		return query.list();
	}

	public static String listBookmarkUsernames(Set users) {
		StringBuffer result = new StringBuffer();
		for (Iterator iter = users.iterator(); iter.hasNext();) {
			User user = (User) iter.next();
			result.append((result.length() == 0) ? "(" : ", ");
			result.append(user.getUsername());
		}
		if (result.length() > 0) {
			result.append(") ");
		}
		return result.toString();
	}

	public static User getUser(String username, boolean create, Session session) {
		Query query = session.getNamedQuery("com.ezpay.web.userByName");
		query.setString("username", username);
		User found = (User) query.uniqueResult();
		if (found == null && create) {
			found = new User(username);
			session.save(found);
		}

		if (found != null && found.getActualUser() != null) {
			return found.getActualUser();
		}

		return found;
	}

	public static Bookmark getBookmark(String url, boolean create, Session session) {
		Query query = session.getNamedQuery("com.ezpay.web.bookarksByUrl");
		query.setString("url", url);
		Bookmark found = (Bookmark) query.uniqueResult();
		if (found == null && create) {
			found = new Bookmark(url);
			session.save(found);
		}
		return found;
	}

	public static FavoriteBookmark getFavoriteBookmark(String url, String desc, boolean create, Session session) {
		Query query = session.getNamedQuery("com.ezpay.web.bookarksByUrl");
		query.setString("url", url);
		Bookmark found = (Bookmark) query.uniqueResult();
		if (found == null && create) {
			found = new Bookmark(url);
			session.save(found);
		}
		FavoriteBookmark favoriteBookmark = new FavoriteBookmark(desc, found);
		return favoriteBookmark;
	}

	private static void addBookmarkUser(Bookmark bookmark, User user) {
		bookmark.getUsers().add(user);
	}

	private static void addBookmarkComment(Bookmark bookmark, String comment) {
		bookmark.getComments().add(comment);
	}

	private static void addUserFavorites(User user, Bookmark bookmark) {
		user.getFavorites().add(bookmark);
	}

	private static void addUserFavoriteBookmarks(User user, FavoriteBookmark favoriteBookmark) {
		user.getFavoriteBookmarks().add(favoriteBookmark);
	}

	
}
