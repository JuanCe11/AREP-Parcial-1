package edu.escuelaing.arep.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Client {

	public static void main(String[] args) throws Exception {
		readURL("http://localhost:4567/");
		readURL("http://localhost:4567/result?list=160%2C591%2C114%2C229%2C230%2C270%2C128%2C1657%2C624%2C1503");

	}

	/**
	 * Reads an reasponse from the server
	 * 
	 * @param as_site url to read
	 */
	private static void readURL(String as_site) {
		try {
			URL lu_URL = new URL(as_site);
			if (lu_URL != null) {
				URLConnection luc_connection = lu_URL.openConnection();
				if (luc_connection != null) {
					Map<String, List<String>> lm_headers = luc_connection.getHeaderFields();
					if (lm_headers != null) {
						Set<Map.Entry<String, List<String>>> entrySet = lm_headers.entrySet();
						
						System.out.println("----------HEADER----------");
						
						for (Map.Entry<String, List<String>> entry : entrySet) {
							String headerName = entry.getKey();
							if (headerName != null) {
								System.out.print(headerName + ":");
							}
							List<String> headerValues = entry.getValue();
							for (String value : headerValues) {
								System.out.print(value);
							}
							System.out.println("");
						}
						System.out.println("----------BODY----------");
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(luc_connection.getInputStream()));
						String inputLine = null;
						while ((inputLine = reader.readLine()) != null) {
							System.out.println(inputLine);
						}
						
						System.out.println("----------END----------\n");
					}
				}
			}
		} catch (IOException x) {
			System.err.println(x);
		}
	}

}
