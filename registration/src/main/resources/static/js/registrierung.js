$(function() {
         $("#vorname_error_message").hide();
         $("#nachname_error_message").hide();
		 $("#account_error_message").hide();
         $("#email_error_message").hide();
         $("#password_error_message").hide();
         $("#retype_password_error_message").hide();
         var error_vorname = false;
         var error_nachname = false;
		 var error_account = false;
         var error_email = false;
         var error_password = false;
         var error_retype_password = false;
         $("#form_vorname").focusout(function(){
            check_vorname();
         });
         $("#form_nachname").focusout(function() {
            check_nachname();
         });
		 $("#form_account").focusout(function() {
            check_account();
         });
         $("#form_email").focusout(function() {
            check_email();
         });
         $("#form_password").focusout(function() {
            check_password();
         });
         $("#form_retype_password").focusout(function() {
            check_retype_password();
         });
		 
		 function check_vorname() {
            var pattern = /^[a-zA-Z]*$/;
            var fname = $("#form_vorname").val();
            if (pattern.test(fname) && fname !== '') {
               $("#vorname_error_message").hide();
               $("#form_vorname").css("border-bottom","2px solid #34F458");
            } else {
               $("#vorname_error_message").html("Nur Buchstaben sind erlaubt!");
               $("#vorname_error_message").show();
               $("#form_vorname").css("border-bottom","2px solid #F90A0A");
               error_vorname = true;
            }
         }
		 function check_nachname() {
            var pattern = /^[a-zA-Z]*$/;
            var sname = $("#form_nachname").val()
            if (pattern.test(sname) && sname !== '') {
               $("#nachname_error_message").hide();
               $("#form_nachname").css("border-bottom","2px solid #34F458");
			  
            } else {
               $("#nachname_error_message").html("Nur Buchstaben sind erlaubt!");
               $("#nachname_error_message").show();
               $("#form_nachname").css("border-bottom","2px solid #F90A0A");
               error_nachname = true;
            }
         }
		 function check_account() {
		 var pattern = /^[a-zA-Z]*$/;
            var aname = $("#form_account").val()
            if (pattern.test(aname) && aname !== '') {
               $("#account_error_message").hide();
               $("#form_account").css("border-bottom","2px solid #34F458");
			  
            } else {
               $("#account_error_message").html("Nur Buchstaben sind erlaubt!");
               $("#account_error_message").show();
               $("#form_account").css("border-bottom","2px solid #F90A0A");
               error_account = true;
            }
         }
		 function check_email() {
            var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
            var email = $("#form_email").val();
            if (pattern.test(email) && email !== '') {
               $("#email_error_message").hide();
               $("#form_email").css("border-bottom","2px solid #34F458");
            } else {
               $("#email_error_message").html("Ungültige Emailadresse");
               $("#email_error_message").show();
               $("#form_email").css("border-bottom","2px solid #F90A0A");
               error_email = true;
            }
		}
		function check_password() {
            var password_length = $("#form_password").val().length;
            if (password_length < 5) {
               $("#password_error_message").html("Weniger als 5 Zeichen");
               $("#password_error_message").show();
               $("#form_password").css("border-bottom","2px solid #F90A0A");
               error_password = true;
            } else {
               $("#password_error_message").hide();
               $("#form_password").css("border-bottom","2px solid #34F458");
            }
         }
         function check_retype_password() {
            var password = $("#form_password").val();
            var retype_password = $("#form_retype_password").val();
            if (password !== retype_password) {
               $("#retype_password_error_message").html("Passwörter stimmen nicht überein!");
               $("#retype_password_error_message").show();
               $("#form_retype_password").css("border-bottom","2px solid #F90A0A");
               error_retype_password = true;
            } else {
               $("#retype_password_error_message").hide();
               $("#form_retype_password").css("border-bottom","2px solid #34F458");
            }
         }
		 $("#registration_form").submit(function() {
            error_vorname = false;
            error_nachname = false;
            error_email = false;
            error_password = false;
            error_retype_password = false;
            check_vorname();
            check_nachname();
			check_account();
            check_email();
            check_password();
            check_retype_password();
            if (error_vorname === false && error_nachname === false && error_account === false && error_email === false && error_password === false && error_retype_password === false) {
               alert("Registrierung erfolgreich");
               return true;
            } else {
               alert("Bitte korrigiere deine Eingaben");
               return false;
            }
         });
	
	});