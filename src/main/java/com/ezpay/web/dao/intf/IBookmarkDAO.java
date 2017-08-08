package com.ezpay.web.dao.intf;

import java.util.List;

public interface IBookmarkDAO {

     public List findUserUrl(String username);

     public void addUserUrl(String username, String url);

     public void deleteUserUrls(String username, String[] urls);

}
