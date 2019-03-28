"use strict";

function content () {
	var req = new XMLHttpRequest();  

	req.timeout=1000;

	req.open('GET', conURL, true);  

	req.onreadystatechange = function(){
		if (req.readyState == 4) {
			if (req.status == 200) {
				window.location.href = conURL;
			} else {
				$.mobile.changePage('#content-error-dialog', 'pop', true, true);
			}
		}
		if (req.readyState == 4) {
		}
	}
	
	req.send();
}

function login () {
	var req = new XMLHttpRequest();  

	req.timeout = 2000;

	req.open('GET', logURL, true);

	req.onreadystatechange = function(){
		console.log('readyState [' + req.readyState + ' - status [' + req.status + ']');
		if (req.readyState == 4) {
			if (req.status == 200) {
				window.location.href = logURL;
			} else {
				$.mobile.changePage('#login-error-dialog', 'pop', true, true);
			}
		}
	}

	req.send();
}

function register () {
	var req = new XMLHttpRequest();  

	req.timeout = 1000;

	req.open('GET', regURL, true);  

	req.onreadystatechange = function(){
		if (req.readyState == 4) {
			if (req.status == 200) {
				window.location.href = regURL;
			} else {
				$.mobile.changePage('#registration-error-dialog', 'pop', true, true);
			}
		}
	}

	req.send();
}
