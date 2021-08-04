<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/Employee-Expert/css/styles.css'>
</head>
<body>
<!-- Main container starts here-->
<div class='main-container'>
<!-- Header starts here-->
<div class='header'>
<a href='/Employee-Expert/index.html'><img src='/Employee-Expert/images/logo.png' class='logo'></a>
<div class='brand-name'>Thinking Machines</div>
</div>
<!-- Header ends here-->
<!--content starts here-->
<div class='content'>
<div class='loginForm'>
<form action='/Employee-Expert/Login.jsp' method='post'>
<table border='0'>
<tr>
<td colspan='2' align='center'>
<span class='error'>
${errorBean.error}
</span>
</td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' name='username' id='username' maxlength='15'></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' name='password' id='password' maxlength='15'></td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Login</button>
</td>
</tr>
</table>
</form>
</div>
</div><!-- Content panel ends here-->
<!-- Footer starts here-->
<div class='footer'>
&copy; Thinking Machines 2020
</div>
<!--Footer ends here-->
</div>
<!--Main container ends here-->
</body>
</html>

