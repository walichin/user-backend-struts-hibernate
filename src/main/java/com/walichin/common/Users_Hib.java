package com.walichin.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.mapping.List;

import com.walichin.persistence.HibernateUtil;

/**
 * Servlet implementation class UserServlet
 */
public class Users_Hib extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users_Hib() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createSQLQuery(
			"select * from adm_user_mt")
			.addEntity(User.class);
        
		java.util.List rs = query.list();
        		
		PrintWriter out = response.getWriter();
		out.println("<h1>   List of Users  </h1>");

		int num_filas = rs.size();
		int fila = 0;
		
		while (fila < num_filas) {
			
			User user = (User) rs.get(fila);
			
			// Retrieve by column name
			out.println("<h4>" + user.getUser_Name() + " - " + user.getUser_Login() + "</h4>");
			fila++;
		}
		
		out.flush();
		out.close();
		
		// TODO Auto-generated method stub
		response.getWriter().append("List of Users: ").append(request.getContextPath());
	}
}
