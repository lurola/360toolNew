<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.String" -->

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
</head>
<body>

 

<p>You can use: alvaro.frias@innovation.group / demo</p>

<form role="form" action="/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
	<span>Login</span>

    <div>
    	
        
        <input type="email" name="email" id="email" required placeholder="Type your e-mail" autofocus/>
    </div>
    <div>
        <span>Password</span>
        <input type="password" name="password" id="password" placeholder="Type your password" required/>
    </div>
    <div>
        <span>Remember me</span>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button type="submit">Sign in</button>
    
    
    <a href="/user/remindpassword">Forgot password?</a>
    
    <a href="/user/create">Create a user</a>
</form>



</body>
</html>