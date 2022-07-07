package com.TicketBooking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingInsertServlet")
public class BookingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userID = request.getParameter("passenger_UserID");
		String bookingDate = request.getParameter("booking_Date");
		String startingStation = request.getParameter("starting_Station");
		String endingStation = request.getParameter("ending_Station");
		String trainType = request.getParameter("train_Type");
		String departingTime = request.getParameter("departing_Time");
		String noOfTickets = request.getParameter("no_Of_Tickets");
		
		boolean isTrue; 
		
		isTrue = BookingDBUtil.insertBooking(userID, bookingDate, startingStation, endingStation, trainType, departingTime, noOfTickets);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");  //payment page
			dis.forward(request, response);
		}
		else {
			
			out.println("<script type = 'text/javascript'>");
			out.println("alert('Booking details are invalid');");
			out.println("location = 'bookinginsert.jsp'");
			out.println("</script>");
			
			//RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			//dis2.forward(request, response);
		}
		
	}
		
}


