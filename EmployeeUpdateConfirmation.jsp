<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/Employee-Expert/js/EmployeeUpdateForm.js'></script>
<h2> Employee(Update Module)</h2>
<tm:FormID/>
<form method='post' action='/Employee-Expert/UpdateEmployee.jsp' onsubmit='return validateForm(this)'>
<table>
<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Designation</td>
<td><select id='designationCode' name='designationCode'>
<option value='-1'>&lt;Select Designation&gt;</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dBean'>
<tm:If condition='${employeeBean.designationCode==dBean.code}'>
<option selected value='${dBean.code}'>${dBean.title}</option>
</tm:If>

<tm:If condition='${employeeBean.designationCode!=dBean.code}'>
<option value='${dBean.code}'>${dBean.title}</option>
</tm:If>
</tm:EntityList>

</select>

<span id='designationCodeErrorSection' style='color:red'></span>
</td>
</tr>


<tr>
<td>Date of birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' style='color:red'></span>
</td>
</tr>

<tr>
<td>Gender</td>
<td>
<tm:If condition='${employeeBean.gender!="M"}'>
<input type='radio' id='male' name='gender' value='M'>Male
</tm:If>
<tm:If condition='${employeeBean.gender=="M"}'>
<input checked type='radio' id='male' name='gender' value='M'>Male
</tm:If>
&nbsp;&nbsp;&nbsp;&nbsp;
<tm:If condition='${employeeBean.gender!="F"}'>
<input type='radio' id='female' name='gender' value='F'>Female
</tm:If>
<tm:If condition='${employeeBean.gender=="F"}'>
<input checked type='radio' id='female' name='gender' value='F'>Female
</tm:If>
<span id='genderErrorSection' style='color:red'></span>
</td>
</tr>

<tr>
<td>Indian ?</td>
<td>
<tm:If condition='${employeeBean.isIndian=="Yes"}'>
<input checked type='checkbox' name='isIndian' id='isIndian' value='Yes'>
</tm:If>
<tm:If condition='${employeeBean.isIndian!="Yes"}'>
<input type='checkbox' name='isIndian' id='isIndian' value='Yes'>
</tm:If>
</td>
</tr>


<tr>
<td>Basic Salary</td>
<td>
<input type='text' style='text-align:right' name='basicSalary' id='basicSalary' maxlength='12' size='13' value='${employeeBean.basicSalary}'>
<span id='basicSalaryErrorSection' style='color:red'></span>
</td>
</tr>

<tr>
<td>PAN Number</td>
<td>
<input type='text' id='panNumber' name='panNumber'  maxlength='15' size='16' value='${employeeBean.panNumber}'>
<span id='panNumberErrorSection' style='color:red'></span>
</td>
</tr>

<tr>
<td>Aadhar Card Number</td>
<td>
<input type='text' id='aadharCardNumber' name='aadharCardNumber'  maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' style='color:red'></span>
</td>
</tr>

<tr>
<td>
<span class='error'>${errorBean.error}</td></span>
</tr>
<tr>
<td colspan='2'><button type='submit'>Update</button>
&nbsp;&nbsp;<button type='Button' onClick='cancelUpdation()'>Cancel</button></td>
</table>
</form>
</div>
<form id='cancelUpdateForm' action='/Employee-Expert/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>