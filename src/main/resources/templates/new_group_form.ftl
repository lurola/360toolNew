<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

<meta charset="utf-8">
<title>New group</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function saveGroupAndDisplayUsers(teamName) {	
	
$.get("/group/create", {groupName : groupName.value}, function(data, status, xhr){
	if(data.length === 'undefined') {
		alert("Error");
		//error
	} else {	
		
		$('#createGroupDiv').hide();
		$('#idResult').val(data);
		$('#officeId').show();
		$('#addUserToTheGroup').show(); 	
	}
});
}

function officeSelected(office) {
	
	$.get("/user/getUserByOfficeId", {officeId : office.value}, function(data, status, xhr){
		if(data.length === 'undefined') {
			//error
		} else {
			//success
			var userCombo = $('#newUserId');
			
	    	userCombo.empty();//$('#userId').empty();
	    	
	    	var $select = userCombo; //var $select = $('#userId'); // you might wanna empty it first with .empty()
	    	
	    	$('<option/>', { value: 0, label:"Select a user" }).appendTo($select);
	    	
	    	for (var i = 0; i < data.length; i++) {
	    		console.log(data[i].name);
	    		var o = $('<option/>', {value: data[i].userId, label: data[i].name + " " + data[i].surname});
	    		o.appendTo($select);
	    	}    	
	    	
	    	userCombo.show(); //$('#userId').show();
	    	
	    	}
	});
	}

function showAddUserButton() {
	console.log("show")
	$('#addUser').show();
}


function addUserToGroup() {
	
console.log("addUserToGroup");
	
$.get("/user/assignUserToGroup", {userId : $('#newUserId').val(), groupId : $('#idResult').val() }, function(data, status, xhr){
	if(data.length === 'undefined') {
		alert("Error");
		//error
	} else {
		$('#officeId').show(); 	
	}
});
}

</script>
</head>

<body>

<div id="createGroupDiv">

	<input type="text" id="idResult" name="idResult" style="visibility:hidden"/>

	<h3>Create new group</h3>

	<input type="text" id="groupName" name="groupName"  placeholder="Introduce group name"/>

	<button onclick="saveGroupAndDisplayUsers(groupName)" class="btn btn-primary" id="createGroupBtn">Save</button>
	
</div>	
	
	<!------------------------------------------------------------------>

<div id="addUserToTheGroup" name="addUserToTheGroup"  style="display:none">

	<h3>Add users to the group</h3>

	<select name="officeId"  class="form-control" id="officeId" required  style="display:none" onchange="officeSelected(this)">
		<#list model["officeList"] as office>
			<option  value="${office.officeId}">${office.officeName}</option>
		</#list>
	</select>
	
	<select onchange="showAddUserButton()" name="newUserId"  class="form-control" id="newUserId" required style="display:none"></select>
	
	<button onclick="addUserToGroup();" class="btn btn-primary"  id="addUser" name="addUser" style="display:none">Add user</button>

</div>

</body>

</html>