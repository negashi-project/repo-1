<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
 <title>The main page</title>
 <meta charset="utf-8">
 <link rel="stylesheet" type="text/css" href="styles/style.css" >
 <link rel="stylesheet" type="text/css" href="styles/header.css" >
 <meta name="viewport" content="width=device-width,initial-scale=1.0">
 </head>
 <body class="body">
 <%@include file="header.jsp" %>
 <!--  header comes here -->
 <div class="maincontent">
	<div class="content">
		<article class="signin_box">
			<content>
				<%@include file="signIn.jsp" %>
			</content>
		</article>
		<article class="signup_box">
			<header><h4>Sign Up</h4></header>
			<content>
				<%@include file="newUser.jsp" %>
			</content>
		</article>
		
		
	</div>
	
	<!-- side info will come here -->
	<%@include file="side_info.jsp" %>
		</div>
		<!-- footer will comes here -->
		<%@include file="footer.jsp" %>
	
 </body>
 </html>