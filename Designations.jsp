<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='DESIGNATION'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designations</h2>
<table border='1'>
<thead>
<!-- This is for the table title -->
<!Table head starts here-->
<tr>
<th colspan='4' style='text-align:right;padding:5px'>
<a href='/Employee-Expert/DesignationAddForm.jsp'>Add new designation</a>
</th>
</tr>
<tr>
<th style='width:60px;text-align:center'>S.No</th>
<th style='width:200px;text-align:center'>Designations</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
<!--Table head ends here-->
</thead>
<tbody>
<!-- Data from database -->
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dBean'>
<tr>
<td style='text-align:right'>${serialNumber}.</td>
<td>${dBean.title}</td>
<td style='text-align:center'><a href='/Employee-Expert/editDesignation?code=${dBean.code}'>Edit</a></td>
<td style='text-align:center'><a href='/Employee-Expert/designationDeleteConfirmation?code=${dBean.code}'>Delete</a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
<jsp:include page='/MasterPageBottomSection.jsp'/>