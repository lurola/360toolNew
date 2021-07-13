<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.String" -->

<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Log in</title>

<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

function officeSelected(office) {

var userCombo;
var displayButton = false;
	
if(office.id === "officeId") {
	userCombo = $('#userId');
	displayButton = false;
} else {
	userCombo = $('#appraiserUserId');
	displayButton = true;
}
	
$.get("/user/getUserByOfficeId", {officeId : office.value}, function(data, status, xhr){
	if(data.length === 'undefined') {
		//error
	} else {
		//success
    	userCombo.empty();//$('#userId').empty();
    	
    	var $select = userCombo; //var $select = $('#userId'); // you might wanna empty it first with .empty()
    	
    	$('<option/>', { value: 0, label:"Select a user" }).appendTo($select);
    	
    	for (var i = 0; i < data.length; i++) {
    	    var o = $('<option/>', { value: data[i].userId, label:data[i].name + " " + data[i].surname });
    	    o.appendTo($select);
    	}    	
    	
    	userCombo.show(); //$('#userId').show();
    	$('#appraiserDiv').show();
    	if(displayButton) {
    		$('#btnContainer').show();
    	}
	}
});
}

function sendManualAssignment() {	
	
	$.get("/appraisal/manualAssignment", {userId : $('#userId').val(), appraiserUserId : $('#appraiserUserId').val()}, function(data, status, xhr){
		window.location = "/";
	});

}




</script>
</head>

<body>



<div class="container">

<h3>Persona a evaluar</h3>

	<select name="officeId" onchange="officeSelected(this);"  class="form-control" id="officeId" required>
		<#list model["officeList"] as office>
			<option  value="${office.officeId}">${office.officeName}</option>
		</#list>
	</select>
	
	<select name="userId" style="display:none" class="form-control" id="userId" required></select>
</div>


<div id="appraiserDiv" class="container" style="display:none">
	<h3>Evaluador</h3>

	<select name="appraiserOfficeId" onchange="officeSelected(this);"  class="form-control" id="appraiserOfficeId" required>
		<#list model["officeList"] as office2>
			<option  value="${office2.officeId}">${office2.officeName}</option>
		</#list>
	</select>	
	
	<select name="appraiserUserId"  class="form-control" id="appraiserUserId" required></select>	
		
</div>

<div id="btnContainer" class="container" style="display:none" onclick="sendManualAssignment();">
	<button class="btn btn-primary" id="sendManualAssignmentBtn" style="background-color: #4f5b69;color:#00CCFF;">Asignar</button>
	<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Atras</a>
</div>


</body>

</html>