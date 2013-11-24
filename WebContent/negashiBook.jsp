<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html"
	import="se.negashi.model.UserPostsComments" import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>The main page</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/header.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body class="body">
	<%@include file="header.jsp"%>
	<!--  header comes here -->
	<div class="maincontent">
		<div class="content">
			<article class="freecontents"> 
			<%@include file="mypost.jsp"%>
			</article>
		</div>

		<!-- side info will come here -->
		<%@include file="side_info.jsp"%>
	</div>
</body>
</html>