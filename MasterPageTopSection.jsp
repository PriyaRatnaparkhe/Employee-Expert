<%@ taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp'/>
</tm:Guard>
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/Employee-Expert/css/styles.css'></head>
<body>
<!-- Main container starts here-->
<div class='main-container'>
<!-- Header starts here-->
<div class='header'>
<a href='/Employee-Expert/index.html'><img src='/Employee-Expert/images/logo.png' class='logo'></a>
<div class='brand-name'>Thinking Machines</div>
<div class='username'>
<img src='/Employee-Expert/images/user.png'/>
${username}&nbsp;
<a href='/Employee-Expert/logout'>Logout</a>
</div>
</div>
<!-- Header ends here-->
<!--content starts here-->
<div class='content'>
<!--Left panel starts here-->
<div class='content-left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designation</b><br>
</tm:If>

<tm:If condition='${module!=DESIGNATION}'>
<a href='/Employee-Expert/Designations.jsp'>Designation</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employee</b><br>
</tm:If>

<tm:If condition='${module!=EMPLOYEE}'>
<a href='/Employee-Expert/Employees.jsp'>Employee</a><br>
</tm:If>


<tm:If condition='${module!=HOME}'>
<br>
<a href='/Employee-Expert/index.jsp'>Home</a>
</tm:If>

</div>
<!-- Left panel ends here-->
<!-- Right panel starts here-->
<div class='content-right-panel'>