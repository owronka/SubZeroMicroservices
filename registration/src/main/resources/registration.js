$.ajax({
	    async: false,
	    dataType: 'json',
	    error: function(data) {
	    	$.mobile.changePage('#error', 'pop', true, true);	    	
	    },
	    success: function(data) {
	    	window.location.href=maiURL;
	    }, 
	    type: 'POST',
	    url: webURL + '/person?anrede=' + encodeURIComponent(Anrede) +
					  '&vorname=' + encodeURIComponent(Vorname) + 
	    			  '&nachname=' + encodeURIComponent (Nachname) +
	    			  '&email=' + encodeURIComponent(Email) +
	    			  '&telefon=' + encodeURIComponent(Telefon) +
	    			  '&strasse=' + encodeURIComponent(Strasse) +
					  '&hausnummer=' + encodeURIComponent(Hausnummer) +
					  '&plz=' + encodeURIComponent(PLZ) +
					  '&ort=' + encodeURIComponent(Ort) +
					  '&username=' + encodeURIComponent(Username) +
					  '&password=' + encodeURIComponent(Password) +
					  
	});	
}
