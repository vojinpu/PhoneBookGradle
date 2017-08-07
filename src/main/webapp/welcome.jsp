<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>VOJA</h1>


<h2>$(welcomeMessage)</h2>


<h2>$(msg)</h2>


<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script>

window.onload = function showContact() {
	
	
	$.ajax({
		url : "/contacts",
		data : "test data",
		type : "GET",

		success : function(response) {
			respOther = response;
			alert( response );
		},
		error : function(xhr, status, error) {
			alert(xhr.responseText);
		}
	});
	
	
	
	
	
	

	
	console.log('request sent')
	
	xhttp = new XMLHttpRequest();
	xhttp.open("GET", "/contacts/all", true);
	
	console.log('request sent2')
	xhttp.send();
	
	console.log('request sent3')
	
	
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
	
			console.log('request sent4')
			jsonText = xhttp.responseText;
			
			console.log('request sent5')
			console.log("radi")
			console.log(jsonText)			
			
		}
	};
	
	
	
	
	
	
	
}



</script>
<h1>sdadasdasd</h1>



Hello Stranger123! ${WelcomeMessage} 
</body>
</html>