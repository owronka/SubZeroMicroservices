function CurrentArea (newIndex, newFolder, newName) {
	this.index = newIndex;
	this.folder = newFolder;
	this.name = newName;
}

function CurrentPicture (newIndex, newName) {
	this.index = newIndex;
	this.name = newName;
}

var ca = new CurrentArea (0, '', '');
var cp = new CurrentPicture (0, '');

function register () {
	var firstName;
	var firstNameLbl;
	var firstNameTxt;
	var lastName;
	var lastNameLbl;
	var lastNameTxt;
	var eMail;
	var eMailLbl;
	var eMailTxt;
	var eMailRepeat;
	var eMailRepeatLbl;
	var eMailRepeatTxt;
	var userName;
	var userNameLbl;
	var userNameTxt;
	var password;
	var passwordHash;
	var passwordLbl;
	var passwordTxt;
	var passwordRepeat;
	var passwordRepeatLbl;
	var passwordRepeatTxt;
	var eMailRegEx = new RegExp ('^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$');
	
	formObject = document.forms['register-form'];
	
	firstNameTxt      = formObject.elements['first-name-text'];
	lastNameTxt       = formObject.elements['last-name-text'];
	eMailTxt          = formObject.elements['e-mail-text'];
	eMailRepeatTxt    = formObject.elements['e-mail-repeat-text'];
	userNameTxt       = formObject.elements['user-name-text'];
	passwordTxt       = formObject.elements['password-text'];
	passwordRepeatTxt = formObject.elements['password-repeat-text'];
	
	firstNameLbl      = document.getElementById('first-name-label');
	lastNameLbl       = document.getElementById('last-name-label');
	eMailLbl          = document.getElementById('e-mail-label');
	eMailRepeatLbl    = document.getElementById('e-mail-repeat-label');
	userNameLbl       = document.getElementById('user-name-label');
	passwordLbl       = document.getElementById('password-label');
	passwordRepeatLbl = document.getElementById('password-repeat-label');

	firstNameLbl.innerHTML = 'Vorname';
	firstNameLbl.style.color = '#000000';
	lastNameLbl.innerHTML = 'Nachname';
	lastNameLbl.style.color = '#000000';
	eMailLbl.innerHTML = 'E-Mail';
	eMailLbl.style.color = '#000000';
	eMailRepeatLbl.innerHTML = 'E-Mail (Wiederholung)';
	eMailRepeatLbl.style.color = '#000000';
	userNameLbl.innerHTML = 'Benutzer';
	userNameLbl.style.color = '#000000';
	passwordLbl.innerHTML = 'Passwort';
	passwordLbl.style.color = '#000000';
	passwordRepeatLbl.innerHTML = 'Passwort (Wiederholung)';
	passwordRepeatLbl.style.color = '#000000';

	firstName      = firstNameTxt.value;
	lastName       = lastNameTxt.value;
	eMail          = eMailTxt.value;
	eMailRepeat    = eMailRepeatTxt.value;
	userName       = userNameTxt.value;
	password       = passwordTxt.value;
	passwordRepeat = passwordRepeatTxt.value;
	
	if (!firstName || firstName.length == 0) {
		firstNameLbl.innerHTML = 'Der Vorname darf nicht leer sein';
		firstNameLbl.style.color = '#FF0000';
		firstNameTxt.focus();
		
		return;
	}

	if (!lastName || lastName.length == 0) {
		lastNameLbl.innerHTML = 'Der Nachname darf nicht leer sein';
		lastNameLbl.style.color = '#FF0000';
		lastNameTxt.focus();

		return
	}

	if (!eMail || eMail.length == 0) {
		eMailLbl.innerHTML = 'Die E-Mail darf nicht leer sein';
		eMailLbl.style.color = '#FF0000';
		eMailTxt.focus();

		return;
	}
	    
	if (eMailRegEx.test (eMail) == false) {
		eMailLbl.innerHTML = 'Die E-Mail einen ung&uuml;ltigen Aufbau';
		eMailLbl.style.color = '#FF0000';
		eMailTxt.focus();

		return;
	}
	
	if (!eMailRepeat || eMailRepeat.length == 0) {
		eMailRepeatLbl.innerHTML = 'Die E-Mail Wiederholung darf nicht leer sein';
		eMailRepeatLbl.style.color = '#FF0000';
		eMailRepeatTxt.focus();

		return;
	}
	
	if (eMail != eMailRepeat) {
		eMailRepeatLbl.innerHTML = 'Die E-Mail und die E-Mail Wiederholung sind unterschiedlich';
		eMailRepeatLbl.style.color = '#FF0000';
		eMailRepeatTxt.focus();

		return;
	}
	
	if (!userName || userName.length == 0) {
		userNameLbl.innerHTML = 'Der Benutzername darf nicht leer sein';
		userNameLbl.style.color = '#FF0000';
		userNameTxt.focus();
		
		return;
	}

	if (!password || password.length < 8) {
		passwordLbl.innerHTML = 'Das Passwort muss mindestens 8 Zeichen beinhalten';
		passwordLbl.style.color = '#FF0000';
		passwordTxt.focus();

		return;
	}

	if (!passwordRepeat || passwordRepeat.length < 8) {
		passwordRepeatLbl.innerHTML = 'Die Passwort Wiederholung muss mindestens 8 Zeichen beinhalten';
		passwordRepeatLbl.style.color = '#FF0000';
		passwordRepeatTxt.focus();

		return;
	}

	if (password != passwordRepeat) {
		passwordRepeatLbl.innerHTML = 'Das Passwort und die Passwort Wiederholung sind unterschiedlich';
		passwordRepeatLbl.style.color = '#FF0000';
		passwordRepeatTxt.focus();

		return;
	}
	
	passwordHash = sha1(password);
	
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
	    url: webURL + '/user?username=' + encodeURIComponent(userName) + 
	    			  '&password=' + passwordHash +
	    			  '&firstname=' + encodeURIComponent(firstName) +
	    			  '&lastname=' + encodeURIComponent(lastName) +
	    			  '&email=' + encodeURIComponent(eMail)
	});	
}

$( '#register' ).live( 'pageshow',function(event){
	document.forms['register-form'].elements['first-name-text'].focus();
});

