

<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Log in</title>


</head>
<body>

	<div class="limiter">
		<!-- <p>You can use: alvaro.frias@innovation.group / demo</p> -->
		<div class="container-login100">

			<div class="wrap-login100">

				<form class="login100-form" role="form" action="/login" method="post">
						
						<span class="login100-form-title">INNOVATION GROUP</span>

					<div class="wrap-input100 validate-input" data-validate="Username is required">
						<span class="label-input100">Username</span> 
						<input class="input100" type="text" name="email" placeholder="Type your e-mail" required="required"> 
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span> 
						<input class="input100" type="password" name="password" placeholder="Type your password"> 
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>


					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button style="background-color: #4f5b69;color:#00CCFF;" class="login100-form-btn" type="submit">Login</button>
						</div>	
					</div>
					
					<div class="flex-col-c p-t-35">

					</div>
				</form>


			</div>
		</div>
	</div>



</body>
</html>