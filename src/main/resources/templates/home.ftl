
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

	


<div class="nav-side-menu">

    <div class="brand"> <a style="color: 00CCFF" href="/logout">Logout</a> </div>
    

    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
            
            
            
            
                <li  data-toggle="collapse" data-target="#administration" class="collapsed">
                  <a href="#"><i class="fa fa-gift fa-lg"></i>Administration<span class="arrow"></span></a>
                </li>
                 
                 <ul class="sub-menu collapse" id="administration">
                 
                    <li><a href="/user/create">New user</a></li>
                    <li><a href="/office/loadCreateScreen">New office</a></li>
                    <li><a href="/team/loadCreateScreen">New team</a></li>
                    <li><a href="/group/loadCreateScreen">New group</a></li>
                    <li><a href="/user/loadAssignMentorScreen">Assign mentor</a></li>                    
 
                </ul>
                
                
                

                <li  data-toggle="collapse" data-target="#Profile" class="collapsed">
                  <a href="#"><i class="fa fa-user fa-lg"></i>Perfil<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="Profile">
                 
                    
                </ul>


                <li data-toggle="collapse" data-target="#appraisals" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Appraisals<span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="appraisals">
                
                	
                        <li><a href="/appraisal/assignAppraisers/1">Generate appraisals for Cordoba</a></li>
	                  	<li><a href="/appraisal/loadManualAssignment">Assign appraisal manually</a></li>
	                  	<li><a href="/appraisal/seeOtherAppraisals/7">See other appraisals</a></li>
	                  	<li><a href="/appraisal/loadInternalCriteriaScreen/7">See internal criteria</a></li>
	                  	<li><a href="/appraisal/expireAppraisals/1">Expire appraisals not finished</a></li>
                	

				  <li><button  formaction="/appraisal/getRemainingAppraisalsForAUser" formmethod="post" class="menuButton">Pending appraisals</button></li>
				  <li><button formaction="/appraisal/getFinishedAppraisalsByUser" formmethod="post"  class="menuButton">My appraisals</button></li>
                  
                  
                </ul>

            </ul>
     </div>
</div>

</form>

