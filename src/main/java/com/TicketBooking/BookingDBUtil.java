package com.TicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	//insert
	public static boolean insertBooking(String userID, String bookingDate, String startingStation, String endingStation, String trainType, String departingTime, String noOfTickets) {
		
		boolean isSuccess = false;
		int convertedNoOfTickets = Integer.parseInt(noOfTickets);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into ticket_booking values (0, '"+userID+"', '"+bookingDate+"', '"+startingStation+"', '"+endingStation+"', '"+trainType+"', '"+departingTime+"', '"+convertedNoOfTickets+"')";
			int rs = stmt.executeUpdate(sql);
			
			if (rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
				
		} catch (Exception e){
			
			e.printStackTrace();
		}	
		
		return isSuccess;
	}
	
	//validate
	public static boolean validate( String userID ) {
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from ticket_booking where passenger_UserID = '"+userID+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) { 
				
				isSuccess = true;
			}
			else {
				
				isSuccess = false;
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	public static List<Booking> getBooking(String userID) {
		
		ArrayList<Booking> tibook = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from ticket_booking where passenger_UserID = '"+userID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int bookingID = rs.getInt(1);
				String userIDP = rs.getString(2);
				String bookingDateP = rs.getString(3);
				String startingStationP = rs.getString(4);
				String endingStationP = rs.getString(5);
				String trainTypeP = rs.getString(6);
				String departingTimeP = rs.getString(7);
				int noOfTicketsP = rs.getInt(8);
			
				Booking tibk = new Booking(bookingID, userIDP, bookingDateP, startingStationP, endingStationP, trainTypeP, departingTimeP, noOfTicketsP);
				tibook.add(tibk);
			}
			
		 } catch(Exception e) {
			 
			 e.printStackTrace();
		 }
	
		return tibook;
		
	}
	
	//update
	public static boolean updateBooking(String bookingID, String userID, String bookingDate, String startingStation, String endingStation, String trainType, String departingTime, String noOfTickets) {
		
		int convertedNoOfTickets = Integer.parseInt(noOfTickets);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update ticket_booking set booking_Date = '"+bookingDate+"', starting_Station = '"+startingStation+"', ending_Station = '"+endingStation+"', train_Type = '"+trainType+"', departing_Time = '"+departingTime+"', no_Of_Tickets = '"+convertedNoOfTickets+"' where ticket_BookingID = '"+bookingID+"' and passenger_UserID = '"+userID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				
				isSuccess = true;
			}
			else {
				
				isSuccess = false;
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//retrieve
	public static List<Booking> getBookingDetails(String bookingID) { 
		
		ArrayList<Booking> tibook = new ArrayList<>();
		
		int convertedBookingID = Integer.parseInt(bookingID);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from ticket_booking where ticket_BookingID = '"+convertedBookingID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int bookingIDP = rs.getInt(1);
				String userIDP = rs.getString(2);
				String bookingDateP = rs.getString(3);
				String startingStationP = rs.getString(4);
				String endingStationP = rs.getString(5);
				String trainTypeP = rs.getString(6);
				String departingTimeP = rs.getString(7);
				int noOfTicketsP = rs.getInt(8);
				
				Booking tibk = new Booking(bookingIDP, userIDP, bookingDateP, startingStationP, endingStationP, trainTypeP, departingTimeP, noOfTicketsP);
				tibook.add(tibk);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return tibook;
	}
	
	//delete
	public static boolean deleteBooking(String bookingID) {
		
		int convertedBookingID = Integer.parseInt(bookingID);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from ticket_booking where ticket_BookingID = '"+convertedBookingID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				
				isSuccess = true;
			}
			else {
				
				isSuccess = false;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}
