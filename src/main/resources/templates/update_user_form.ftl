<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#--@ftlvariable name="form" type="com.appraisaltool.model.UserCreateForm" -->
<#import "/spring.ftl" as spring> <!DOCTYPE html>
<html lang="en">
<head>
<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">



<title>Create a new user</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

function showMentorCombo() {
	
		
	$.get("/user/getUserByOfficeId", {officeId : $('#mentorOfficeId').val()}, function(data, status, xhr){

		if(data.length === 'undefined') {
			//error
		} else {
			//success
	    	$('#mentorId').empty();
	    	
	    	var $select = $('#mentorId'); // you might wanna empty it first with .empty()
	    	
	    	$('<option/>', { value: 0, label:"Select a user" }).appendTo($select);
	    	
	    	for (var i = 0; i < data.length; i++) {
	    	    var o = $('<option/>', { value: data[i].userId, label:data[i].name + " " + data[i].surname });
	    	    o.appendTo($select);
	    	}    	
	    	
// 	    	$('#mentorDiv').show(); //$('#userId').show();
	    	
		}
	});
	}



</script>



</head>
<body>
	<nav role="navigation">
		<ul>

		</ul>
	</nav>

<div class="container">

	<h1>Update user</h1>

	<form  name="form" action="" method="post">
	
		<div>
			<input type="text" name="userId" class="form-control" placeholder="First-Name" style="visibility: hidden"
				value="${model.userForm.userId}" id="userId" required />
		</div>

		<div>
			<input type="text" name="name" class="form-control" placeholder="First-Name"
				value="${model.userForm.name}" id="name" required autofocus />
		</div>



		<div>
			<input type="text" placeholder="Last-Name" class="form-control"
				value="${model.userForm.surname}" name="surname" id="surname"
				required />
		</div>


		<div>
			<input type="email" placeholder="Email address" class="form-control"
				name="email" id="email" required value="${model.userForm.email}" />
		</div>


		<div class="row">
		
		<div class="col-md-2">
			<label for="roleId">Role</label> 
		</div>
		<div class="col-md-10">
			<select name="roleId" id="roleId" required  class="form-control">
				<#list model["roleList"] as role> 
					<#if role.roleId== model.userForm.roleId>
						<option selected="selected" value="${role.roleId}">${role.roleName}</option>
					<#else>
						<option value="${role.roleId}">${role.roleName}</option>
					</#if> 
				</#list>
			</select>
			</div>
		</div>

		<div class="row">
		<div class="col-md-2">
			<label for="officeId">Office</label> 
		</div>
		<div class="col-md-10">
			<select name="officeId" class="form-control" id="officeId" required > 
				<#list model["officeList"] as office> <#if office.officeId==
					model.userForm.officeId>
				<option selected="selected" value="${office.officeId}">${office.officeName}</option>
				<#else>
				<option value="${office.officeId}">${office.officeName}</option></#if> </#list>
			</select>
			</div>
		</div>
		
		<div class="row">
		<div class="col-md-2">
			<label for="teamId">Team</label> 
		</div>

		<div class="col-md-10">
			<select name="teamId" id="teamId" required multiple  class="form-control">
				<#list model["teamList"] as team> <#assign found>false</#assign>
				<#list model.userForm.teamId as listaElegidos> <#if
					team.teamId== listaElegidos>
				<option selected="selected" value="${team.teamId}">${team.teamName}</option>
				<#assign found>true</#assign> </#if> </#list> <#if found=="false">
				<option value="${team.teamId}">${team.teamName}</option>
				</#if> </#list>
			</select>
			</div>
		</div>
		
		
		
	<div class="row">
		<div class="col-md-2">
			<label for="groupId">Group</label>
		</div>

		<div class="col-md-10">
			<select name="groupId" id="groupId" required multiple  class="form-control">
				<#list model["groupList"] as group> <#assign found>false</#assign>
				<#list model.userForm.groupId as listaElegidos> <#if
					group.groupId== listaElegidos>
				<option selected="selected" value="${group.groupId}">${group.groupName}</option>
				<#assign found>true</#assign> </#if> </#list> <#if found=="false">
				<option value="${group.groupId}">${group.groupName}</option>
				</#if> </#list>
			</select>
			</div>
		</div>


		<div class="row">
			<div class="col-md-2">
				<label >Mentor</label> 
			</div>
	
			<div class="col-md-10">
				
				<select id="mentorOfficeId" name="mentorOfficeId" onchange="showMentorCombo();"  class="form-control"  required>
					<#list model["officeList2"] as office2>
						<option value="${office2.officeId}">${office2.officeName}</option>
					</#list>
				</select>
				
				<!--  TODO llamar con Ajax a una funcion que recupere los trabajadores de la oficina seleccionada -->
			</div>
		</div>
		
		<div id="mentorDiv" name="mentorDiv" class="row" >
			<div class="col-md-2">
				<label for="mentorId">User</label> 
			</div>
			<div class="col-md-10">
				<select  id="mentorId"  name="mentorId" class="form-control" required ></select>
			</div>
		</div>


		<button class="btn btn-primary" style="background-color: #4f5b69;color:#00CCFF;" type="submit">Save</button>
		<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Back</a>
		
		
		</div>
	</form>

</body>
</html>