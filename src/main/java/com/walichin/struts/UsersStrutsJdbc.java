package com.walichin.struts;

import java.sql.*;  
import java.util.ArrayList;

import com.walichin.common.User;  
  
public class UsersStrutsJdbc {  
	ArrayList<User> list=new ArrayList<User>();  
	  
	public ArrayList<User> getList() {  
	    return list;  
	}  
	public void setList(ArrayList<User> list) {  
	    this.list = list;  
	}  
	
	public String execute(){  
	 try{  
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/archivoi_photo", "archivoi_photo", "c0lm1ll0");  
	              
	  PreparedStatement ps=con.prepareStatement("select name, login from adm_user_mt");  
	  ResultSet rs=ps.executeQuery();  
	  
	  while(rs.next()){  
	   User user=new User();  
	   user.setUser_Name(rs.getString(1));  
	   user.setUser_Login(rs.getString(2));  
	   list.add(user);  
	  }  
	  
	  con.close();  
	 }catch(Exception e){e.printStackTrace();}  
	          
	 return "users";  
	}  
}  
