$(document).ready(function() { 
	document.getElementById('idavuelta').checked=true;
});

function mostrar(){
	
	document.getElementById('vuelta').style.display='inline-block';
	document.getElementById('ida').style.display='inline-block';
	
}
function ocultar (){
	
	document.getElementById('vuelta').style.display="none";
	document.getElementById('ida').style.display="block";
	
}
