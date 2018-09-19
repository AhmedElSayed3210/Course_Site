/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.faces.context.FacesContextImpl;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
@ManagedBean
public class logoutbean {
    private boolean check=true;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    

    
    public String logout(){
    
        HttpSession ses = (HttpSession) FacesContextImpl.getCurrentInstance().getExternalContext().getSession(false);
        ses.invalidate();
        check=false;
        return "index?faces-redirect=true";
    
    }
    
}
