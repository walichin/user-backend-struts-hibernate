package com.walichin.struts;

import java.util.Date;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.walichin.common.User;
import com.walichin.persistence.HibernateUtil;
 
@SuppressWarnings("serial")
public class TestAction extends ActionSupport 
{
    private String name;
    private String login;
    private Date nowDate;
 
    @Override
    public void validate(){
        if (name==null || name.length()==0)
            addActionError(getText("name-msg-validation"));
        if (login==null || login.length()==0)
            addActionError(getText("login-msg-validation"));
    }
 
    @Override
    public String execute() throws Exception {
        nowDate = new Date();
        
        
		System.out.println("Maven + Struts + Hibernate");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setUser_Name(this.name);
        user.setUser_Login(this.login);

        session.save(user);
        session.getTransaction().commit();        
        
        
        return ActionSupport.SUCCESS;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public Date getNowDate() {
        return nowDate;
    }
}
