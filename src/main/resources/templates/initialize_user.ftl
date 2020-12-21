<html lang="es">

<head>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>

<body>
<form action="/user/initializeUser" method="post">


	<div class="form-group">
		<input type="password" id="currentPassword" name="currentPassword"  placeholder="Introduce current password"/>
	</div>
	
	<div class="form-group">
		<input type="password" id="newPassword" name="newPassword"  placeholder="Introduce new password"/>
	</div>
	
	<div class="form-group">
		<input type="password" id="repeatedPassword" name="repeatedPassword"  placeholder="Repeat password"/>
	</div>
	
	<div class="form-group">
		<input style="visibility:hidden" type="text" id="userId" name="userId"  value="${model.userId}"  />
	</div>


	<button class="btn btn-primary" style="background-color: #4f5b69;color:#00CCFF;" type="submit" id="changePassword">Save</button>




</form>
</body>
</html>