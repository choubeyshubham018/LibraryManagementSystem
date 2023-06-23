package in.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.Service.IBookService;
import in.ServiceFactory.BookServiceFactory;
import in.dto.Book;

@WebServlet(urlPatterns = "/controller/*" , loadOnStartup = 1)
public class BookRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request,response);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doProcess(req, resp);
		
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		IBookService bookService = BookServiceFactory.getBookServiceImpl();
		System.out.println(request.getRequestURI());
		System.out.println("bookRecord");
		if(request.getRequestURI().endsWith("addBook")) {
			String bTitle = request.getParameter("title");
		    String bAuthor = request.getParameter("author");
		      String bCategory = request.getParameter("category");
		      String copy = request.getParameter("copy");
		      try {
		      Book book = new Book();
		      book.setbTitle(bTitle);
		      book.setbAuthor(bAuthor);
		      book.setbCategory(bCategory);
		      book.setCopy(Integer.parseInt(copy));
		      String status = bookService.addBook(book);
		      request.setAttribute("status", status);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("../addBook.jsp");
		      
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		}
		if(request.getRequestURI().endsWith("bookList")) {
			List<Book> bookList = bookService.getBookList();
			try {
				request.setAttribute("bookList", bookList);
			    if(request.getParameter("l1") !=null)
			    	request.setAttribute("l1", "std");
				RequestDispatcher rd = request.getRequestDispatcher("../bookList.jsp");
			
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(request.getRequestURI().endsWith("deleteBook")) {
			try {String bTitle = request.getParameter("title");
			String status = bookService.deleteBook(bTitle);
			    System.out.println(status);
			    System.out.println("after Deleting");
				request.setAttribute("status", status);
			
		        RequestDispatcher rd = request.getRequestDispatcher("../../deleteBook.jsp");
			    rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getRequestURI().endsWith("searchBook")) {
			Book book = new Book();
			List<Book> list=null;
			try {
				book.setbTitle(request.getParameter("title"));
				book.setbCategory(request.getParameter("category"));
				book.setbAuthor(request.getParameter("author"));
				 list = bookService.searchBook(book);
				 String l1 = request.getParameter("l1");
				 
				 if(l1 !=null) {
					 request.setAttribute("l1", "std");
					 System.out.println(l1);
					
				 }
				request.setAttribute("bookList", list);
				 request.getRequestDispatcher("./../searchBookList.jsp").forward(request, response);
					
				System.out.println("sarchBookServlet");
//					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                for (Book book1 : list) {
					System.out.println(book1);
				}

			
				
			}
			
			
		}
		
	}
	

