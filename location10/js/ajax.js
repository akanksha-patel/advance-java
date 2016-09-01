function createRequestObject(){
	var requestObj = null;

	try{
		requestObj = new XMLHttpRequest();
	}catch(e){
		try{
			requestObj = new ActiveXObject('Msxml2.XMLHTTP');
		}catch(e){
			try{
				requestObj = new ActiveXObject('Microsoft.XMLHTTP');
			}catch(e){
				alert("Please install an updated browser");
			}
		}
	}

	return requestObj;
}