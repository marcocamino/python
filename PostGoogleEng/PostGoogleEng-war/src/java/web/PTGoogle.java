/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import static com.google.common.net.HttpHeaders.USER_AGENT;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author marco
 */
public class PTGoogle {
    
    public void postGoogle() {
        try{
            //canvas:https://www.exprova123.appspot.com/
            //String url = "https://graph.facebook.com/oauth/authorize?client_id=250827445119511&redirect_uri=http://www.exprova123.appspot.com/web";
            //String url = "https://graph.facebook.com/oauth/authorize?client_id=250827445119511&redirect_uri=http://www.exprova123.appspot.com/web&response_type=code%20token";
            //https://graph.facebook.com/oauth/authorize?redirect_uri=http%3A%2F%2Fwww.exprova123.appspot.com%2Fweb&client_id=250827445119511
            
            //questa stringa se inserita nel browser posta il messaggio.
            String str = "https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.exprova123.appspot.com/";
            String strUrl ="https://www.facebook.com/dialog/oauth?app_id=250827445119511&next=http://www.exprova123.appspot.com/web";
            
            URL urlObj = new URL(str);
            HttpURLConnection firstCon = (HttpURLConnection) urlObj.openConnection();
            int responseCodeFirstCon = firstCon.getResponseCode();
            
            
            String url = "https://graph.facebook.com/oauth/authorize?redirect_uri=http%3A%2F%2Fwww.exprova123.appspot.com%2Fweb&client_id=250827445119511";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
            // optional default is GET
            con.setRequestMethod("GET");
 
            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);
 
            int responseCode = con.getResponseCode(); 
            String code = con.getRequestProperty("code");
            String codet = con.getRequestProperty("code&token");
            String mess = con.toString();//getRequestProperty("code");
            String newUrl = con.getHeaderField("Location");
            int u = 8;
                
        }catch (MalformedURLException e) {}   
        catch (IOException e) {
            int i = 10;
        }        
                
    }
    
}
