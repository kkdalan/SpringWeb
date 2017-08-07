package com.ezpay.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ezpay.web.controller.form.LoginForm;
import com.ezpay.web.dao.IUserDAO;
import com.ezpay.web.dto.User;

public class LoginController extends SimpleFormController {

     private IUserDAO userDAO = null;

     public LoginController() {
          setCommandClass(LoginForm.class);
     }

     protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
          LoginForm form = (LoginForm)command;
          User user = userDAO.findByName(form.getUsername());
          if(user == null) {
               errors.rejectValue("username", "no_such_user", "查無此人");
               return new ModelAndView(this.getFormView(), errors.getModel());

          } else if(user != null && !user.getPasswd().equals(form.getPasswd())) {
               errors.rejectValue("passwd", "wrong_passwd", "密碼錯誤");
               return new ModelAndView(this.getFormView(), errors.getModel());

          } else {
               request.getSession().setAttribute("valid_user", form.getUsername());
               return new ModelAndView(this.getSuccessView());
          }

     }

     public IUserDAO getUserDAO() {
          return userDAO;
     }

     public void setUserDAO(IUserDAO userDAO) {
          this.userDAO = userDAO;
     }

}
