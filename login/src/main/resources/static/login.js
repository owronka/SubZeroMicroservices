

function login(){
	var account = document.getElementById("account").value;
	var password = document.getElementById("pwd").value;
	console.log(account, password);
	body = '{"account" : "' + account + '","password" : "' + password + '"}';
	postData(account, password);

//s
	
	
	
	
function postData(account, password){
	fetch("http://localhost:8001/login?account="+account+"&password=" + password, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, cors, *same-origin
        headers: {
            'Content-Type': 'application/json',
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrer: 'no-referrer', // no-referrer, *client
        body: JSON.stringify({}), // body data type must match "Content-Type" header
    })
    .then(response => {
    	console.log(response.json());
    	}); // parses JSON response into native Javascript objects
    
}

	
//
//	
