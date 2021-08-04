function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian="";
this.basicSalary=0;
this.panNumber="";
this.aadharCardNumber="";
}
var selectedRow=null;
var employees=[];
function selectEmployee(row,employeeId)
{
if(row==selectedRow)
{
return;
}
if(selectedRow!=null)
{
selectedRow.style.background="white";
selectedRow.style.color="black";
}
row.style.background="#7C7B7B";
row.style.color="white";
selectedRow=row;
var i;
for(i=0;i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId
document.getElementById("detailPanel_name").innerHTML=emp.name
document.getElementById("detailPanel_designation").innerHTML=emp.designation
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth
document.getElementById("detailPanel_gender").innerHTML=emp.gender
if(emp.isIndian=="Yes")
{
document.getElementById("detailPanel_isIndian").innerHTML="Yes";
}
else
{
document.getElementById("detailPanel_isIndian").innerHTML="No";
}
document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary
document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber
document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber
}
function populateEmployeesGridTable()
{
function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function()
{
selectEmployee(rowAddress,employeeId);
};
}
var employeesGridTable=document.getElementById("employeesGridTable");
//alert(employeesGridTable);
var employeesGridTableBody=employeesGridTable.getElementsByTagName("tbody")[0];
//alert(employeesGridTableBody);
//alert(employeesGridTableBody.innerHTML);
var employeesGridTableBodyRowTemplate=employeesGridTableBody.getElementsByTagName("tr")[0]
//alert(employeesGridTableBodyRowTemplate.innerHTML);
employeesGridTableBodyRowTemplate.remove();
// remove the row from dom(document object model)
var employeesGridTableBodyColumnsTemplateCollection=employeesGridTableBodyRowTemplate.getElementsByTagName("td");
var cellTemplate;
var k;
var dynamicRow;
//alert(employees.length)
var dynamicRowCells;
var placeHolderFor;
for(k=0;k<employees.length;k++)
{
dynamicRow=employeesGridTableBodyRowTemplate.cloneNode(true);
employeesGridTableBody.appendChild(dynamicRow);
//alert(employeesGridTableBodyRowTemplate.innerHTML);
//alert(dynamicRow.innerHTML);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for (var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute("placeHolderId");
if(placeHolderFor==null) continue;
if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1)+".";
if(placeHolderFor=="employeeId") cellTemplate.innerHTML=employees[k].employeeId;
if(placeHolderFor=="name") cellTemplate.innerHTML=employees[k].name;
if(placeHolderFor=="designationCode") cellTemplate.innerHTML=employees[k].designationCode;
if(placeHolderFor=="designation") cellTemplate.innerHTML=employees[k].designation;
if(placeHolderFor=="dateOfBirth") cellTemplate.innerHTML=employees[k].dateOfBirth;
if(placeHolderFor=="gender") cellTemplate.innerHTML=employees[k].gender;
if(placeHolderFor=="isIndian") cellTemplate.innerHTML=employees[k].isIndian;
if(placeHolderFor=="basicSalary") cellTemplate.innerHTML=employees[k].basicSalary;
if(placeHolderFor=="panNumber") cellTemplate.innerHTML=employees[k].panNumber;
if(placeHolderFor=="aadharCardNumber") cellTemplate.innerHTML=employees[k].aadharCardNumber;
if(placeHolderFor=="editOption") cellTemplate.innerHTML="<a href='/Employee-Expert/employeeUpdateConfirmation?employeeId="+employees[k].employeeId+"'>Edit</a>";
if(placeHolderFor=="deleteOption") cellTemplate.innerHTML="<a href='/Employee-Expert/employeeDeleteConfirmation?employeeId="+employees[k].employeeId+"'>Delete</a>";
}
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
//add click event to dynamic row
//onclick='selectEmployee(this,"${employeeBean.employeeId}")
}//employees population loop ends
}
//alert(employees.length);
window.addEventListener('load',populateEmployeesGridTable);