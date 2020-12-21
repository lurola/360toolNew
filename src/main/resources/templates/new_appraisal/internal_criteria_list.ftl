<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

<script type="text/javascript">

function personChanged(userId) {

	//TODO: recibir el nuevo valor del usuario, para cuando pulsemos en el boton, se envie el id
	// y recupere los appraisals de ese usuario
	window.location = "/appraisal/visualizeInternalCriteria/" + userId;
}


</script>


</head>

<body>
	<form name="appraisalInfo" action="/appraisal/getFinishedAppraisalsByUser/">
	
	
		<input id="personSelected" type="text" value="" style="visibility:hidden">

		<div>
			<label for="userId">User</label> 
			<select name="userId" id="userId" onchange="personChanged(this.value);">
				<option selected="selected" value="">Select a user</option>
				<#list model["userListToDisplay"] as user>
						<option value="${user.userId}">${user.name}  ${user.surname}</option> 
				</#list>
			</select>
		</div>	
		
		<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Home</a>
		
		<button type="submit"></button>

</form>
	
	
 <!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

<script src="/bootstrap/js/boostrap.min.js"></script>

	
</body>	
</html>
		
		