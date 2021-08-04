package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateDesignation extends HttpServlet
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
String title=designationBean.getTitle();
if(code<=0)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
if(title==null || title.length()==0)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
try
{
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setCode(code);
designationDTO.setTitle(title);
designationDAO.update(designationDTO);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Designation (Update Module)");
messageBean.setMessage("Designation Updated !");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
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