package elfunctions;

public class ELHelper{
	
	static String[] arr = {"Jbp", "Bhp", "Gwl", "Rip"};

	public static String elProcess(){
		
		String toSend = "<select name='cities'>";
		
		for(String str : arr){
			toSend = toSend + "<option>"+str+"</option>";
		}

		toSend = toSend + "</select>";

		return toSend;
	}	
}