function login(){
 
    var account = document.getElementById("account").value;
    var password = document.getElementById("pwd").value;
     
    if(account.trim() == "" || password.trim() == ""){
        //mindestens ein Feld ist leer
        document.getElementById('message_empty_fields').style.display = 'block';
        document.getElementById('message').style.display = 'none';
    }else{
        //alle Felder sind ausgefuellt = login Prozess starten
        document.getElementById('loader_container').style.display = 'block';
        postData(account, password);    
    }
 
}
     
     
     
function postData(account, password){
        var url = "http://localhost:8080/loginseite/account=" + account + "&password=" + password;
     
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;
 
        xhr.addEventListener("readystatechange", function () {
                  if (this.readyState === 4 && this.status === 200) {
    //              Delay, um schwache Internetverbindung zu simulieren
                    setTimeout(function() { 
                        document.getElementById('loader_container').style.display = 'none';
                     }, 2000);
                      document.getElementById('message').style.display = 'none';
                      document.getElementById('message_no_user').style.display = 'none';
                      document.getElementById('message_empty_fields').style.display = 'none';
                      
                  }else if(this.readyState === 4 && this.status === 404){
                      document.getElementById('message_no_user').style.display = 'block';
                      document.getElementById('message').style.display = 'none';
                      document.getElementById('message_empty_fields').style.display = 'none';
                      document.getElementById('loader_container').style.display = 'none';  
                      
                      
                  }else if(this.readyState === 4 && this.status === 401){
                      document.getElementById('message').style.display = 'block';
                      document.getElementById('message_no_user').style.display = 'none';
                      document.getElementById('message_empty_fields').style.display = 'none';
                      document.getElementById('loader_container').style.display = 'none';
                  }
        });
 
        xhr.open("GET", url);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader("cache-control", "no-cache");
        xhr.send();
         
         
}
 