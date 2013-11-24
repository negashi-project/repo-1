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
			<a href="#">First Article</a>
			</header>
			<content>
				<p>	
making it look like readable English. Many desktop 
publishing packages and web page editors now use Lorem Ipsum as 
their default model text, and a search for 'lorem ipsum' will uncover 
				</p>
			</content>
			<footer class="post-info">
			<p>Posted Date</p>
			</footer>
		</article>
		<article class="freecontents">
			<header>
			<a href="#">second Article</a>
			</header>
			<content>
				<p>	
It is a long established fact that a reader will be distracted by 
the readable content of a page when looking at its layout. 
The point of using Lorem Ipsum is that it has a more-or-less 
				</p>
				<p>	
It is a long established fact that a reader will be distracted by 
the readable content of a page when looking at its layout. 
The point of using Lorem Ipsum is that it has a more-or-less 
				</p>
			</content>
			<footer class="post-info">
			<p>Posted Date</p>
			</footer>
		</article>
		
		<article class="freecontents"><!-- use regular expression -->
			<header>
			<a href="#">Third Article</a>
			</header>
			<content>
			<p>
				but also the leap into electronic typesetting, remaining essentially
				unchanged. It was popularised in the 1960s with the release of 
				Aldus PageMaker including versions of Lorem Ipsum
				</p>
				<p>
				but also the leap into electronic typesetting, remaining essentially
				unchanged. It was popularised in the 1960s with the release of 
				Aldus PageMaker including versions of Lorem Ipsum
				</p>
			</content>
			<footer>
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