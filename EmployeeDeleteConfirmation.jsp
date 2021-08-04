<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/Employee-Expert/js/EmployeeDeleteConfirmation.js'></script>
<h2> Employee(Delete Module)</h2>
<form method='post' action='/Employee-Expert/DeleteEmployee.jsp'>
<tm:FormID/>
<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
Name:<b>${employeeBean.name}</b><br>
Designation Code:<b>${employeeBean.designationCode}</b><br>
Designation:<b>${employeeBean.designation}</b><br>
Date Of Birth:<b>${employeeBean.dateOfBirth}</b><br>
Gender:<b>${employeeBean.gender}</b><br>
<tm:If condition='${employeeBean.isIndian=="Yes"}'>
Nationality:<b> Indian </b><br>
</tm:If>
<tm:If condition='${employeeBean.isIndian=="No"}'>
Nationality:<b> Not an Indian </b><br>
</tm:If>
Basic Salary:<b>${employeeBean.basicSalary}</b><br>
PAN Number:<b>${employeeBean.panNumber}</b><br>
Aadhar Card Number:<b>${employeeBean.aadharCardNumber}</b><br><br>
Are you sure you want to delete ?<br>
<br>
<button type='submit'>Yes</button>
<button type='Button' onClick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/Employee-Expert/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>