var showDelete = null;
var showEdit = null;
var showLogout = null;
var tokenValue = null;
var signatureValue = null;

$(function(){
	$('#new-picture-file').customFileInput();	
});

function deleteArea() {
	console.log('delete area [' + sessionStorage.getItem('areaIndex') + ']');

	$.ajax({
		async: false,
		contentType: 'application/json',
   		dataType: 'json',
  		error: function(xhr, status, error) {
  		    alert(xhr.responseText);
  		 },
   		headers: {
         'Signature-Value':signatureValue,
         'Token-Value':tokenValue
   		},  
		type: 'DELETE',
		success: function(data, status, xhr){
			if (xhr.status == 200) {
				alert(result.message);
			}
		},
   		url: webURL + '/area/' + sessionStorage.getItem('areaIndex')
	});
}

function editArea() {
	var areaName;
	var areaNameLbl;
	var areaNameTxt;
	
	formObject  = document.forms['rename-area-form'];
	
	areaNameTxt = formObject.elements['rename-area-area-name-text'];

	areaNameLbl = document.getElementById('rename-area-area-name-label');

	areaName    = areaNameTxt.value;
	
	if (!areaName || areaName.length < 6) {
		areaNameLbl.innerHTML = 'Der Areaname muss mindestens 6 Zeichen lang sein';
		areaNameLbl.style.color = '#FF0000';
		areaNameTxt.focus();
		
		return;
	}

	sessionStorage.setItem ('areaName', areaName);
	
	console.log('edit area [' + areaName + ']');

	$.mobile.changePage('#rename-area-dialog', 'pop', true, true);
}

function logout () {
	var username = encodeURIComponent(sessionStorage.getItem('userName'));
	

	sessionStorage.clear();
	
	window.location = lgoURL + '?username=' + username;
}

function newArea() {
	var areaName;
	var areaNameLbl;
	var areaNameTxt;
	
	formObject  = document.forms['new-area-form'];
	
	areaNameTxt = formObject.elements['new-area-area-name-text'];

	areaNameLbl = document.getElementById('new-area-area-name-label');

	areaName    = areaNameTxt.value;
	
	if (!areaName || areaName.length < 6) {
		areaNameLbl.innerHTML = 'Der Areaname muss mindestens 6 Zeichen lang sein';
		areaNameLbl.style.color = '#FF0000';
		areaNameTxt.focus();
		
		return;
	}

	sessionStorage.setItem ('areaName', areaName);
	
	console.log('add new area [' + areaName + ']');

	$.ajax({
		async: false,
		contentType: 'application/json',
  		dataType: 'json',
  		error: function(xhr, status, error) {
  		    alert(xhr.responseText);
  		 },
  		headers: {
            'Signature-Value':signatureValue,
            'Token-Value':tokenValue
      		},  
		success: function(data, status, xhr){
			if (xhr.status == 200) {
				$.mobile.changePage('#new-area-dialog', 'pop', true, true);
			}
		},
  		type: 'PUT',
		url: webURL + '/area/' + encodeURIComponent(areaName)
	});
}

function nextPicture () {
	setAreaPage(sessionStorage.getItem('areaIndex'), sessionStorage.getItem('areaFolder'), sessionStorage.getItem('areaName'), 'new-picture');
}

function setArea(areaIndex, areaFolder, areaName) {
	console.log("set area [" + areaIndex + "] [" + areaFolder + "] [" + areaName + "]");
	
	sessionStorage.setItem ('areaIndex', areaIndex);
	sessionStorage.setItem ('areaFolder', areaFolder);
	sessionStorage.setItem ('areaName', areaName);
}

function setAreaPage(areaIndex, areaFolder, areaName, pageId) {
	console.log("set area page [" + areaIndex + "] [" + areaFolder + "] [" + areaName + "] [" + pageId + "]");
	
	formObject = document.forms[pageId + '-form'];
		
	formObject.elements[pageId + '-area-name-text'].value = decodeURIComponent(areaName);
	
	if (formObject.elements[pageId + '-area-id-text'] != null) {
		formObject.elements[pageId + '-area-id-text'].value = areaIndex;
	}
	
	sessionStorage.setItem ('areaIndex', areaIndex);
	sessionStorage.setItem ('areaFolder', areaFolder);
	sessionStorage.setItem ('areaName', areaName);
}

function setPicture(pictureIndex, pictureName) {
	console.log("set picture [" + pictureIndex + "] [" + pictureName + "]");
	
	sessionStorage.setItem ('pictureIndex', pictureIndex);
	sessionStorage.setItem ('pictureName', pictureName);
}

function uploadPicture () {

	document.forms['new-picture-form'].submit();
}

$( '#delete-areas' ).live( 'pagebeforeshow',function(event){
	console.log('deleteAreas');

	$('#delete-area-list li').remove();

	$.getJSON(webURL + '/areas', 
	function(data) {
		$.each(data.atos, function(index, area) {
			$('#delete-area-list').append('<li data-icon="minus">' +
					                      '<a href="#delete-area-dialog" data-rel="dialog" data-position-to="window" data-role="button" data-inline="true" data-transition="pop" onclick="setArea(\'' + area.id + '\')">'+ area.name + '</a>' +
					                      '</li>');
		});
		$('#delete-area-list').listview('refresh');
	  });
});

$( '#rename-area' ).live( 'pageshow',function(event){
	document.forms['rename-area-form'].elements['rename-area-area-name-text'].focus();
});

$( '#rename-areas' ).live( 'pagebeforeshow',function(event){

	console.log('renameAreas');
	
	$.getJSON(webURL + '/areas', 
	function(data) {
		$.each(data.atos, function(index, area) {
			$('#rename-area-list').append('<li data-icon="gear"><a href="#edit-area" data-transition="slidefade" onclick=setAreaPage(' + area.id + ',\'' + area.folder + '\',\'' + encodeURIComponent(area.name) + '\',' +  '\'edit-area\')>'+ area.name + '</a></li>');

		});
		$('#rename-area-list').listview('refresh');
	  });
});

$( '#list-areas' ).live( 'pagebeforeshow',function(event){
	if (showLogout == null) {
		showDelete     = $.urlParam('showDelete');
		showEdit       = $.urlParam('showEdit');
		showLogout     = $.urlParam('showLogout');
		tokenValue     = $.urlParam('tokenValue');
		signatureValue = $.urlParam('signatureValue');

		sessionStorage.setItem('userName', $.urlParam('userName'));
	}
	
	console.log('list-areas live event');

	$('#list-area-list li').remove();

	$.getJSON(webURL + '/areas', 
	function(data) {
		$.each(data.atos, function(index, area) {
			var folder = 'empty';
			
			if(area.number != 0) {
				folder = area.folder;
			}
			
			$('#list-area-list').append('<li><a href="#list-pictures" data-transition="slidefade" onclick=setArea(\'' + area.id + '\',\'' + area.folder + '\',\'' + encodeURIComponent(area.name) + '\')>' +
					'<img src="' + imgURL + '/' + folder + '.jpg" height="100" width="150"/>' +
					'<h3>'+ area.name + '</h3><p>Anzahl:' + area.number + ' - Gr&ouml;&szlig;e: ' +
					area.size + ' KB</p></a></li>');

		});
		$('#list-area-list').listview('refresh');
	  });

	if (showLogout == 'true') {
		var button;
		var innerHtml;

		button = document.getElementById('list-areas-header-field-set-mid-header');
		innerHtml = button.innerHTML.trim();

		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
	        'data-role=\"button\" data-transition=\"slideup\" ' +
	        'href=\"#edit-areas\" ' +
	        'data-corners=\"true\" ' +
	        'data-shadow=\"true\" ' +
	        'data-iconshadow=\"true\" ' +
	        'data-wrapperels=\"span\" ' +
	        'data-theme=\"a\">' +
	        	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
	        		'<span class=\"ui-btn-text\">Bearbeiten</span>' +
	        	'</span>' +
	        '</a>';
		}

		button = document.getElementById('list-areas-header-field-set-right-header');
		innerHtml = button.innerHTML.trim();

		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
	        'data-role=\"button\" data-transition=\"slideup\" ' +
	        'data-corners=\"true\" ' +
	        'data-shadow=\"true\" ' +
	        'data-iconshadow=\"true\" ' +
	        'data-wrapperels=\"span\" ' +
	        'data-theme=\"a\" ' +
	        'onclick=\"logout()\">' +
	        	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
	        		'<span class=\"ui-btn-text\">Logout</span>' +
	        	'</span>' +
	        '</a>';
		}
	}
});

$( '#list-pictures' ).live( 'pagebeforeshow',function(event){
	console.log('list-pictures live event');

	$('#list-picture-list li').remove();

	$.getJSON(webURL + '/pictures?areaId=' + sessionStorage.getItem ('areaIndex'), 
	function(data) {
		$.each(data.ptos, function(index, picture) {
			var pictureDate = new Date(picture.date);
			
			$('#list-picture-list').append('<li><a href="#show-picture" data-transition="slidefade" onclick=setPicture(\'' + picture.id + '\',\'' + picture.name + '\')>' +
					'<img src="' + imgURL + '/' + data.area.folder + '/' +  picture.name + '-TN.jpg" height="200" width="300"/>' +
					'<h3>Datum: '+ pictureDate.getDate() + '.' + pictureDate.getMonth() + '.' + pictureDate.getFullYear() + '</h3><p>Gr&ouml;&szlig;e: ' + picture.size + ' KB</p></a></li>');
		});
		$('#list-picture-list').listview('refresh');
	  });
});

$( '#edit-areas' ).live( 'pagebeforeshow',function(event){
	console.log('edit-areas live event');

	$('#edit-area-list li').remove();

	$.getJSON(webURL + '/areas', 
	function(data) {
		$.each(data.atos, function(index, area) {
			var folder = 'empty';
			
			if(area.number != 0) {
				folder = area.folder;
			}
			
			$('#edit-area-list').append('<li><a href="#new-picture" data-transition="slidefade" onclick=setAreaPage(\'' + area.id + '\',\'' + area.folder + '\',\'' + encodeURIComponent(area.name) + '\',' +  '\'new-picture\')>' +
					'<img src="' + imgURL + '/' + folder + '.jpg" height="100" width="150"/>' +
					'<h3>'+ area.name + '</h3><p>Anzahl:' + area.number + ' - Gr&ouml;&szlig;e: ' +
					area.size + ' KB</p></a></li>');

		});
		$('#edit-area-list').listview('refresh');
	  });


	if (showLogout == 'true') {
		var button;
		var innerHtml;
										  
		button = document.getElementById('edit-areas-header-field-set-top-right-header');
		innerHtml = button.innerHTML.trim();
	
		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
	        'data-role=\"button\" data-transition=\"slideup\" ' +
	        'data-corners=\"true\" ' +
	        'data-shadow=\"true\" ' +
	        'data-iconshadow=\"true\" ' +
	        'data-wrapperels=\"span\" ' +
	        'data-theme=\"a\" ' +
	        'onclick=\"logout()\">' +
	        	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
	        		'<span class=\"ui-btn-text\">Logout</span>' +
	        	'</span>' +
	        '</a>';
		}
	}
	
	if (showDelete == 'true') {
		var button;
		var innerHtml;

		button = document.getElementById('edit-areas-header-field-set-bottom-right-header');
		innerHtml = button.innerHTML.trim();

		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
			                 'data-role=\"button\" data-transition=\"slideup\" ' +
			                 'href=\"#delete-areas\" ' +
			                 'data-corners=\"true\" ' +
			                 'data-shadow=\"true\" ' +
			                 'data-iconshadow=\"true\" ' +
			                 'data-wrapperels=\"span\" ' +
			                 'data-theme=\"a\">' +
			                 	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
			                 		'<span class=\"ui-btn-text\">L&ouml;schen</span>' +
			                 	'</span>' +
			                 '</a>';
		}
	}		

	if (showEdit == 'true') {
		var button;
		var innerHtml;

		button = document.getElementById('edit-areas-header-field-set-bottom-left-header');
		innerHtml = button.innerHTML.trim();

		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
            'data-role=\"button\" data-transition=\"slideup\" ' +
            'href=\"#new-area\" ' +
            'data-corners=\"true\" ' +
            'data-shadow=\"true\" ' +
            'data-iconshadow=\"true\" ' +
            'data-wrapperels=\"span\" ' +
            'data-theme=\"a\">' +
            	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
            		'<span class=\"ui-btn-text\">Neu</span>' +
            	'</span>' +
            '</a>';
		}

		button = document.getElementById('edit-areas-header-field-set-bottom-mid-header');
		innerHtml = button.innerHTML.trim();

		if (innerHtml == '') {
			button.innerHTML='<a class=\"ui-btn ui-shadow ui-btn-corner-all ui-btn-up-a\" ' +
            'data-role=\"button\" data-transition=\"slideup\" ' +
            'href=\"#rename-areas\" ' +
            'data-corners=\"true\" ' +
            'data-shadow=\"true\" ' +
            'data-iconshadow=\"true\" ' +
            'data-wrapperels=\"span\" ' +
            'data-theme=\"a\">' +
            	'<span class=\"ui-btn-inner ui-btn-corner-all\">' +
            		'<span class=\"ui-btn-text\">Bearbeiten</span>' +
            	'</span>' +
            '</a>';
		}
	}
});

$( '#new-area' ).live( 'pageshow',function(event){
	document.forms['new-area-form'].elements['new-area-area-name-text'].focus();
});

$( '#show-picture' ).live( 'pagebeforeshow',function(event){
	console.log('show-picture live event');
	
	document.images["show-picture"].src = imgURL + '/' + sessionStorage.getItem ('areaFolder') + '/' +  sessionStorage.getItem ('pictureName') + '.jpg';
});

