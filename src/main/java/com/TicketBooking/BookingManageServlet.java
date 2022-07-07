package com.TicketBooking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingManageServlet")
public class BookingManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userID = request.getParameter("passenger_UserID");
		
		boolean isTrue; 
		
		isTrue = BookingDBUtil.validate(userID);
		
		if(isTrue == true) {
			
			List<Booking> bookingDetails = BookingDBUtil.getBooking(userID);
			request.setAttribute("bookingDetails", bookingDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("bookingmanage.jsp");
			dis.forward(request, response);
		}
		else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Your UserID is incorrect');");
			out.println("location = 'bookingmanage.jsp'");
			out.println("</script>");
		
		}
	}	

}
