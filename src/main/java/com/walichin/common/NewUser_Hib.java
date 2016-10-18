package com.walichin.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import com.walichin.persistence.HibernateUtil;

/**
 * Servlet implementation class UserServlet
 */
public class NewUser_Hib extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser_Hib() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setUser_Name(request.getParameter("name"));
        user.setUser_Login(request.getParameter("login"));

        session.save(user);
        session.getTransaction().commit();
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("New user created at: ").append(request.getContextPath());
	}

}
