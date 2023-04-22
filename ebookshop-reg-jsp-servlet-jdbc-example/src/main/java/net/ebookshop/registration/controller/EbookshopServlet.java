package net.ebookshop.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ebookshop.registration.dao.EbookshopDao;
import net.ebookshop.registration.model.Ebookshop;

/**
 * Servlet implementation class EbookshopServlet
 */
@WebServlet("/register")
public class EbookshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EbookshopDao ebookshopDao=new EbookshopDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EbookshopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/ebookshopregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book_title=request.getParameter("book_title");
		String book_author=request.getParameter("book_author");
		String book_price=request.getParameter("book_price");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		Ebookshop ebookshop=new Ebookshop();
		ebookshop.setBook_title(book_title);
		ebookshop.setBook_author(book_author);
		ebookshop.setBook_price(book_price);
		ebookshop.setQuantity(quantity);
		
		try {
			ebookshopDao.registerEbookshop(ebookshop);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/ebookshopdetails.jsp");
		dispatcher.forward(request, response);
	}

}
