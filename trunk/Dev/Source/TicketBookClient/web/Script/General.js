/**
 * checkAll(chkItems, chkAllControl)
 * @param chkName
 * @param chkAll
 * @return void
 */
function checkAll(chkAllControlName, chkItemsName){
	chkItems = document.getElementsByName(chkItemsName);
	chkAllControl = document.getElementById(chkAllControlName);
	if(chkAllControl.checked){
		for(i=0; i<chkItems.length; ++i){
			chkItems[i].checked = true;
		}	
	}else{
		for(i=0; i<chkItems.length; ++i){
			chkItems[i].checked = false;
		}
	}
}
/** Leung
 * exportBtnClick(formName)
 * @param formName
 * @return boolean
 */
function exportBtnClick(formName){
    // store origin action of the form
    var originAction = document.forms[formName].getAttribute('action');
    // generate a new window name
    var today = new Date();
    var newWindowName = "ExportTimesheet_"+today.getDay()+today.getMonth()+today.getFullYear();
    document.forms[formName].target = newWindowName;
    // Show the please wait screen.
    window.open("PleaseWait.html", newWindowName,"scrollbars=no,status=yes,resizable=yes,width=100,height=50");
    // set the form action to export
    document.forms[formName].action = "ExportTimeSheetController";
    document.forms[formName].submit();
    // set the form to origin state
    document.forms[formName].target = "_self";
    document.forms[formName].action = originAction;
    return false;
}