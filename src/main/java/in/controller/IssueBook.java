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

import in.Service.IIssueBookAndStatusService;
import in.ServiceFactory.IssueBookServiceFactory;
import in.dto.Book;
import in.dto.IssuedBooks;

@WebServlet(urlPatterns = "/issue/*")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	IIssueBookAndStatusService ibookStatus;
   
	@Override
	public void init() throws ServletException {
	ibookStatus=IssueBookServiceFactory.getIssueBookService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Issue");
		System.out.println(request.getRequestURI());
	RequestDispatcher rd=null;
// Collection the List of All the Issued Books	
	if(request.getRequestURI().endsWith("ibooklist")) {
		System.out.println(request.getRequestURI().endsWith("ibooklist"));
		List<IssuedBooks> bookList = ibookStatus.getIssuedBookList();
		request.setAttribute("issueBooks", bookList);
		rd=request.getRequestDispatcher("../issuedBookList.jsp");
		rd.forward(request, response);
	}
	
	if(request.getRequestURI().endsWith("issuebook")) {
	   
		String status="";
		String stdid = request.getParameter("stdid");
		List<IssuedBooks> stdBooks = ibookStatus.getIssuedStdBooks(stdid);
		System.out.println(stdBooks.size());
	  if(stdBooks.size()<3) {
		String bTitle = request.getParameter("bTitle");
	   String bAuthor = request.getParameter("bAuthor");
	   String bCategory = request.getParameter("bCategory");
	  Book book = new Book();
	  book.setbAuthor(bAuthor);
	  book.setbCategory(bCategory);
	  book.setbTitle(bTitle);
	  System.out.println(bTitle);
	   status = ibookStatus.issueBook(book, stdid);
	   System.out.println(status);
	   if(status.equals("id not found")) {
		   request.setAttribute("error","Invalid Id");
		   request.setAttribute("title", bTitle);
		   request.setAttribute("author", bAuthor);
		   request.setAttribute("category", bCategory);
		   request.setAttribute("link", "s1");
		   rd=request.getRequestDispatcher("../issuebook.jsp");
		   rd.forward(request, response);
		   
	   }
	  
	  }
	  else 
		  status="max limit reached";
	  request.setAttribute("status", status);
	  rd=request.getRequestDispatcher("../issueStatus.jsp");
	  rd.forward(request, response);
	  
	}
	
//	Collection information of Issued Books For a Given Student
	if(request.getRequestURI().endsWith("books")) {
		String stdId = request.getParameter("stdId");
		String l1 = request.getParameter("l1");
		if(l1!=null) {
			HttpSession session = request.getSession();
			stdId=(String) session.getAttribute("stdid");
			System.out.println(stdId);
		}
		System.out.println(stdId);
		List<IssuedBooks> stdBooks = ibookStatus.getIssuedStdBooks(stdId);
        System.out.println(stdBooks.size());
		request.setAttribute("issueBooks", stdBooks);
		request.setAttribute("stdid", stdId);
		if(l1 !=null) {
			request.setAttribute("l1", "std");
			System.out.println(l1);
		}
		rd=request.getRequestDispatcher("../issuedBookList.jsp");
		rd.forward(request, response);
	}
	
//	Submiting the Book
	if(request.getRequestURI().endsWith("submit")) {
		String stdid = request.getParameter("stdid");
		   String bTitle = request.getParameter("bTitle");
		   String bAuthor = request.getParameter("bAuthor");
		   String bCategory = request.getParameter("bCategory");
		   Book book = new Book();
			  book.setbAuthor(bAuthor);
			  book.setbCategory(bCategory);
			  book.setbTitle(bTitle);		
		 Float fine = ibookStatus.returnIssuedBook(book,stdid);
		 request.setAttribute("stdid", stdid);
		 request.setAttribute("book", book);
		 request.setAttribute("fine", fine);
		 rd=request.getRequestDispatcher("../fine.jsp");
			rd.forward(request, response);
		 
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
