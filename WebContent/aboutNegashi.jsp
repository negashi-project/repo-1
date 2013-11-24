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
		<article class="freecontents">
			<header>
			First Article
			</header>
			<content>
				<p>	
making it look like readable English. Many desktop 
publishing packages and web page editors now use Lorem Ipsum as 
their default model text, and a search for 'lorem ipsum' will uncover 
				</p>
				<p>	
making it look like readable English. Many desktop 
publishing packages and web page editors now use Lorem Ipsum as 
their default model text, and a search for 'lorem ipsum' will uncover 
				</p>
				<p>	
making it look like readable English. Many desktop 
publishing packages and web page editors now use Lorem Ipsum as 
their default model text,<a href="negashiPosts.jsp">Deen teachings</a> and a search for 'lorem ipsum' will uncover 
				</p>
			</content>
			<footer class="post-info">
			<p>Posted Date</p>
			</footer>
		</article>
		
	</div>
	
	<!-- side info will come here -->
	<%@include file="side_info.jsp" %>
		</div>
		<!-- footer will comes here -->
		<%@include file="footer.jsp" %>
	
 </body>
 </html>