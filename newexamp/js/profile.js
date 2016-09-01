window.onload = initAll;


function initAll(){
	getAllElements();

	setAllActions();
}

var dob_fld,dob_save_btn;
var addr,addr_save_btn;
var city, city_save_btn;
function getAllElements(){
	dob_fld = document.getElementById('dob_fld');
	dob_save_btn = document.getElementById('dob_save_btn');
	
	addr = document.getElementById('addr');
	addr_save_btn = document.getElementById('addr_save_btn');

	city = document.getElementById('city');
	city_save_btn = document.getElementById('city_save_btn');
}

function setAllActions(){
	dob_save_btn.onclick = saveDob;
	addr_save_btn.onclick = saveAddress;
	city_save_btn.onclick = saveCity;
}

var cityReqObj;
function saveCity(){
	cityReqObj = createRequestObject();
	
	if(cityReqObj){
		cityReqObj.open('get', 'savecity.do?cityid='+city.value, true);
		cityReqObj.onreadystatechange = showCityChange;
		cityReqObj.send(null);
	}
}

function showCityChange(){
	if(cityReqObj.readyState==4){
		if(cityReqObj.status==200){
			alert(cityReqObj.responseText);
		}
	}
}

var addrReqObj;
function saveAddress(){
	addrReqObj = createRequestObject();

	if(addrReqObj){
		addrReqObj.open('get', 'saveaddr.do?address='+escape(addr.value), true);
		addrReqObj.onreadystatechange = showAddressChanges;
		addrReqObj.send(null);
	}
}

function showAddressChanges(){
	if(addrReqObj.readyState==4){
		if(addrReqObj.status==200){
			alert(addrReqObj.responseText);
		}	
	}
}

var dobReqObj;
function saveDob(){
	dobReqObj = createRequestObject();

	if(dobReqObj){
		dobReqObj.open('get', 'savedob.do?dob='+escape(dob_fld.value), true);
		dobReqObj.onreadystatechange = showDobChanges;
		dobReqObj.send(null);
	}
}

function showDobChanges(){
	alert(dobReqObj.readyState+' - '+dobReqObj.status);
	
	if(dobReqObj.readyState==4){
		if(dobReqObj.status==200){
			alert(dobReqObj.responseText);
		}
	}
}