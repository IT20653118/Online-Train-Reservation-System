package com.TicketBooking;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingDeleteServlet")
public class BookingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookingID = request.getParameter("ticket_bookingID");
		
		boolean isTrue; 
		
		isTrue = BookingDBUtil.deleteBooking(bookingID);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("bookinginsert.jsp");
			dis.forward(request, response);
		}
		else {
			
			List<Booking> bookingDetails = BookingDBUtil.getBookingDetails(bookingID);
			request.setAttribute("bookingDetails", bookingDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("bookingmanage.jsp");
			dis2.forward(request, response);
		}
	}

}
