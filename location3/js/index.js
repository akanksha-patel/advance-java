window.onload = initAll;

var ct, result_box, cityid;

function initAll(){
	getAllElements();

	setAllActions();
	
	setDefaults();
}

function setDefaults(){
	result_box.style.display = 'none';
}

function getAllElements(){
	ct = document.getElementById('city');
	cityid = document.getElementById('cityid');

	result_box = document.getElementById('result_box');
}

function setAllActions(){
	ct.onkeyup = collectCities;
}

var ctReq = null;
function collectCities(){
	ctReq = createRequestObject();
	clearResultBox();

	if(ctReq&&ct.value.length>=2){
		ctReq.open('GET', 'cities.do?cityinit='+ct.value, true);
		ctReq.onreadystatechange = showCities;
		ctReq.send(null);
	}
}

function showCities(){
	if(ctReq.readyState==4){		
		if(ctReq.status==200){			

			var val = eval('('+ctReq.responseText+')');
			
			if(val.length>0){
				result_box.style.display = 'block';
			}

			for(i=0;i<val.length;i++){
				var dv = createDivAction();

				dv.innerHTML = val[i].citynm+' ('+val[i].statenm+')';
				dv.ctid = val[i].cityid;			

				result_box.appendChild(dv);
			}
		}
	}
}

function createDivAction(){
	var dv = document.createElement('div');
	dv.className = 'rs';

	dv.onmouseover = onOv;
	dv.onmouseout = onOut;
	dv.onclick = onclk;

	return dv;
}

function onclk(){
	ct.value = this.innerHTML;
	cityid.value = this.ctid;
	clearResultBox();
}

function onOv(){
	this.className = 'rs onov';
}

function onOut(){
	this.className = 'rs onout';
}

function clearResultBox(){
	result_box.innerHTML = ''; 
	result_box.style.display = 'none';
	cityid.value = 0;
}


