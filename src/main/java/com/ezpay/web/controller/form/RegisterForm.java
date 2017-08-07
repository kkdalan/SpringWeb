package com.ezpay.web.controller.form;

public class RegisterForm {

     private String email = null;
     private String username = null;
     private String passwd = null;
     private String passwd2 = null;

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPasswd() {
          return passwd;
     }

     public void setPasswd(String passwd) {
          this.passwd = passwd;
     }

     public String getPasswd2() {
          return passwd2;
     }

     public void setPasswd2(String passwd2) {
          this.passwd2 = passwd2;
     }

}
