window.onload = initAll;

function initAll(){
	getAllElements();

	setAllActions();
}

var unm_box, unm_edit, unm_cancel;
function getAllElements(){
	unm_box = document.getElementById('unm_box');
	unm_edit = document.getElementById('unm_edit');
	unm_cancel = document.getElementById('unm_cancel');
}

function setAllActions(){
	unm_edit.onclick = setUnmEditable;
}

var unmVal = null;
function setUnmEditable(){
	/*
	var inp = document.createElement('input');
	inp.id = 'unm_txt';
	inp.value = unm_box.innerHTML;
	unm_box.innerHTML = '';
	unm_box.appendChild(inp);*/
	unmVal = unm_box.innerHTML;
	unm_box.innerHTML = '<input type="text" id="unm_txt" value="'+unmVal+'" />';
	unm_edit.innerHTML = 'Save';
	unm_edit.onclick = saveUserName;
	unm_cancel.style.display = 'inline';
	unm_cancel.onclick = cancelNameUpdate;
}

function cancelNameUpdate(){
	unm_box.innerHTML = unmVal;
	unm_edit.innerHTML = 'Edit';
	unm_edit.onclick = setUnmEditable;
	unm_cancel.style.display = 'none';
}

var unmUpdReq = null;
var unm_txt = null;
function saveUserName(){
	unmUpdReq = createRequestObject();
	//alert(escape(unm_txt.value));
	if(unmUpdReq){
		unm_txt = document.getElementById('unm_txt'); 
		unmUpdReq.open('POST', 'update_user_name.do', true);
		unmUpdReq.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
		unmUpdReq.onreadystatechange = showUserNameChange;
		unmUpdReq.send('username='+escape(unm_txt.value));
	}
}

function showUserNameChange(){
	alert(unmUpdReq.readyState+" +++ "+unmUpdReq.status);
	if(unmUpdReq.readyState==4){
		if(unmUpdReq.status==200){
			
			var resp = unmUpdReq.responseText;
			
			if(resp=='done'){
				unm_box.innerHTML = unm_txt.value;
				unm_edit.innerHTML = 'Edit';
				unm_edit.onclick = setUnmEditable;
			}else if(resp=='not_done'){
				
			}else if(resp=='session_expire'){
				window.location = 'showlogin.do';
			}
		}
	}
}