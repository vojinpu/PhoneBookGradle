<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Contacts</title>


<input type="hidden" id="refreshed" value="no">

<script type="text/javascript">
window.addEventListener( "pageshow", function ( event ) {
	  var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
	  if ( historyTraversal ) {
	    // Handle page restore.
	    window.location.reload(true);
	  }
	});
</script>












<script>

window.onload = function showContact() {
		
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "/handle?id=all", true);
		xhttp.send();
		

		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {

				jsonText = xhttp.responseText;
				localStorage.lastname = jsonText;
				
				
				showContacts(jsonText);
				
				
			}
		};
				
	};
	


	
</script>

</head>




<body">  
	<h1>Welcome to PhoneBook</h1>






	<td colspan="2" style="font-weight: bold;">Available comands:</td>
	<br>
	<br>

	<a href="/createContact.html">1. Create Contact</a>
	<br>
	<a href="/searchContact.jsp">2. Search Contacts</a>
	<br>
	<a href="/deleteContact.html">3. Delete Contacts</a>
	<br>
	<br>



	<br>
	<br>
	



<jsp:directive.include file = "contact.html" />


<h1>TEST TEST TEST</h1>


</body>

</HTML>







