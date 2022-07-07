package com.TicketBooking;


public class Booking {

	private int bookingID;
	private String userID;
	private String bookingDate;
	private String startingStation;
	private String endingStation;
	private String trainType; 
	private String departingTime;
	private int noOfTickets;
	
	
	public Booking(int bookingID, String userID, String bookingDate, String startingStation, String endingStation, String trainType, String departingTime, int noOfTickets) {
		this.bookingID = bookingID;
		this.userID = userID;
		this.bookingDate = bookingDate;
		this.startingStation = startingStation;
		this.endingStation = endingStation;
		this.trainType = trainType;
		this.departingTime = departingTime;
		this.noOfTickets = noOfTickets;
	}
	
	public int getBookingID() {
		return bookingID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getBookingDate() {
		return bookingDate;
	}

	public String getStartingStation() {
		return startingStation;
	}

	public String getEndingStation() {
		return endingStation;
	}

	public String getTrainType() {
		return trainType;
	}

	public String getDepartingTime() {
		return departingTime;
	}
	
	public int getNoOfTickets() {
		return noOfTickets;
	}
}
