package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.Service.IStdService;
import in.ServiceFactory.StdServiceFactory;
import in.dto.Student;

@WebServlet(urlPatterns = "/controller/std/*" ,loadOnStartup = 1)
public class StudentOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStdService iStd = StdServiceFactory.getStdRegServiceImpl();
		
		System.out.println(request.getRequestURI());
		System.out.println("Student Registration");
		if(request.getRequestURI().endsWith("stdregister")) {
			
			String sname = request.getParameter("sname");
			String sid = request.getParameter("sid");
			String sage = request.getParameter("sage");
			String sgen = request.getParameter("sgen");
			String smob = request.getParameter("smob");
			String semail = request.getParameter("semail");
			String spass = request.getParameter("spass");
			
			Student student = new Student();
			student.setEmail(semail);
			student.setStdId(sid);
			student.setMob(smob);
			student.setStdAge(Integer.parseInt(sage));
			student.setStdgen(sgen);
			student.setStdName(sname);
			student.setPassword(spass);
			System.out.println(student);
			
			String status = iStd.registerStd(student);
			System.out.println(status);
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("./../../stdreg.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("stdlist")) {
			
			List<Student> student = iStd.getStudentList();
			request.setAttribute("students", student);
			System.out.println("helloo");
			RequestDispatcher rd = request.getRequestDispatcher("./../../stdlist.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("delete")) {
			
			String stdId = request.getParameter("stdId");
			String status = iStd.removeStd(Integer.parseInt(stdId));
			request.setAttribute("status", status);
			System.out.println("helloo");
			RequestDispatcher rd = request.getRequestDispatcher("./../../../../removeStd.jsp");
			rd.forward(request, response);
			
		}
		if(request.getRequestURI().endsWith("login")) {
			String stdid = request.getParameter("stdid");
			String stdpass = request.getParameter("stdpass");
			String stdLoginStatus = iStd.stdLogin(stdid, stdpass);
			if(stdLoginStatus!=null) {
				System.out.println(stdid);
				HttpSession session = request.getSession();
				session.setAttribute("stdid", stdid);
			}
			request.setAttribute("status", stdLoginStatus);
			RequestDispatcher rd = request.getRequestDispatcher("../../stdLoginStatus.jsp");
			rd.forward(request, response);
		}
		
		
	}
}
