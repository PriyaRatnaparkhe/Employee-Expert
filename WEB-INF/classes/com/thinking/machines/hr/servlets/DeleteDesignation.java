package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
RequestDispatcher requestDispatcher;
try
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
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
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
RequestDispatcher requestDispatcher;
if(designationBean==null)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
int code=designationBean.getCode();
DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.deleteByCode(code);
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;

}catch(DAOException daoException)
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