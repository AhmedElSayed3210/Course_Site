/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modle.DB;
import modle.course;

/**
 *
 * @author ahmed
 */
@ManagedBean
@SessionScoped
public class couoperationbean {
    
    List<course> courses;
    private int cid;
    DB d=new DB();
    
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public couoperationbean() {
       
         courses= d.selectallcourses();
    }
    
    
    public List<course> getCourses(){
    
        
         return courses;
    }
    public  void edit(course cour){
    
        
    for(course c:courses){
    
    if(c.getId()==cour.getId()){
    cid=c.getId();
    c.setIsedit(true);
    return;
    }
    }
    
    }
    
    public void save(){
    
    for(course c:courses){
    
    if(c.getId()==cid){
        int f = d.editecourse(c);
        if(f==0){
        msg="not edit";
        }
        else{
          msg=  "edit successfully";
          c.setIsedit(false);
        }
    return;
    }
    }
    
    }
    
    public  void delete(course c){
    
        int f = d.deletecourse(c.getId());
        
        if(f==0){
        msg="not Delete";
        }
        else{
          msg=  "delete successfully";
          courses.remove(c);
         
        }
    
    }
    public void refresh(){
    courses= d.selectallcourses();
        
    }
    
}
