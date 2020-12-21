
<head>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<link href="/css/sidebar.css" rel="stylesheet">

<link href="/css/buttons.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

</head>



<form >

	<input style="visibility: hidden" type="text" value="${currentUser.id}" name="userId" id="userId"/>


<div class="nav-side-menu">
    <div class="brand">${currentUser.name} ${currentUser.surname}</div>
    <div class="brand"> <a style="color: 00CCFF" href="/logout">Logout</a> </div>
    

    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
            
            
            <#if currentUser.role == 'ADMIN'>
            
                <li  data-toggle="collapse" data-target="#administration" class="collapsed">
                  <a href="#"><i class="fa fa-gift fa-lg"></i>Administration<span class="arrow"></span></a>
                </li>
                 
                 <ul class="sub-menu collapse" id="administration">
                 
                    <li><a href="/user/create">Nuevo usuario</a></li>
                    <li><a href="/office/loadCreateScreen">Nueva oficina</a></li>
                    <li><a href="/team/loadCreateScreen">Nuevo equipo</a></li>
                    <li><a href="/group/loadCreateScreen">Nuevo grupo</a></li>
                    <li><a href="/user/loadAssignMentorScreen">Assign mentor</a></li>                    
 
                </ul>
                
                </#if>
                

                <li  data-toggle="collapse" data-target="#Profile" class="collapsed">
                  <a href="#"><i class="fa fa-user fa-lg"></i>Perfil<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="Profile">
                    <li class="active"><a href="/user/updateprofile/${currentUser.id}">Actualizar mi usuario</a></li>
                    <#if currentUser.role == 'ADMIN'>
                   		<li><a href="/user/loadChangePasswordScreen/${currentUser.id}">Cambiar contraseña</a></li>
					</#if>
                </ul>


                <li data-toggle="collapse" data-target="#appraisals" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Appraisals<span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="appraisals">
                
                	<#if currentUser.role == 'ADMIN'>
                        <li><a href="/appraisal/assignAppraisers/1">Generate evaluaciones para Cordoba</a></li>
	                  	<li><a href="/appraisal/expireAppraisals/1">Expirar evaluaciones no terminadas</a></li>
	                  	<li><a href="/appraisal/loadManualAssignment">Asignacion manual de evaluacion</a></li>
	                  	<li><a href="/appraisal/seeOtherAppraisals/${currentUser.id}">Ver otras evaluaciones</a></li>
	                  	<li><a href="/appraisal/loadInternalCriteriaScreen/${currentUser.id}">Ver criterios internos</a></li>
                	</#if>

				  <li><button style="width: 80%" formaction="/appraisal/getFinishedAppraisalsByUser" formmethod="post"  class="menuButton">Mis evaluaciones</button></li>
                  <li><button style="width: 80%" formaction="/appraisal/getRemainingAppraisalsForAUser" formmethod="post" class="menuButton">Evaluaciones pendientes</button></li>
                  
                </ul>

            </ul>
     </div>
</div>

</form>

