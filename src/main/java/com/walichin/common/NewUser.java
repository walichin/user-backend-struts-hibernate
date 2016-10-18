package com.walichin.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewUser extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

Connection conn = null;
Statement stmt = null;

String name = request.getParameter("name");
String login = request.getParameter("login");

try {
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/archivoi_photo", "archivoi_photo", "c0lm1ll0");
System.out.println("success");

// STEP 4: Execute a query
System.out.println("Creating statement...");
stmt = conn.createStatement();

String sql;
//sql = "SELECT user_id, name, login FROM adm_user_mt";
sql = "INSERT INTO adm_user_mt (name, login) VALUES ('" + name + "','" + login + "') ";

//ResultSet rs = stmt.executeQuery(sql);
stmt.executeUpdate(sql);

PrintWriter out = response.getWriter();
out.println("<h1>   New User  </h1>");

if (name != null && !"".equals(name)) {
out.println("<h2> name: "+ name +"</h2>");
}

out.flush();
out.close();

// STEP 6: Clean-up environment
stmt.close();
conn.close();

} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
System.out.println("error:" + e);
}

}
}