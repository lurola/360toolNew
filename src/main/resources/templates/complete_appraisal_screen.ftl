<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="/css/buttons.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/util.css" rel="stylesheet">
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">

<meta charset="utf-8">
<title>New Appraisal</title>
</head>

<body>

<form action="/appraisal/finish" method="post">


<input style="visibility: hidden" type="text" value="${model.appraisal.evaluatedPersonId}"
				name="evaluatedPersonId" id="evaluatedPersonId"/>
				
<input style="visibility: hidden" type="text" value="${model.appraisal.appraiserId}"
				name="appraiserId" id="appraiserId"/>
				
<input style="visibility: hidden" type="text" value="${model.appraisal.appraisalId}"
				name="appraisalId" id="appraisalId"/>				
				
				


<a class="btn btn-dark" href="/" style="background-color: #4f5b69;color:#00CCFF;">Salir sin guardar</a>
<button class="btn btn-primary" formaction="/appraisal/saveButNotFinish" formmethod="post" style="background-color: #4f5b69;color:#00CCFF;">Guardar y continuar mas tarde</button>
<button class="btn btn-primary" type="submit" style="background-color: #4f5b69;color:#00CCFF;">Guardar y terminar</button>

<!--      tabla final    -->


	<table id="table" class="table table-striped">

		<#list 0..9 as i>

			<thead style="background-color: #00CCFF;color:#4f5b69;">
				<tr>
					<th scope="col">${model["appType"][i].appraisalTypeName}</th><th></th>					
				</tr>
			</thead>

		<#list 0..4 as j>

			<tbody>
				<tr>
					<td>${model["criteriaNames"][i][j].criteriaName}</td>
					<td>
					
					<!--  We indentify the appItemSelected -->
					
						<#list model["appraisal"].apprItemList as currAppItem>
							<#if currAppItem.appraisalTypeId == i && currAppItem.subtypeId == (j+1)>
								
								<select name="paramValue${i}${j}"  id="paramValue${i}${j}"  required>
								
									<#list model["evaluationValues"] as currentEval> 
										<#if currentEval.value == currAppItem.paramValue>
											<option selected="selected" value="${currentEval.value}">${currentEval.name}</option>  
										<#else>
											<option value="${currentEval.value}">${currentEval.name}</option>
										</#if> 
									</#list>
								</select>
							</#if> 
						</#list>
					</td>

				</tr>
				</#list>
			</tbody>

			</#list>	
	</table>
</form>
</body>