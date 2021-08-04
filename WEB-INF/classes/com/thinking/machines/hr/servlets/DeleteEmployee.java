package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
RequestDispatcher requestDispatcher;
try
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
// do nothing
}
}
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
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
RequestDispatcher requestDispatcher;
if(employeeBean==null)
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
String employeeId=employeeBean.getEmployeeId();
if(employeeId==null || employeeId.length()==0)
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeDAO employeeDAO=new EmployeeDAO();
boolean employeeIdYes=employeeDAO.employeeIdExists(employeeId);
if(employeeIdYes==false)
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
try
{
employeeDAO.deleteByEmployeeId(employeeId);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Employee (Delete Module)");
messageBean.setMessage("Employee Deleted!");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
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