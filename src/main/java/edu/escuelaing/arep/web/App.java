package edu.escuelaing.arep.web;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.tools.Calculator;
import edu.escuelaing.arep.tools.MessageCreator;
import edu.escuelaing.arep.tools.StringReader;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

/**
 * Class in charge of starting the service.
 *
 */
public class App {
	
	/**
	 * Main class that starts the main thread of the service.
	 * 
	 * @param args String array
	 */
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
        
        get("/", (req, res) -> {
            Map<String, Object> lm_model = new HashMap<String, Object>();
            lm_model.put("mean", 0);
            lm_model.put("desvest", 0);
            lm_model.put("valid",true);
            return new ModelAndView(lm_model, "index.vm");
        }, new VelocityTemplateEngine());
        
        
        get("/result", (req, res) -> {
        	res.type("application/json");
        	return resultData(req, res);
        	});

	}
	
	/**
	 * Specifies the port on which the service will run.
	 * 
	 * @return The port where the service will be run.
	 */
	public static int getPort() {    
		if (System.getenv("PORT") != null)
		{            
			return Integer.parseInt(System.getenv("PORT"));      
		} 
		return 4567; 
	}
	
	/**
	 * Method in charge of generating the values of the mean and the standard deviation.
	 * 
	 * @param am_model Data that will be passed to the template.
	 * @param ar_req Request received by the server
	 * @param ar_res Server response.
	 * @return Returns if it was possible to calculate the data with the information entered.
	 */
	private static String resultData(Request ar_req, Response ar_res){
		String ls_values;
		String ls_res;
		String ls_aux;
		boolean lb_resp;
		
		ls_values = ar_req.queryParams("list");
		lb_resp = validList(ls_values);
		
		if (lb_resp) {
			double[] lda_numbers;
			double[] lda_res;
			double ld_res;
        	
        	
        	lda_numbers = StringReader.convertArray(ls_values);
        	lda_res = Calculator.bubbleSort(lda_numbers);
        
    		ls_res = MessageCreator.createJsonList(lda_res);
    		
    		ld_res = Calculator.mean(lda_numbers);
    		ld_res = (double) Math.round(ld_res * 100) / 100;
    		ls_aux = MessageCreator.createJsonVar("mean", ld_res);
    		
    		ls_res += " , " + ls_aux;
    		
    		ld_res = Calculator.standardDeviation(lda_numbers);
    		ld_res = (double) Math.round(ld_res * 100) / 100;
    		ls_aux = MessageCreator.createJsonVar("desvest", ld_res);
    		
    		ls_res += " , " + ls_aux;
    		
    		ld_res = Calculator.sum(lda_numbers);
    		ls_aux = MessageCreator.createJsonVar("sum", ld_res);
    		
    		ls_res += " , " + ls_aux;  		
   		
		}
		else
		{
			ls_res = MessageCreator.createJsonMessage("INVALID VALUES");
		}
		
		ls_res = MessageCreator.createJson(ls_res);
		
		return ls_res;
	}
	
	/**
	 * Validate if a string is valid to calculate the values.
	 * 
	 * @param as_list String to validate.
	 * @return if the string is valid
	 */
	private static boolean validList(String as_list) {
		String[] lsa_parts;
		boolean lb_valid;
		
		lsa_parts = as_list.split(",");
		lb_valid = true;
		
		for (int i = 0; i < lsa_parts.length; i++) {
			try{
				Double.parseDouble(lsa_parts[i]);
			}catch(Exception e){
				lb_valid = false;
			}
		}
		return lb_valid;
	}
	
}