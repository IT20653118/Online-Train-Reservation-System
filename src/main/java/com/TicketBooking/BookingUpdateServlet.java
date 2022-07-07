package com.TicketBooking;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingUpdateServlet")
public class BookingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String bookingID = request.getParameter("ticket_bookingID");
		String userID = request.getParameter("passenger_UserID");
		String bookingDate = request.getParameter("booking_Date");
		String startingStation = request.getParameter("starting_Station");
		String endingStation = request.getParameter("ending_Station");
		String trainType = request.getParameter("train_Type");
		String departingTime = request.getParameter("departing_Time");
		String noOfTickets = request.getParameter("no_Of_Tickets");
		
		boolean isTrue; 
		
		isTrue = BookingDBUtil.updateBooking(bookingID, userID, bookingDate, startingStation, endingStation, trainType, departingTime, noOfTickets);
		
		if(isTrue == true) {
			
			List<Booking> bookingDetails = BookingDBUtil.getBookingDetails(bookingID);
			request.setAttribute("bookingDetails", bookingDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("bookingmanage.jsp"); //succcess.jsp
			dis.forward(request, response);
		}
		else {
			
			List<Booking> bookingDetails = BookingDBUtil.getBookingDetails(bookingID);
			request.setAttribute("bookingDetails", bookingDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("bookingmanage.jsp"); //unsuccess.jsp
			dis2.forward(request, response);
		}
			
	}

}
