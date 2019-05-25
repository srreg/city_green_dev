<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.Format"%>
<%@page import="com.citygreen.crud.PlantingBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="volunteermsg.css"/>
<title>City Green</title>
<link rel="shortcut icon" type="image/gif/png" href="logot.png"/>
</head>
<body>
	<header >
		<h2 class="message">Volunteer Message</h2>
		<a class="logout" href="AdminLogin.html">Log Out</a>
	</header>	
	<div class="content">
		<div class="contenttitle">
		</div>
		<%
		HttpSession sess = request.getSession();
		List<PlantingBean> planting_details = (List<PlantingBean>)sess.getAttribute("volunteer_older_message");
		for(PlantingBean volunteer_msg : planting_details){%>
		<div class="contentbody">
			<div class="leftmsg">
				<h4 class="key">Name </h4>
				<h4 class="value">:	<%= volunteer_msg.GetName() %></h4>
				<h4 class="key">Phone Number </h4>
				<h4 class="value">:	<%= volunteer_msg.GetContact() %></h4>
				<h4 class="key">Plants Required	</h4>
				<h4 class="value">:	<%= volunteer_msg.GetPlants() %></h4>
				<h4 class="key">Participants </h4>
				<h4 class="value">:	<%= volunteer_msg.GetParticipants() %></h4>
				<h4 class="key">Planting Date </h4>
				<h4 class="value">:	<%= volunteer_msg.GetDate_Time() %></h4>
			</div>
			<div class="rightmsg">
				<div class="rightbox">
					<h4 class="rkey">Area - Details </h4>
					<h4 class="rvalue"><%= volunteer_msg.GetArea_details() %></h4>
				</div>
				<div class="notes">
					<h4 class="rkey">Notes </h4>
					<h4 class="rvalue"><%= volunteer_msg.GetNotes() %></h4>
				</div>
			</div>
		</div> <% } %>
	</div>
</body>
</html>