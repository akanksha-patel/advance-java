package elfunctions;

import javax.servlet.jsp.PageContext;

public class ELHelper{
	
	

	public static String elProcess(PageContext pageContext){

		String[] arr = (String[])pageContext.getServletContext().getAttribute("cities");
		
		String toSend = "<select name='cities'>";
		
		for(String str : arr){
			toSend = toSend + "<option>"+str+"</option>";
		}

		toSend = toSend + "</select>";

		return toSend;
	}	
}