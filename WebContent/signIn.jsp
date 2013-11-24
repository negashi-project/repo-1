<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="LoginController" method="post">
		<table>
			<tr >
				<td>Email
				</td>
				<td >Password
				</td>
				<td >
				</td>
			</tr>
			<tr>
				<td><input type="text" name="userEmail" /></td>
				<td><input type="password" name="userPassword" /></td>
				<td class="submit"><input type="submit" value="Login" /></td>
			</tr>
			<tr>
				<td ><a href="forgetpassword.jsp" style="">Forget you password?</a>
				</td>
				<td colspan="2"><div style="color: red;">${signInErrors}</div></td>
			</tr>			
		</table>
	</form>