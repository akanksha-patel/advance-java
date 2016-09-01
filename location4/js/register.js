window.onload = initAll;

var email, err_msg, em_box, sug;

function initAll(){
	getAllElements();
	setAllActions();
}

function getAllElements(){
	email = document.getElementById('email');
	err_msg = document.getElementById('err_msg');
	em_box = document.getElementById('em_box');
	sug = document.getElementById('sug');
}

function setAllActions(){
	email.onblur = checkEmail;
	email.onfocus = function(){
								err_msg.innerHTML = '';
								sug.style.display = 'block';
							};
}

var chkEmlReq = null;
function checkEmail(){
	err_msg.innerHTML = '';
	sug.style.display = 'none';
	chkEmlReq = createRequestObject();

	if(chkEmlReq){
		chkEmlReq.open('GET', 'checkemail.do?email='+email.value, true);
		chkEmlReq.onreadystatechange = getResult;	
		chkEmlReq.send(null);
	}
}

function getResult(){
	if(chkEmlReq.readyState==4){
		if(chkEmlReq.status==200){
			if(chkEmlReq.responseText){
				err_msg.innerHTML = chkEmlReq.responseText;
			}
		}
	}
}