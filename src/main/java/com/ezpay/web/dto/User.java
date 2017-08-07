package com.ezpay.web.dto;

public class User {

     private Integer id = null;
     private String username = null;
     private String passwd = null;
     private String email = null;

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
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

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

}
