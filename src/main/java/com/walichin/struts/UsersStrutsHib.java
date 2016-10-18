package com.walichin.struts;

import java.io.PrintWriter;
import java.sql.*;  
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.walichin.common.User;
import com.walichin.persistence.HibernateUtil;  
  
public class UsersStrutsHib {  
	ArrayList<User> list=new ArrayList<User>();  
	  
	public ArrayList<User> getList() {  
	    return list;  
	}  
	public void setList(ArrayList<User> list) {  
	    this.list = list;  
	}  
	
	public String execute(){  
	 try{  
	              
		System.out.println("Maven + Struts + Hibernate");
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    
	    Query query = session.createSQLQuery(
			"select * from adm_user_mt")
			.addEntity(User.class);
	    
		java.util.List rs = query.list();
	    		
		int num_filas = rs.size();
		int fila = 0;
		
		while (fila < num_filas) {
			
			User user = (User) rs.get(fila);
			list.add(user);
			fila++;
		}
		
	 }catch(Exception e){e.printStackTrace();}  
	          
	 return "users";  
	}  
}  
