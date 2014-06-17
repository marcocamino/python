/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*

	String url = "http://www.google.com/search?q=httpClient";
 
	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);
 
	// add request header
	request.addHeader("User-Agent", USER_AGENT);
	HttpResponse response = client.execute(request);
 
	System.out.println("Response Code : " 
                + response.getStatusLine().getStatusCode());
 
	BufferedReader rd = new BufferedReader(
		new InputStreamReader(response.getEntity().getContent()));
 
	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
*/

package web;

import static com.google.common.net.HttpHeaders.USER_AGENT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 *
 * @author marco
 */
public class ClientHpptGoogle {
    public void postGoogle() {
        try{
            String strUrl ="https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.facebook.com/connect/login_success.html";
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(strUrl);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);
            HttpResponse response = client.execute(request);
            
            System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));            
            
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
		result.append(line);
            }
            int i = 7;
        }catch(MalformedURLException e) {}   
        catch (IOException e) {
            int i = 10;
        }    
    }
}
