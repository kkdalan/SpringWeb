package com.ezpay.web.controller.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ezpay.web.controller.form.RegisterForm;

public class RegisterValidator implements Validator {

     public boolean supports(Class clazz) {
          return clazz.equals(RegisterForm.class);
     }

     public void validate(Object obj, Errors errors) {

          RegisterForm form = (RegisterForm)obj;

          if(!validateEmail(form.getEmail())) {
               errors.rejectValue("email", "invalid_email", null, "郵件格式不正確");
          }

          if(form.getPasswd().length() < 6 || form.getPasswd().length() > 16) {
               errors.rejectValue("passwd", "less-or-over", null, "密碼長度必須是6到16字元");
          }

          if(!form.getPasswd().equals(form.getPasswd2())) {
               errors.rejectValue("passwd", "not-equal", null, "兩次密碼輸入不符");
          }
     }

     private boolean validateEmail(String email) {
          return email.matches("^[_a-z0-9-]+([.]" + "[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
     }

}
