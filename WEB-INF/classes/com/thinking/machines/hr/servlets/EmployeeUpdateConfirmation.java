package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
public class EmployeeUpdateConfirmation extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
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
String employeeIdString=request.getParameter("employeeId");
RequestDispatcher requestDispatcher;
if(employeeIdString==null || employeeIdString.length()==0)
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}

EmployeeDAO employeeDAO=new EmployeeDAO();
EmployeeDTO employeeDTO=new EmployeeDTO();
try
{
employeeDTO=employeeDAO.getByEmployeeId(employeeIdString);
EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeIdString);
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setDesignation(employeeDTO.getDesignation());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String stringDateOfBirth=simpleDateFormat.format(employeeDTO.getDateOfBirth());
employeeBean.setDateOfBirth(stringDateOfBirth);
employeeBean.setGender(employeeDTO.getGender());
Boolean isIndianBool=employeeDTO.getIsIndian();
String isIndian="";
if(isIndianBool==true) isIndian="Yes";
else isIndian="No";
employeeBean.setIsIndian(isIndian);
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setPanNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
requestDispatcher=request.getRequestDispatcher("/EmployeeUpdateConfirmation.jsp");
requestDispatcher.forward(request,response);
return;
}catch(	DAOException daoException)
{
System.out.println(daoException);
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
System.out.println(exception);
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}
}
}