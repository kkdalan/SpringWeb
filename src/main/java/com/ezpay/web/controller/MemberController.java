package com.ezpay.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import com.ezpay.web.dao.intf.IBookmarkDAO;
import com.ezpay.web.dao.intf.IUserDAO;
import com.ezpay.web.dto.User;

public class MemberController extends MultiActionController {

     private IUserDAO userDAO = null;
     private IBookmarkDAO bookmarkDAO = null;

     private String memberPage = null;
     private String addBmPage = null;
     private String passwdPage = null;
     private String redirectPage = null;

     public ModelAndView displayUrl(HttpServletRequest req, HttpServletResponse res) {
          String username = (String)req.getSession().getAttribute("valid_user");
          if(username != null) {
               List urls = getBookmarkDAO().findUserUrl(username);
               return new ModelAndView(getMemberPage(), "urls", urls);
          } else {
               return new ModelAndView(new RedirectView(getRedirectPage()));
          }
     }

     public ModelAndView addUrl(HttpServletRequest req, HttpServletResponse res) {
          String username = (String)req.getSession().getAttribute("valid_user");
          if(username != null) {
               if(req.getParameter("new_url") != null) {
                    String url = (String)req.getParameter("new_url");
                    getBookmarkDAO().addUserUrl(username, url);
                    return displayUrl(req, res);
               } else {
                    return new ModelAndView(this.getAddBmPage());
               }
          } else {
               return new ModelAndView(new RedirectView(getRedirectPage()));
          }
     }

     public ModelAndView deleteUrl(HttpServletRequest req, HttpServletResponse res) {
          String username = (String)req.getSession().getAttribute("valid_user");
          if(username != null) {
               if(req.getParameterValues("del_me") != null) {
                    String[] deleted_urls = (String[])req.getParameterValues("del_me");
                    getBookmarkDAO().deleteUserUrls(username, deleted_urls);
                    return displayUrl(req, res);
               } else {
                    return new ModelAndView(this.getAddBmPage());
               }
          } else {
               return new ModelAndView(new RedirectView(getRedirectPage()));
          }
     }

     public ModelAndView changePasswd(HttpServletRequest req, HttpServletResponse res) {
          String username = (String)req.getSession().getAttribute("valid_user");
          if(username != null) {
               if(req.getParameterValues("new_passwd") != null) {
                    String passwd = (String)req.getParameter("new_passwd");
                    User user = getUserDAO().findByName(username);
                    user.setPasswd(passwd);
                    getUserDAO().update(user);
                    return displayUrl(req, res);
               } else {
                    return new ModelAndView(this.getPasswdPage());
               }
          } else {
               return new ModelAndView(new RedirectView(getRedirectPage()));
          }
     }

     public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
          req.getSession().invalidate();
          return new ModelAndView(new RedirectView(getRedirectPage()));
     }
     
     public IUserDAO getUserDAO() {
          return userDAO;
     }

     public void setUserDAO(IUserDAO userDAO) {
          this.userDAO = userDAO;
     }

     public IBookmarkDAO getBookmarkDAO() {
          return bookmarkDAO;
     }

     public void setBookmarkDAO(IBookmarkDAO bookmarkDAO) {
          this.bookmarkDAO = bookmarkDAO;
     }

     public String getMemberPage() {
          return memberPage;
     }

     public void setMemberPage(String memberPage) {
          this.memberPage = memberPage;
     }

     public String getAddBmPage() {
          return addBmPage;
     }

     public void setAddBmPage(String addBmPage) {
          this.addBmPage = addBmPage;
     }

     public String getPasswdPage() {
          return passwdPage;
     }

     public void setPasswdPage(String passwdPage) {
          this.passwdPage = passwdPage;
     }

     public String getRedirectPage() {
          return redirectPage;
     }

     public void setRedirectPage(String redirectPage) {
          this.redirectPage = redirectPage;
     }

}
