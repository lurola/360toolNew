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

	
	function visulizeAllAppraisals () {
		
		window.location = "/appraisal/visualizeAllAppraisals/" + ${model.evaluatedPersonId};
		
	}

</script>
</head>


<body>


<form name="appraisalInfo" id="appraisalInfo" action="/appraisal/visualizeAppraisal" method="post">
	<input id="idSelected" name="idSelected" style="visibility:hidden">
</form>

<div class="container">	

<div class="row">
	<input style="visibility: hidden" type="text" value="${model.evaluatedPersonId}"
				name="evaluatedPersonId" id="evaluatedPersonId"/>
</div>




	<table id="table" class="table">
		<thead >
			<tr>
				<th scope="col" style="visibility: hidden">Id</th>
				<th scope="col">Person evaluated</th>
				<th scope="col">Appraiser</th>
				<th scope="col">Average</th>
			</tr>

		</thead>
		<#list model["appraisalHeaderList"] as appraisal>

		<tbody>
			<tr>
				<td scope="row" style="visibility: hidden">${appraisal.appraisalId}</td>
				<td>${appraisal.evaluatedPersonName}</td>
				<td>${appraisal.appraiserName}</td>
				<td>${appraisal.average}</td>

			</tr>


		</tbody>
		</#list>

	</table>

<div class="container">
	<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Home</a>
</div>

<#if model["appraisalHeaderList"]?has_content>
	
		<button class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;" onclick="visulizeAllAppraisals();">See all appraisals</button>
	
</#if>	
</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>

	<script src="/bootstrap/js/boostrap.min.js"></script>

	<script type="text/javascript">
$( "#table tr" ).click(function() {
		
		var value=$(this).find('td:first').html();
		$("#idSelected").val(value);
		$("#appraisalInfo").submit();
	   
	 });
	</script>




</body>