/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagement;

/**
 *
 * @author 5hayzi
 */
public class User {
    private String userName;
    private String userID;
    private String userPass;
    private String confirmPass;
    private String gender;
    
    public User(String name, String id, String pass, String confirm, String gender){
        this.userName = name;
        this.userID = id;
        this.userPass = pass;
        this.confirmPass = confirm;
        this.gender = gender;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String name){
        this.userName = name;
    }
    public String getUserID(){
        return userID;
    }
    public void setUserID(String id){
        this.userID = id;
    }
}
