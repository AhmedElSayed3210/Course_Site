/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import modle.DB;
import modle.course;

/**
 *
 * @author ahmed
 */
@ManagedBean
public class displaybean {
    
    
    
    List<course> courses;
    DB d=new DB();
    private  String cname;
    
    
    private String sname;
    private String phone;
    private String mail;
    private String eduction;
    private String msg;
private static String coursname;

    public static String getCoursname() {
        return coursname;
    }

    public static void setCoursname(String coursname) {
        displaybean.coursname = coursname;
    }
    public  String getCname() {
        return cname;
    }

    public  void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   
    public List<course> getCourses(){
    
        courses= d.selectallcourses();
        
         return courses;
    }
    
    public String applypage (String cname){
        
    this.coursname=cname;
    this.cname=cname;
    return "applycourse";
    }
    
    public void addstudent (){
        
        boolean f = d.addstudent(sname, phone, mail, eduction, coursname);
         if(f==true){
           
        msg="student added successfully";
        }else{
        msg=" not added";
        
        }
    }
    
}
