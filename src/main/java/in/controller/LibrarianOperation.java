package in.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.Service.ILibService;
import in.ServiceFactory.LibServiceFactory;
import in.dto.Librarian;


@WebServlet(urlPatterns = "/lib/*")
public class LibrarianOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Librarian librarian ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println(request.getRequestURI());
         if(request.getRequestURI().endsWith("login")) {
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		System.out.println("Librarian Login");
		ILibService lib = LibServiceFactory.getLibRegServiceImpl();
        boolean status = lib.checkLibrarian(userid, pass);
       request.setAttribute("status", status);
        RequestDispatcher rd = request.getRequestDispatcher("../loginStatus.jsp");
        rd.forward(request, response);
	}
         
	if(request.getRequestURI().endsWith("reg")) {
		System.out.println("Librarian Registration");
		String name = request.getParameter("name");	
	String userid = request.getParameter("userid");
	String pass = request.getParameter("pass");
	Integer age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	 librarian = new Librarian();
	 librarian.setName(name);
	 librarian.setAge(age);
	 librarian.setUserid(userid);
	 librarian.setPassword(pass);
	 librarian.setGender(gender);
	 ILibService libReg = (ILibService) LibServiceFactory.getLibRegServiceImpl();
	 String status = libReg.getRegistered(librarian);
	 request.setAttribute("status", status);
	 RequestDispatcher reqDis = request.getRequestDispatcher("../LibRegStatus.jsp");
	 reqDis.forward(request, response);
	}
}
}