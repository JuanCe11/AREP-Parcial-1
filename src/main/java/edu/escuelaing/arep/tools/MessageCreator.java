package edu.escuelaing.arep.tools;

public class MessageCreator {
	
	
	public static String createJsonMessage(String message) {
		String ls_response;
		
		ls_response = "\"message\":\""
				+message
				+"\"";
		
		return ls_response;
		
	}
	
	public static String createJsonVar(String as_var,double ad_value) {
		String ls_response;
		
		ls_response = "\""+ as_var +"\":"
				+ad_value
				+"";
		return ls_response;
	}
	
	
	public static String createJsonList(double[] ada_param) {
		String ls_res;
		ls_res = "\"list\":{";
		for (int i = 0; i < ada_param.length; i++) {
			ls_res += "\""+i+"\":"+ada_param[i]+"";
			if (i < ada_param.length - 1)
				ls_res += ",";
		}
		
		ls_res += "}"; 
		return ls_res;
	}
	
	public static String createJson(String as_content) {
		String ls_response;
		
		ls_response = "{"+as_content+"}";
		
		return ls_response;
		
	}

}
