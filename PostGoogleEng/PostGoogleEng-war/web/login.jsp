<%-- 
    Document   : login
    Created on : 27-mag-2014, 13.52.22
    Author     : marco
--%>







<%@page import="static com.google.common.net.HttpHeaders.USER_AGENT"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.awt.Desktop"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URI"%>
<%@page import="com.restfb.DefaultWebRequestor"%>
<%@page import="com.restfb.WebRequestor.Response"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World da login...</h1>

        <!--
            redirect_uri=https://www.exprova123.appspot.com/
        
        con queste due stringhe non da errori 200ok 200ok
        String str = "https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.exprova123.appspot.com/";
        String url = "https://graph.facebook.com/oauth/authorize?redirect_uri=https://www.exprova123.appspot.com/&client_id=250827445119511";
        
        prove
        String str = "https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.facebook.com/connect/login_success.html";
        String str = "https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=http://www.facebook.com/connect/login_success.html&response_type=token&display=popup&scope=publish_stream";
        da provare
        		String redirectUrl = "http://localhost:8080/Test/index.sec";
		String returnValue = "https://www.facebook.com/dialog/oauth?client_id=" 
				+ appId + "&redirect_uri=" + redirectUrl 
				+ "&scope=email,user_birthday&state=" + sessionId;
        
        -->     
    
        <% 
        
        //"C:\Users\marco\AppData\Local\Mozilla Firefox\firefox.exe"
        
        
         //ok   
           
        try {
            //posta direttamente il messggio.
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.exprova123.appspot.com/");
            
            //mi apre il browser per loggarmi, ma devo aver cancellato i cookies, mi ritorna il code
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.facebook.com/connect/login_success.html");
        } catch (Exception e) {
            int u = 4;
            
        }
        
        


        /*
        //mi ritorna il code nell'url
        try {
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=https://www.exprova123.appspot.com/&client_id=250827445119511");
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_id=250827445119511");
        } catch (Exception e) {
            int d = 4;
            
        }
      */
        
        
        //scambio il code per l'access token
       /*
        try {
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_secret=a2d124f9892d000aadbb0d83925251c6&code=AQCvwVH2AKoDzXj9pDF2PMhi4v5HOD7MLdDqXwLo4Q6EuC4AZRNf-yXeulVqKtAhoSKfW4md9p_dSU2jvbeKaT8cgedMzxQ6qcap5HAJ8MWQUwsEOVdKq65q2H9P4KFFMVlHGoQXdzfGOy_x7p6QsruI16omKY4mZH-v2hcXYUpeLwF0Iy24Yn_j3R_rrk38iw1CIJ7zfNfsN6-97iTu7Of0XBwpEJde6tRhUvp9CUYvn-H3TptRbmohdO4bnbpmKBFZz8S8FPZL_AQIy2xUXzvzULMG88cP3lSDdfDj1UX5C6j2WOySxY0S25Yi1w4MPqk#_=_");
        } catch (Exception e) {
            int dd = 4;            
        }        
       */
 
            
         /*
        //mi ritorna code, alla servlet -- ok
        try {
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_id=250827445119511");
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_id=250827445119511");
        } catch (Exception e) {
            int d = 4;
            
        }
         */
            
           /*
        //scambio il code per l'access token alla servlet -- ok
        try {
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_secret=a2d124f9892d000aadbb0d83925251c6&code=AQCvwVH2AKoDzXj9pDF2PMhi4v5HOD7MLdDqXwLo4Q6EuC4AZRNf-yXeulVqKtAhoSKfW4md9p_dSU2jvbeKaT8cgedMzxQ6qcap5HAJ8MWQUwsEOVdKq65q2H9P4KFFMVlHGoQXdzfGOy_x7p6QsruI16omKY4mZH-v2hcXYUpeLwF0Iy24Yn_j3R_rrk38iw1CIJ7zfNfsN6-97iTu7Of0XBwpEJde6tRhUvp9CUYvn-H3TptRbmohdO4bnbpmKBFZz8S8FPZL_AQIy2xUXzvzULMG88cP3lSDdfDj1UX5C6j2WOySxY0S25Yi1w4MPqk#_=_");
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_secret=a2d124f9892d000aadbb0d83925251c6&code=AQBIWlIi9cm9HmOsJb4sE6o2O8f-fbxad6pkZQLNLV7P30d0KVwqLYwVxQTzBi-bszTflrY84Kf2qOMdh3tWBr302pdw63T_uP3tbXY8x9Hl9gztufOXoB_dNVbZWx-kVu9yuQEcIo_dEyQAbk8ZjNH9kR61fFCBxkpAPo6y1eZiTCA-jZFNla8lSwtOvW_3_JEd2LGIYUT5F4slgdmP8yJVcne_kxEUEypRh0iRtknu5NX5HwWjzkY52gxLykudRMr12u-1l5ptfdYpM-egAy2JbZXm2ucU96Luxqd5gn2zKyQ2ZxmblLvWh5tCnTKvgFA#_=_");
        } catch (Exception e) {
            int dd = 4;            
        }   */         
        /*
        String strFirst ="https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_id=250827445119511";    
        DefaultWebRequestor webRequestor1 = new DefaultWebRequestor();
        Response fbresponse1 = webRequestor1.executeGet(strFirst);
        String code = new String(fbresponse1.getBody()); 
        int j = 6;
            
        */
        /*
        String str = "https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_secret=a2d124f9892d000aadbb0d83925251c6&code=AQDxOyAbDjNrrNPa4Fqoe6oC6MT2PKBtHWD-uJ3PlYjqG1IwCFd-_ZvFse1XYdt2-egWfWi91xkiOPp_X7foENbVodWClW0CJxom_7KqpNMWftDRqApQxsiJMo53gMTOpbXENEeRDyqpoIKDBm9e9a_GihamMWGx_2fEpJ-M6Swe5otpR-2lM4aFOt6zGA2p2cUXQJARVUA0k05su7OU19PaqLTFLIyNQrHmLLOEjVCjjwxd1BeXxAxQivf4DP0ZvybvS_MXIHTg_uoZN_HBHgrp6i9Sagop5jY7HqKthQqBI_tjpxs5cB1W64654eUYuII";
        DefaultWebRequestor webRequestor = new DefaultWebRequestor();
        Response fbresponse = webRequestor.executeGet(str);
        String rawAccessToken = new String(fbresponse.getBody());
        int i = 3;
         */      
        %>
        <h1>Hello World2!</h1>
    </body>
</html>
