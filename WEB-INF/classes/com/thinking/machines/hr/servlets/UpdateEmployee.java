package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession ss=request.getSession();
if(ss.getAttribute("username")==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeBean employeeBean;
employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String employeeId=employeeBean.getEmployeeId();
String name=employeeBean.getName();
int designationCode=employeeBean.getDesignationCode();
String title=employeeBean.getDesignation();
Date dateOfBirth=simpleDateFormat.parse(employeeBean.getDateOfBirth());
String gender=employeeBean.getGender();
String isindian=employeeBean.getIsIndian();
Boolean isIndian=false;
if(isindian.equals("Yes")) isIndian=true;
else isIndian=false;
BigDecimal basicSalary=new BigDecimal(employeeBean.getBasicSalary());
String panNumber=employeeBean.getPanNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();
try
{
boolean designationCodeExists=designationDAO.designationCodeExists(designationCode);
boolean panNumberExists=employeeDAO.panNumberExists(panNumber);
boolean aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
EmployeeDTO employee=new EmployeeDTO();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
employeeDAO.update(employee);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Employee(Update Module)");
messageBean.setMessage("Employee Updated !");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
SimpleDateFormat sda=new SimpleDateFormat("yyyy-MM-dd");
EmployeeBean employeeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeeBean.setName(name);
employeeeBean.setDesignationCode(designationCode);
employeeeBean.setDesignation(title);
employeeeBean.setDateOfBirth(sda.format(dateOfBirth));
employeeeBean.setGender(gender);
employeeeBean.setIsIndian(isindian);
employeeeBean.setBasicSalary(basicSalary.toString());
employeeeBean.setPanNumber(panNumber);
employeeeBean.setAadharCardNumber(aadharCardNumber);
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeUpdateConfirmation.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
try
{
System.out.println(exception);
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}
}
}