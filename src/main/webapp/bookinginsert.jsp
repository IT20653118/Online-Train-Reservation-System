<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking</title>

	<link rel="stylesheet" href="styles.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css">
		
</head>
<body>
	
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
        		<a class="nav-link" href="#">Booking</a>
      		</li>
      		<li class="nav-item">
        		<a class="nav-link" href="#">Payment</a>
      		</li>    
    	</ul>
  	</div>
</nav>

	<div class = "booking-form-box">
		<form action = "insert" method = "POST">
			<h2>Ticket Booking</h2><br>
		
			<div class="booking-form">
			
	 			<label>User ID</label>
	 			<input type = "text" class="form-control" placeholder = "UIDXXX" name = "passenger_UserID" required> <br>
		
				<label>Booking Date</label>
				<input type = "date" class="form-control select-date" name = "booking_Date" required> <br><br>
		
				<div class = "input-grp">
					<label>Starting Station</label>
					<input type = "text" class="form-control" name = "starting_Station" placeholder = "Colombo" required>
				</div>
				<div class = "input-grp">
					<label>Ending Station</label>
					<input type = "text" class="form-control"  name = "ending_Station" placeholder = "Kandy" required>
				</div>	<br><br>
			
				<label>Train Type</label> &nbsp &nbsp
					<select class="custom-select" name ="train_Type" required>
						<option value = "Normal">Normal</option>
						<option value = "Semi Express">Semi Express</option>
						<option value = "Express">Express</option>
						<option value = "Intercity">Intercity</option>
					</select><br><br><br><br>
  		
  				<div class = "input-grp">
  					<label>Required Departing time</label>
  					<input type = "time" class="form-control" name = "departing_Time" required>
  				</div>
			
				<div class = "input-grp">
					<label>No of tickets</label>
					<input type = "number" class="form-control" name = "no_Of_Tickets" placeholder = "0" required></div><br><br><br>
		
				<input type = "submit" class ="form-submit" name = "submit" value = "Book now"> &nbsp &nbsp
			
				<a href = "bookingmanage.jsp">
					<button type = "button" name = "manage">Manage my bookings</button>
				</a>
				
			</div>
		</form>
	</div>
</body>
</html>