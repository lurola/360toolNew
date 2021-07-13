<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

<meta charset="utf-8">
<title>New office</title>
</head>

<body>

<form action="/office/create" method="post">

<div class="container">

	<h3>Create new office</h3>

	<input type="text" id="officeName" name="officeName"  placeholder="Introduce office name"/>



<!-- <h3>Add person to the office</h3> -->

<!-- 	<select name="userId" class="form-control" id="userId" > -->
<!-- 		<#list model["userList"] as user> -->
<!-- 			<option  value="${user.userId}">${user.name} ${user.surname}</option> -->
<!-- 		</#list> -->
<!-- 	</select> -->
	
<!-- 	<button onclick="" class="btn btn-primary" formaction="" formmethod="get" id="addPerson">Add</button> -->
	
	<button class="btn btn-primary" type="submit" id="createOfficeBtn">Save</button>
	
	<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Atras</a>
	
</div>

</form>


</body>




</html>