<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <script>
    function searchContact(){
    	var xhttp = new XMLHttpRequest();
    	xhttp.open("GET", "/handle?search=" + document.getElementById('search_label').value, true);
		xhttp.send();
		
		
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				jsonText = xhttp.responseText;
				
				showContacts(jsonText);

			}
		};
		
		
		
    }
    
    
    
    </script>
    
    
</head>
<body>


<h2>Welcome to the Search Form</h2>
<table><tr>
<td>Insert name, phone or e-mail adress: </td>
<td><input type="text" name = "search_label2" id ="search_label"></td></tr>

</table>

 <button value="searchContact" onclick="searchContact();">Show contacts</button>
    


<br><br><br>
 

<jsp:directive.include file = "contact.html" />





</body>
</html>