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

var appraisalSelected = 0;
function selectAppraisal(appraisalId) {

	appraisalSelected = appraisalId;
	console.log(appraisalId);	

}


</script>
</head>

<body>

<form name="appraisalInfo" id="appraisalInfo" action="/appraisal/newAppraisal" method="post">
	<input id="idSelected" name="idSelected" style="visibility:hidden">
</form>

	

	<div class="container">

		<table id="table" class="table table-striped">
		<thead >
			<tr>
				<th scope="col" style="visibility:hidden;background-color: #fff">Id</th>
				<th scope="col">Person to evaluate</th>
				<th scope="col">Office</th>
				<th scope="col">Team</th>
				<th scope="col">Role</th>
			</tr>
				
		</thead>
			<#list model["peopleToBeEvaluated"] as personToBeEvaluated> 
			
		<tbody>
				<tr>
					<td scope="row" style="visibility:hidden">${personToBeEvaluated.appraisalId}</td>	
					<td>${personToBeEvaluated.userName}</td>
					<td>${personToBeEvaluated.office}</td>
					
					<td>
						<#list personToBeEvaluated.team as team>${team} </#list>
					</td>
					<td>${personToBeEvaluated.role}</td>
					
				</tr>
			</#list>
			</tbody>	
		</table>	
		
		

		<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Home</a>
	

</div>		
			
	
 <!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->


<script src="/bootstrap/js/boostrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


<script type="text/javascript">




$( "#table tr" ).click(function() {
		
		var value=$(this).find('td:first').html();
		$("#idSelected").val(value);
		$("#appraisalInfo").submit();
	   
	 });


</script>



	
</body>	
</html>
		
		