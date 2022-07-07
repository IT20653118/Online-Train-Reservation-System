<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking Update</title>

	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">

</head>
<body class = "bookingupdate">

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
	
	<%
		String bookingID = request.getParameter("ticket_bookingID");
		String userID = request.getParameter("passenger_UserID");
		String bookingDate = request.getParameter("booking_Date");
		String startingStation = request.getParameter("starting_Station");
		String endingStation = request.getParameter("ending_Station");
		String trainType = request.getParameter("train_Type");
		String departingTime = request.getParameter("departing_Time");
		String noOfTickets = request.getParameter("no_Of_Tickets");
	%>
	
	<div class = "booking-form-box">

		<form action = "update" method = "POST">
			<h2>Update your bookings</h2><br>
		
			<div class="booking-form">
			
				<label>Ticket booking ID</label>
				<input type = "text" class="form-control" name = "ticket_bookingID" value = "<%= bookingID %>" readonly>
	
				<label>User ID</label>
				<input type = "text" class="form-control" name = "passenger_UserID" value = "<%= userID %>" readonly> <br>
		
				<label>Booking Date</label>
				<input type = "date" class="form-control select-date" name = "booking_Date" value = "<%= bookingDate %>" required> <br>
	
				<div class = "input-grp">
					<label>Starting Station</label>
					<input type = "text" class="form-control" name = "starting_Station" value = "<%= startingStation %>" required>
				</div>
				<div class = "input-grp">
					<label>Ending Station</label>
					<input type = "text" class="form-control" name = "ending_Station" value = "<%= endingStation %>" required>
				</div><br><br>
			
				<label>Train Type</label>
				<input type = "text" class="form-control" name = "train_Type" value = "<%= trainType %>" required><br>
	
				<div class = "input-grp">
					<label>Required Departing time</label>
					<input type = "time" class="form-control" name = "departing_Time" value = "<%= departingTime %>" required>
				</div>
				<div class = "input-grp">
					<label>No of tickets</label><input type = "number" class="form-control" name = "no_Of_Tickets" value = "<%= noOfTickets %>" required>
				</div><br><br><br>
	
				<input type = "submit" class ="form-update" name = "submit" value = "Update">
	
		
			</div>
		</form>	
	</div>
</body>
</html>