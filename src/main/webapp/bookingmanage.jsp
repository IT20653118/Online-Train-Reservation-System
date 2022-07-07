<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View and Manage bookings</title>

	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
	
</head>
<body class = "bookingmanage">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"></a>
  
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  	<div class="collapse navbar-collapse" id="navbarNav">
    	<ul class="navbar-nav">
      		<li class="nav-item active">
        		<a class="nav-link" href="homepage.jsp">Home</a>
     		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">About</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">Login</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">SignUp</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="bookinginsert.jsp">Booking</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">Payment</a>
      		</li>    
    	</ul>
  	</div>
</nav>
	
	<div class = "booking-manage-box">
		<form action = "viewbooking" method = "POST">
			<h2>Your Bookings</h2>
	 
	 		<div class="booking-manage">
	 		
	 			<label>User ID</label>
	 			<input type = "text" class="form-control" placeholder = "UIDXXX" name = "passenger_UserID" required> <br><br>
	 
	 			<input type = "submit" class ="form-submit" name = "submit" value = "View Bookings">
	 			
	 		</div>
	 	</form>	<br>	

	<table>
		
		<c:forEach var = "tibook" items = "${bookingDetails}" >
	
		<c:set var = "bookingID" value = "${tibook.bookingID}"/>
		<c:set var = "userID" value = "${tibook.userID}"/>
		<c:set var = "bookingDate" value = "${tibook.bookingDate}"/>
		<c:set var = "startingStation" value = "${tibook.startingStation}"/>
		<c:set var = "endingStation" value = "${tibook.endingStation}"/>
		<c:set var = "trainType" value = "${tibook.trainType}"/>
		<c:set var = "departingTime" value = "${tibook.departingTime}"/>
		<c:set var = "noOfTickets" value = "${tibook.noOfTickets}"/>
		
		<tr>
			<td>Ticket booking ID</td>
			<td>${tibook.bookingID}</td>
		</tr>
		<tr>
			<td>User ID</td>
			<td>${tibook.userID}</td>
		</tr>
		<tr>
			<td>Booking Date</td>
			<td>${tibook.bookingDate}</td>
		</tr>
		<tr>
			<td>Starting Station</td>
			<td>${tibook.startingStation}</td>
		</tr>
		<tr>
			<td>Ending Station</td>
			<td>${tibook.endingStation}</td>
		</tr>
		<tr>
			<td>Train Type</td>	
			<td>${tibook.trainType}</td>
		</tr>
		<tr>
			<td>Departing Time</td>
			<td>${tibook.departingTime}</td>
		</tr>
		<tr>
			<td>Number of Tickets</td>
			<td>${tibook.noOfTickets}</td>
		</tr>
		
		</c:forEach>
	
	</table>
	
		<div class="booking-manage">
	
			<c:url value = "bookingupdate.jsp" var = "bookingupdate">
				<c:param name = "ticket_bookingID" value = "${bookingID}"/>
				<c:param name = "passenger_UserID" value = "${userID}"/>
				<c:param name = "booking_Date" value = "${bookingDate}"/>
				<c:param name = "starting_Station" value = "${startingStation}"/>
				<c:param name = "ending_Station" value = "${endingStation}"/>
				<c:param name = "train_Type" value = "${trainType}"/>
				<c:param name = "departing_Time" value = "${departingTime}"/>
				<c:param name = "no_Of_Tickets" value = "${noOfTickets}"/>	
			</c:url>
	
			<br><br>

			<a href = "${bookingupdate}">
				<input type = "button" class = "updatebookings" name = "update" value = "Update my bookings">
			</a>	&nbsp &nbsp
	
	
			<c:url value = "bookingdelete.jsp" var = "bookingdelete">
				<c:param name = "ticket_bookingID" value = "${bookingID}"/>
				<c:param name = "passenger_UserID" value = "${userID}"/>
				<c:param name = "booking_Date" value = "${bookingDate}"/>
				<c:param name = "starting_Station" value = "${startingStation}"/>
				<c:param name = "ending_Station" value = "${endingStation}"/>
				<c:param name = "train_Type" value = "${trainType}"/>
				<c:param name = "departing_Time" value = "${departingTime}"/>
				<c:param name = "no_Of_Tickets" value = "${noOfTickets}"/>
			</c:url>
	
			<a href = "${bookingdelete}">
				<input type = "button" class = "deletebookings" name = "delete" value = "Delete my bookings">
			</a>
	
		</div>
	</div>

</body>
</html>