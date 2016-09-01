window.onload = initAll;


function initAll(){
	getAllElements();
	setAllActions();
}

var username, email, password, confirm_password, male, female, city;
var  unm_msg, eml_msg, pwd_msg, cnf_msg, gnd_msg, city_msg;
var theForm;
function getAllElements(){
	//get all form fields
	username = document.getElementById('username');
	email = document.getElementById('email');
	password = document.getElementById('password');
	confirm_password = document.getElementById('confirm_password');
	female = document.getElementById('female');
	male = document.getElementById('male');
	city = document.getElementById('city');
	
	//get all error messages
	unm_msg = document.getElementById('unm_msg');
	eml_msg = document.getElementById('eml_msg');
	pwd_msg = document.getElementById('pwd_msg');
	cnf_msg = document.getElementById('cnf_msg');
	gnd_msg = document.getElementById('gnd_msg');
	city_msg = document.getElementById('city_msg');

	theForm = document.forms[0];
}

function setAllActions(){
	username.onblur = userNameOnBlur;
	username.onfocus = userNameOnFocus;

	email.onblur = emailOnBlur;
	email.onfocus = emailOnFocus;

	password.onblur = passwordOnBlur;
	password.onfocus = passwordOnFocus;

	confirm_password.onblur = confirmPasswordOnBlur;
	confirm_password.onfocus = confirmPasswordOnFocus;

	male.onclick = female.onclick = genderOnSelect;

	city.onfocus = cityOnFocus;
	city.onchange = cityOnChange;

	theForm.onsubmit = validateForm;
}

function validateForm(){
	var flag = false;
	
	var rs1 = userNameOnBlur();
	var rs2 = emailOnBlur();
	var rs3 = passwordOnBlur();
	var rs4 = confirmPasswordOnBlur();
	var rs5 = cityOnFocus();
	var rs6 = cityOnChange();

	alert(rs1+' - '+rs2+' - '+rs3+' - '+rs4+' - '+rs5+' - '+rs6);

	if(rs1&&rs2&&rs3&&rs4&&rs5&&rs6){
		flag = true;
	}

	return flag;
}

function cityOnChange(){
	var flag = true;
	if(city.value==0){
		city_msg.style.display = 'inline';
		flag = false;
	}else{
		city_msg.style.display = 'none';
	}

	return flag;
}

function genderOnSelect(){
	gnd_msg.style.display = 'none';
}

function cityOnFocus(){
	var flag = true;
	if(!(male.checked||female.checked)){
		gnd_msg.style.display = 'inline';
		flag = false;
	}

	return flag;
}

function confirmPasswordOnBlur(){
	var flag = true;
	if(password.value!=confirm_password.value){
		cnf_msg.style.display = 'inline';
		flag = false;
	}

	return flag;
}

function confirmPasswordOnFocus(){
	cnf_msg.style.display = 'none';
}

function passwordOnBlur(){
	var flag = true;
	if(!password.value){
		pwd_msg.style.display = 'inline';
		pwd_msg.innerHTML = 'Password is required';
		flag = false;
	}else if(password.value.length<6||password.value.length>10){
		pwd_msg.style.display = 'inline';
		pwd_msg.innerHTML = 'Password must be >5 and <11';
	}

	return flag;
}

function passwordOnFocus(){
	pwd_msg.style.display = 'none';
}

function emailOnBlur(){
	var flag = true;
	if(!email.value){
		eml_msg.style.display = 'inline';
		flag = false;
	}	

	return flag;
}

function emailOnFocus(){
	eml_msg.style.display = 'none';
}

function userNameOnFocus(){
	unm_msg.style.display = 'none';
}

function userNameOnBlur(){
	var flag = true;
	if(!username.value){
		unm_msg.style.display = 'inline';
		flag = false;
	}

	return flag;
} 


