window.onload = initAll;

var cn,cnparam;
function initAll(){
	cn = document.getElementById('country');
	cn.onchange = collectStates;

	cnparam = document.getElementById('cnparam');
	if(cnparam){
		for(var i=0;i<cn.options.length;i++){
			if(cn.options[i].value==cnparam.value){
				cn.options[i].selected = 'selected';
			}
		}
	}
}

function collectStates(){
	window.location = 'states.do?countryid='+this.value;
}