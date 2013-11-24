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
 <div>
	<div class="form">
		<form>
			<label for="" > &nbsp</label><h2 class="title">Write for us</h2>
			 <p class="name"><label for="nameid" >Name</label><input type="text" placeholder="your name" id="nameid" name="name"></p>
			 <p class="email"><label for="emailid" >Email</label><input type="text" placeholder="your email" id="emailid" name="email"></p>
			 <p class="web"><label for="webid" >Website</label><input type="text" placeholder="your website" id="webid" name="web"></p>
			 <p class="text"><label for="" > &nbsp</label><textarea name="text" placeholder="write for us"></textarea></p>
			 <p class="text"><label for="" > &nbsp</label><p class="submit">
			 <input type="submit" value="submit">
			 </p>
		 </form>
	</div>
 	<div class="contact">
	<aside >
		<h3>Visiting Address</h3>
		<p>
			Gatan: Some fisiting address<br>
			Tele: 2343434354354<br>
			Email: nejashi@negashi.se<br>
		</p>
		<p>
			<h4>Visit us</h4>
			
			<ul><li><a href="https://www.facebook.com/pages/Nejashi/132464906920580?fref=ts" title="Facebook"><img src="images/fb.jpg"></a></li>
				<li><a href="http://www.youtube.com/user/firsthijrah2010" title="Youtube"><img src="images/utb.jpg"></a></li>
				<li><a href="mailto:negashiethmuslims@gmail.com" title="E-Mail"><img src="images/email.jpg"></a></li>
			</ul>
		</p>
	</aside>
	</div>
	</div>
	<!-- side info will come here -->
	<!--  %@include file="side_info.jsp" %> 
		</div> -->
		<!-- footer will comes here -->
		<%@include file="footer.jsp" %>
	
 </body>
 </html>