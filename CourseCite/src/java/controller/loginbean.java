/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.faces.context.FacesContextImpl;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;
import modle.DB;

/**
 *
 * @author ahmed
 */

@ManagedBean
public class loginbean {
    
    private String name;
    private String pass;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public  String login(){
    
        DB db=new DB();
        boolean f = db.usersearch(name, pass);
        if(f==true){
            HttpSession ses=(HttpSession) FacesContextImpl.getCurrentInstance().getExternalContext().getSession(true);
            ses.setAttribute("name", name);
            
        return "coursesopertion?faces-redirect=true";
        }else{
        msg="Username or passward not correct";
        return  null;
        }
        
    }
    
}
