<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SignUpControler" method="post">
		<table>
			<tr>
				<td><label>User Name </label></td>
				<td><input type="text" name="userName" value="${User.name}" /></td>
			</tr>
			<tr>
				<td><label>E-mail </label></td>
				<td><input type="text" name="userEmail" value="${User.email}" /></td>
			</tr>
			<tr>
				<td><label>Re Enter E-mail </label></td>
				<td><input type="text" name="userREmail" /></td>
			</tr>
			<tr>
				<td><label>Password </label></td>
				<td><input  type="password" name="userPassword" value="${User.password}" /></td>
			</tr>
			<tr>
				<td><label>Sex </label></td>
				<td><select name="userSex">
						<option value="m" >Male</option>
						<option value="f" >Female</option>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="left" valign="top" class="submit"><input type="submit"
					value="Sign Up" />
				</td>
			</tr>
			<tr>
				<td align="left" valign="top" colspan="2">
					<div style="color: red;">
					<c:forEach var="_error" items="${signUpErrors}">
						<c:out value="${_error.key}"/>:<c:out value="${_error.value}"/><br>
					</c:forEach>
					
					</div>
				</td>
			</tr>

		</table>
	</form>

</body>
</html>