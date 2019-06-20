

function login(){
	var account = document.getElementById("account").value;
	var password = document.getElementById("pwd").value;
	body = '{"account" : "' + account + '","password" : "' + password + '"}';
	postData(account, password);

}
	
	
	
function postData(account, password){

		var url = "http://localhost:8001/srvc/login/verify?account=" + account + "&password=" + password;
	
		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function () {
			console.log(this.status)
		  if (this.readyState === 4 && this.status === 200) {
			  window.location = "http://" + window.location.hostname + "/content.html";
		  }else if(this.readyState === 4 && this.status === 404){
			  document.getElementById('message').style.display = 'block';
		  }else if(this.readyState === 4){
			  document.getElementById('message').style.display = 'block';
		  }
		});

		xhr.open("GET", url);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("Postman-Token", "bd8500f4-7ea6-4368-81ac-6db1e619c49a");

		xhr.send();
		
		
}


function formEncode(obj) {
        var str = [];
        for(var p in obj)
        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
        return str.join("&");
    };

	
	
