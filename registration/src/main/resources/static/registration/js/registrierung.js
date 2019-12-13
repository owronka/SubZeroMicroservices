function registrierung (){
	var anrede;
	var anredelistel;
	var	anredelistet;
	var vorname;
	var vnamel;
	var vnamet;
	var name;
	var namel;
	var namet;
	var email;
	var emaill;
	var emailt;
	var benutzer;
	var benutzerl;
	var benutzert;
	var password;
	var passl;
	var passt;
	var passwordwdhl;
	var pwdhll;
	var pwdhlt;
	var plz;
	var plzl;
	var plzt;
	var stadt;
	var stadtl;
	var stadtt;
	var strasse;
	var strassel;
	var strasset;
	var hnummer;
	var hnummerl;
	var hnummert;
	var salt = 'abcdef123456';
	var RegExemail = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;
	var body;
	var sha = new jsSHA("SHA-256", "TEXT");
	


	formObject = document.forms['register-form'];
	
	anredelistet = $("#anredelistet");
	vnamet = $("#vnamet");
	namet =  $("#namet");
	emailt = $("#emailt");
	benutzert = $("#benutzert");
	passt = $("#passt");
	pwdhlt = $("#pwdhlt");
	plzt =  $("#plzt");
	stadtt = $("#stadtt");
	strasset = $("#strasset");
	hnummert = $("#hnummert");
	
	anredelistel = $("#anredelistel");
	vnamel = $("#vnamel");
	namel = $("#namel");
	emaill = $("#emaill");
	benutzerl = $("#benutzerl");
	passl = $("#passl");
	pwdhll = $("#pwdhll");
	plzl = $("#plzl");
	stadtl = $("#stadtl");
	strassel = $("#strassel");
	hnummerl = $("#hnummerl");
	
	
	anredelistel.innerHTML = 'Anrede';
	anredelistel.removeClass("labelerror");
	vnamel.removeClass("labelerror");
	namel.innerHTML = 'Nachname';
	namel.removeClass("labelerror");
	emaill.innerHTML = 'E-Mail';
	emaill.removeClass("labelerror");
	benutzerl.innerHTML = 'Benutzer';
	benutzerl.removeClass("labelerror");
	passl.innerHTML = 'Passwort';
	passl.removeClass("labelerror");
	pwdhll.innerHTML = 'Passwort (Wiederholung)';
	pwdhll.removeClass("labelerror");
	plzl.innerHTML = 'Postleitzahl';
	plzl.removeClass("labelerror");
	stadtl.innerHTML = 'Stadt';
	stadtl.removeClass("labelerror");
	strassel.innerHTML = 'Strasse';
	strassel.removeClass("labelerror");
	hnummerl.innerHTML = 'Hausnummer';
	hnummerl.removeClass("labelerror");
	
anrede = anredelistet.val();
vorname = vnamet.val();
name = namet.val();
email = emailt.val();
benutzer = benutzert.val();
password = passt.val();
passwordwdhl = pwdhlt.val();
plz = plzt.val();
stadt = stadtt.val();
strasse = strasset.val();
hnummer = hnummert.val();

var leer ="Bitte nicht Leer lassen!";

if(!anrede || anrede == "leer"){
	anredelistel.addClass("labelerror");
	anredelistet.focus();
return;	
}
if(!vorname || vorname.length == 0){
	vnamet.attr("placeholder", leer);
	vnamel.addClass("labelerror");
	vnamet.focus();
return;	
}

if(!name || name.length == 0){
	namet.attr("placeholder", leer);
	namel.addClass("labelerror");
	namet.focus();	
return;
}
if (RegExemail.test (email) == false) {
	emailt.attr("placeholder", leer);
	emaill.addClass("labelerror");
	emailt.focus();
return;
	}
if (!email || email.length == 0) {
	emait.attr("placeholder", leer);
	emaill.addClass("labelerror");
	emailt.focus();

	return;
}

if (!benutzer || benutzer.length == 0) {
	benutzert.attr("placeholder", leer);
	benutzerl.addClass("labelerror");
	benutzert.focus();
	
	return;
}


if (!password || password.length < 8) {
	passt.attr("placeholder", leer);
	passl.addClass("labelerror");
	passt.focus();

	return;
}
	sha.update(password);
	var passwordHash = sha.getHash("HEX");
	
if (passwordwdhl != password) {
	pwdhlt.attr("placeholder", leer);
	pwdhll.addClass("labelerror");
	pwdhlt.focus();

	return;
}

if (!plz || plz.length == 0) {
	plzt.attr("placeholder", leer);
	plzl.addClass("labelerror");
	plzt.focus();

	return;
}
if (!plz || plz.length > 5) {
	plzt.attr("placeholder", leer);
	plzl.addClass("labelerror");
	plzt.focus();

	return;
}
if (!stadt || stadt.length == 0) {
	stadtt.attr("placeholder", leer);
	stadtl.addClass("labelerror");
	stadtt.focus();

	return;
}

if (!strasse || strasse.length == 0) {
	strasset.attr("placeholder", leer);
	strassel.addClass("labelerror");
	strasset.focus();

	return;
}

if (!hnummer || hnummer.length == 0) {
	hnummert.attr("placeholder", leer);
	hnummerl.addClass("labelerror");
	hnummert.focus();
	return;
}
/*body = 	'{"person":{' +
'"p_id":0,"anrede":"' + anrede + '","vorname":"' + vorname + '","nachname":"' + name + '","email":"' + email + '"},' +
'"account":{' +
'"ac_id":0,"benutzer":"' + benutzer + '","pwdHash":"' + password  +
'"address":{' +
'"addressId":0,"plz":"' + plz 
+ '","stadt":"' + stadt 
+ '","strasse":"' + strasse 
+ '","hausummer":"' 
+ hnummer +'}'
+ '}'

console.log(body);
 $.ajax(({
        url: "http://localhost:8080/registration"
    }).then(function(data) {
    console.log(body)
    })*/	
body ={
	person: {
		p_id:0,
		anrede: anrede,
		vorname: vorname,
		nachname: name,
		email: email
	},
	account: {
		ac_id:0,
		benutzer: benutzer,
		password: passwordHash
	},
	adress: {
		adress_id:0,
		plz: plz,
		strasse: strasse,
		hausnummer: hnummer
	}
}

$.ajax({
  type: "POST",
  url:"http://localhost:8080/registration",
  data: body,
  success: function(data) {
    console.log(data)
  },
  dataType: "application/json",
    contentType: "application/json"
});
}
$(document).ready(function(){
$("#register-form").submit(function(event) {
event.preventDefault();
console.log(""); 
registrierung();
});
});
