<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">


<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">


<title>Individual Appraisal</title>
</head>

<body>

<a href="/" class="btn btn-info" style="background-color: #4f5b69;color:#00CCFF;">Home</a>

	<table id="table" class="table">


	<#if model["allAppraisals"] == true> 

		<thead>
				<tr>
					<th scope="col">Evaluaciones de ${model["evaluatedPersonName"]}</th>	
					<#list model["appItemList"] as appItem>
						<th></th>
					</#list>
				</tr>
		</thead>
	</#if>

		<!-- ***** INDIVIDUALS ***** -->
		<#list 0..9 as i>
  
			<thead style="background-color: #00CCFF;color:#4f5b69;">
				<tr>
					<th scope="col">${model["appType"][i].appraisalTypeName}</th>
					<#list model["appItemList"] as appItem>
						<th>
							<#if model["allAppraisals"] == false>
								${model["averages"][i]}
							</#if>
						</th>
					</#list>					
				</tr>
			</thead>

		<#list 0..4 as j>

			<tbody>
				<tr>
					<td>${model["criteriaNames"][i][j].criteriaName}</td>
					<#list model["appItemList"] as appItem>
						<td>${appItem[i][j].paramValue}</td>
					</#list>
				</tr>
				</#list>
			</tbody>

			</#list>	
	</table>
</body>