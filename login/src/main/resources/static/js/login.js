

function login(){
	var account = document.getElementById("account").value;
	var password = document.getElementById("pwd").value;
	console.log(account, password);
	body = '{"account" : "' + account + '","password" : "' + password + '"}';
	postData(account, password);

}
	
	
	
function postData(account, password){

	var url = "http://localhost:8001/srvc/login/verify?account=" + account + "&password=" + password;

		var form = new FormData();

		var settings = {
		  "async": true,
		  "crossDomain": true,
		  "url": url,
		  "method": "GET",
		  "headers": {
		    "cache-control": "no-cache",
		    "postman-token": "e59c3fcc-4b44-28d6-545a-6df1e3fe4d0a"
		  },
		  "processData": false,
		  "contentType": false,
		  "mimeType": "multipart/form-data",
		  "data": form
		}

		$.ajax(settings).done(function (response) {
		  
		  alert(response);
		});
}


function formEncode(obj) {
        var str = [];
        for(var p in obj)
        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
        return str.join("&");
    };

	
//
//	
