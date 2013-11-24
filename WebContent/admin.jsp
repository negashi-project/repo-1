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
	<script type="text/javascript"
		src="tinymce/tinymce/js/tinymce/tinymce.min.js"></script>
	<script type="text/javascript">
		tinymce
				.init({
					selector : "textarea#elm1",
					theme : "modern",
					width : 610,
					height : 300,
					plugins : [
							"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
							"searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
							"save table contextmenu directionality emoticons template paste textcolor" ],
					content_css : "css/content.css",
					toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      ink image | print preview media fullpage | forecolor backcolor emoticons",
					style_formats : [ {
						title : 'Bold text',
						inline : 'b'
					}, {
						title : 'Red text',
						inline : 'span',
						styles : {
							color : '#ff0000'
						}
					}, {
						title : 'Red header',
						block : 'h1',
						styles : {
							color : '#ff0000'
						}
					}, {
						title : 'Example 1',
						inline : 'span',
						classes : 'example1'
					}, {
						title : 'Example 2',
						inline : 'span',
						classes : 'example2'
					}, {
						title : 'Table styles'
					}, {
						title : 'Table row 1',
						selector : 'tr',
						classes : 'tablerow1'
					} ]
				});
	</script>
	<%@include file="header.jsp"%>
	<!--  header comes here -->
	<div class="maincontent">
		<div class="content">
			<article class="freecontents">

			<div class="functions">
				<div class="raw">
					<div class="titles">Upload News</div>
				</div>
				<div class="raw">
					<form>
						<p>
							<textarea cols="80" id="elm1" name="news" rows="10"></textarea>
						</p>
						<input class="submit" type="submit" value="Upload">
					</form>
				</div>

			</div>
			<div class="functions">
				<div class="raw">
					<div class="titles">Update the page</div>
				</div>
				<div class="raw">
					<form>
						<p>
							Select page to update<select>
							<option>Select page</option>
							<option>About Negashi</option>
							<option>Advertisement 1</option>
							<option>Advertisement 2</option>
							<option>Activities</option>
							<option>About us</option>
							</select><br><br>
							<textarea cols="80" id="elm1" name="news" rows="10"></textarea>
						</p>
						<input class="submit" type="submit" value="Upload">
					</form>
				</div>

			</div>

			<div class="functions">
				<form>
					<div class="raw">
						<div class="titles">Upload Picture</div>
					</div>
					<div class="raw">
						<div class="labels">Picture:</div>
						<div class="values">
							<input type="file" name="uname" placeholder="upload a picture">
						</div>
						<div class="msg">context</div>
					</div>
					<div class="raw">
						<input class="submit" type="submit" value="Approve">
					</div>
				</form>
			</div>
			<div class="functions">
				<form>
					<div class="raw">
						<div class="titles">Create user</div>
					</div>
					<div class="raw">
						<div class="labels">User E-mail:</div>
						<div class="values">
							<input type="text" name="email" placeholder="Email address">
						</div>
						<div class="msg">context</div>
					</div>
					<div class="raw">
						<div class="labels">User Name:</div>
						<div class="values">
							<input type="text" name="uname" placeholder="User name">
						</div>
						<div class="msg">context</div>
					</div>
					<div class="raw">
						<div class="labels">Password:</div>
						<div class="values">
							<input type="password" name="pword">
						</div>
						<div class="msg">context</div>
					</div>
					<div class="raw">
						<div class="labels">Confirm password:</div>
						<div class="values">
							<input type="password" name="rpword">
						</div>
						<div class="msg">context</div>
					</div>
					<div class="raw">
						<div class="labels">Role:</div>
						<div>
							<select>
								<option value="admin">Admin</option>
								<option value="user">User</option>
							</select>
						</div>
					</div>
					<div class="raw">
						<input class="submit" type="submit" value="Create">
					</div>
				</form>
			</div>
			<div class="functions">
				<form>
					<div class="raw">
						<div class="titles">Manage users</div>
					</div>
					<div class="raw">
						<div class="raw">

							<div class="divTable">
								<div class="headRow">
									<div class="divCell">User Name</div>
									<div class="divCell">E-mail</div>
									<div class="divCell">Customer Address</div>
								</div>
								<div class="divRow">
									<div class="divCell">username1</div>
									<div class="divCell">username@gmail.com</div>
									<div class="divCell">
										<input type="checkbox" value=""></input>
									</div>
								</div>

							</div>

						</div>
						<div class="raw">
							<input class="approve" type="submit" value="Remove"><input
								class="reject" type="submit" value="Edit"><input
								class="reject" type="submit" value="Update">
						</div>
				</form>
			</div>


			</article>
		</div>

		<!-- side info will come here -->
		<%@include file="side_info.jsp"%>
	</div>
	<!-- CK Editer -->
</body>
</html>