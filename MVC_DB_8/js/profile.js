window.onload = initAll;

function initAll(){
	getAllElements();	

	setAllActions();
}

var state,city;
function getAllElements(){
	state = document.getElementById('state');
	city = document.getElementById('city');
}

function setAllActions(){
	state.onchange = collectCities;
}

var cityReq;
function collectCities(){
	city.innerHTML = '<option value="0">City</option>';
	cityReq = createRequestObject();

	if(cityReq){
		cityReq.open('get', 'collect_cities.do?stateid='+state.value, true);
		cityReq.onreadystatechange = showCities;
		cityReq.send(null);
	}
}

function showCities(){
	if(cityReq.readyState==4){
		if(cityReq.status==200){
			var resp = eval('('+cityReq.responseText+')');
			//alert(resp);

			for(i=0;i<resp.length;i++){
				var newElm = document.createElement('option');
				newElm.innerHTML = resp[i].city;
				newElm.value = resp[i].cityid;

				city.appendChild(newElm);
			}
		}
	}
}

