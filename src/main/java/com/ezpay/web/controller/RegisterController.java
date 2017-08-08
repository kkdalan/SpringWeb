package com.ezpay.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ezpay.web.controller.form.RegisterForm;
import com.ezpay.web.dao.intf.IUserDAO;
import com.ezpay.web.dto.User;

public class RegisterController extends SimpleFormController {

     private IUserDAO userDAO = null;

     public RegisterController() {
          setCommandClass(RegisterForm.class);
     }

     protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
          RegisterForm form = (RegisterForm)command;
          User user = new User();
          user.setEmail(form.getEmail());
          user.setUsername(form.getUsername());
          user.setPasswd(form.getPasswd());

          this.getUserDAO().insert(user);
          request.getSession().setAttribute("valid_user", form.getUsername());

          return new ModelAndView(this.getSuccessView());

     }

     public IUserDAO getUserDAO() {
          return userDAO;
     }

     public void setUserDAO(IUserDAO userDAO) {
          this.userDAO = userDAO;
     }

//     protected Object formBackingObject(HttpServletRequest request) throws Exception {
//          System.out.println("formBackingObject方法執行-->01");
//          setCommandClass(RegisterForm.class); //也可在此處調用setCommandClass方法     
//          return super.formBackingObject(request);
//     }
//
//     protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//          System.out.println("initBinder方法執行-->02");
//          super.initBinder(request, binder);
//     }
//
//     protected void onBind(HttpServletRequest request, Object command) throws Exception {
//          System.out.println("onBind方法執行-->03");
//          super.onBind(request, command);
//     }
//
//     protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
//                                                                                                        throws Exception {
//          System.out.println("onBindAndValidate方法執行-->04");
//          super.onBindAndValidate(request, command, errors);
//     }

}
