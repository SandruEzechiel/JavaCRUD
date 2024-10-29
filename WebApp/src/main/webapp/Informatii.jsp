<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informatii introduse</title>
</head>
<body>
	<h1>Informatii introduse</h1>
	
	<div> Nume: <%= request.getParameter("nume") %></div>
	<div> Prenume: <%= request.getParameter("prenume") %></div>
	<div> Varsta: <%= request.getParameter("varsta") %></div>
	<div> DOB: <%= request.getParameter("dob") %></div>
</body>
</html>
