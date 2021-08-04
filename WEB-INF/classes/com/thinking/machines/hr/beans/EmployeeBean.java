package com.thinking.machines.hr.beans;
import java.util.*;
import java.text.*;
import java.math.*;
public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
private String employeeId;
private String name;
private int designationCode;
private String designation;
private String dateOfBirth;
private String gender;
private String isIndian;
private String basicSalary;
private String panNumber;
private String aadharCardNumber;
public EmployeeBean()
{
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth=sdf.format(1970-01-01);
this.gender="";
this.isIndian="";
this.basicSalary="";
this.panNumber="";
this.aadharCardNumber="";
}
public boolean isMale()
{
return gender.equals("M");
}
public boolean isFemale()
{
return gender.equals("F");
}
public void setEmployeeId(String employeeId)
{
this.employeeId=employeeId;
}
public String getEmployeeId()
{
return this.employeeId;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public int getDesignationCode()
{
return this.designationCode;
}
public void setDesignation(String designation)
{
this.designation=designation;
}
public String getDesignation()
{
return this.designation;
}
public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
public String getBasicSalary()
{
return this.basicSalary;
}
public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}
public void setIsIndian(String isIndian)
{
this.isIndian=isIndian;
}
public String getIsIndian()
{
return this.isIndian;
}
public void setPanNumber(String panNumber)
{
this.panNumber=panNumber;
}
public String getPanNumber()
{
return this.panNumber;
}
public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public int hashCode()
{
return employeeId.hashCode();
}
public boolean equals(Object object)
{
if(!(object instanceof EmployeeBean)) return false;
EmployeeBean employee=(EmployeeBean)object;
return this.employeeId.equals(employee.employeeId);
}
public int compareTo(EmployeeBean employee)
{
return this.employeeId.compareTo(employee.employeeId);
}
}