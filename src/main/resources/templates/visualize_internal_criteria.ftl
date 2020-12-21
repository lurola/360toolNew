<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">


<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">


<title>Internal Criteria</title>
</head>

<body>

<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Home</a>

	<table id="table" class="table table-striped">

		<!-- ***** INDIVIDUALS ***** -->
		<#list 0..3 as i>
  
			<thead style="background-color: #00CCFF;color:#4f5b69;">
				<tr>
					<th scope="col">${model["criteriaTitles"][i]}</th><th>${model["averages"][i]}</th>					
				</tr>
			</thead>

		<#list 0..4 as j>

			<tbody>
				<tr style="background-color:#FFF;" >
					<td>${model["criteriaSubtypes"][i][j]}</td>
					<td>${model["internalCriteriaResults"][i][j]}</td>
				</tr>
				</#list>
			</tbody>

			</#list>	
	</table>












</body>

</html>

