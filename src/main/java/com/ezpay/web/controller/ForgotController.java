package com.ezpay.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ezpay.web.dao.IUserDAO;
import com.ezpay.web.dto.User;
import com.ezpay.web.util.mail.SimpleMail;

public class ForgotController extends AbstractController {

     private IUserDAO userDAO = null;
     private SimpleMail simpleMail = null;
     private String loginPage = null;
     private String forgotPage = null;

     @Override
     protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
          String email = request.getParameter("email");
          if(email != null && !email.equals("")) {
               User user = getUserDAO().findByEmail(email);
               if(user!=null){
                    sendPasswdMail(user.getEmail(), user.getUsername(), user.getPasswd());
                    return new ModelAndView(this.getLoginPage());
               }else{
                    return new ModelAndView(this.getForgotPage());
               }
          } else {
               return new ModelAndView(this.getForgotPage());
          }
     }

     private void sendPasswdMail(String email, String username, String passwd) {
          String subject = "您的密碼";
          String text = username + "您好，您的密碼是" + passwd;
          getSimpleMail().sendMail(email, subject, text);
     }

     public IUserDAO getUserDAO() {
          return userDAO;
     }

     public void setUserDAO(IUserDAO userDAO) {
          this.userDAO = userDAO;
     }

     public SimpleMail getSimpleMail() {
          return simpleMail;
     }

     public void setSimpleMail(SimpleMail simpleMail) {
          this.simpleMail = simpleMail;
     }

     public String getLoginPage() {
          return loginPage;
     }

     public void setLoginPage(String loginPage) {
          this.loginPage = loginPage;
     }

     public String getForgotPage() {
          return forgotPage;
     }

     public void setForgotPage(String forgotPage) {
          this.forgotPage = forgotPage;
     }

}
