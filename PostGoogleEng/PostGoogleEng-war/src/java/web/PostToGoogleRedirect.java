/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author marco
 */
public class PostToGoogleRedirect {
 
  public void postGoogle() {
 
    try {
 
	String url = "http://www.exprova123.appspot.com/web";
        //String url = "http://127.0.0.1:20080/web";
        int status =0;
        String newUrl ="";
        String cookies = "";
        URL neWobj = null;
        HttpURLConnection conn2 = null;
        
        
	URL obj = new URL(url);
	HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        String data = "chiave1=valore1&chiave2=valore2\r\n";//corpo della richiesta
        conn.setDoOutput(true);//abilita la scrittura
        conn.setRequestMethod("POST");
	conn.setReadTimeout(5000);
	conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
	conn.addRequestProperty("User-Agent", "Mozilla");
	conn.addRequestProperty("Referer", "google.com");
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);//scrittura del content
        wr.flush();
        wr.close();
	System.out.println("Request URL ... " + url);
 
	boolean redirect = false;
 
	// normally, 3xx is redirect
	status = conn.getResponseCode();
	if (status != HttpURLConnection.HTTP_OK) {
		if (status == HttpURLConnection.HTTP_MOVED_TEMP
			|| status == HttpURLConnection.HTTP_MOVED_PERM
				|| status == HttpURLConnection.HTTP_SEE_OTHER)
		redirect = true;
	}
 
	System.out.println("Response Code ... " + status);
 
	if (redirect) {
 
		// get redirect url from "location" header field
		newUrl = conn.getHeaderField("Location");
                neWobj = new URL(newUrl);
		// get the cookie if need, for login
		cookies = conn.getHeaderField("Set-Cookie");
 
		// open the new connnection again
		conn2 = (HttpURLConnection) neWobj.openConnection();
		conn2.setRequestProperty("Cookie", cookies);
		conn2.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
		conn2.addRequestProperty("User-Agent", "Mozilla");
		conn2.addRequestProperty("Referer", "google.com");
                

                status = -1;
		System.out.println("Redirect to URL : " + newUrl);
                status = conn2.getResponseCode();
 
	}
 /*
	BufferedReader in = new BufferedReader(
                              new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer html = new StringBuffer();
 
	while ((inputLine = in.readLine()) != null) {
		html.append(inputLine);
	}
	in.close();
 
	System.out.println("URL Content... \n" + html.toString());*/
	System.out.println("Done");
 
    } catch (Exception e) {
	e.printStackTrace();
    }
 
  }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
