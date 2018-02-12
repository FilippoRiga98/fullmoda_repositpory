jQuery(document).ready(function() {
	document.getElementById("logoutInp").addEventListener("click", function(event){
	    event.preventDefault();
	    $('#logout').submit();
	});
}); 

