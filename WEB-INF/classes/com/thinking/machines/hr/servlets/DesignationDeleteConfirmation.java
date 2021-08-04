package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DesignationDeleteConfirmation extends HttpServlet
{
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
String codeString=request.getParameter("code");
RequestDispatcher requestDispatcher;
if(codeString==null)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
int code=0;
try
{
code=Integer.parseInt(codeString);
if(code<=0)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(NumberFormatException numberFormatException)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO=new DesignationDTO();
try
{
designationDTO=designationDAO.getByCode(code);
DesignationBean designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designationDTO.getTitle());
request.setAttribute("designationBean",designationBean);
requestDispatcher=request.getRequestDispatcher("/DesignationDeleteConfirmation.jsp");
requestDispatcher.forward(request,response);
return;
}catch(	DAOException daoException)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
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