<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/Employee-Expert/js/DesignationDeleteConfirmation.js'></script>
<h2> Designation(Delete Module)</h2>
<form method='post' action='/Employee-Expert/DeleteDesignation.jsp' >
<tm:FormID/>
Designation : ${designationBean.title}<br><br>
<input type='hidden' id='code' name='code' maxlength='35' size='36' value='${designationBean.code}'>
Are you sure you want to delete ?
<button type='submit'>Yes</button>
<button type='Button' onClick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/Employee-Expert/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>