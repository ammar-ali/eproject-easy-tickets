package ticketbook.util;

public class JavascriptCode {

	public static String getSubmitFormByName(String nameForm){
		return "if(navigator.appName == 'Netscape')" +
				"{" +
				"document."+nameForm+".submit();" +
				"}" +
				"else{" +
				"document.forms('"+nameForm+"').submit();" +
				"}";
	}
	
	public static String getChangeActionForm(String idForm,String action){
		return "if(navigator.appName == 'Netscape')" +
				"{" +
				"document.getElementById('"+idForm+"').action='" +action+"';"+
				"}" +
				"else{" +
				"document.getElementById('"+idForm+"').action='" +action+"';"+
				"}";
	}
	
	public static String getChangeMethodForm(String idForm,String method){
		return "if(navigator.appName == 'Netscape')" +
				"{" +
				"document.getElementById('"+idForm+"').method='" +method+"';"+
				"}" +
				"else{" +
				"document.getElementById('"+idForm+"').method='" +method+"';"+
				"}";
	}
}
