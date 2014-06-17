<%-- 
    Document   : login
    Created on : 27-mag-2014, 13.52.22
    Author     : marco

    BackUp del login.jsp

--%>


<%@page import="static com.google.common.net.HttpHeaders.USER_AGENT"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.awt.Desktop"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World da login! prima script</h1>
        
        <script>
            // This is called with the results from from FB.getLoginStatus().
            function statusChangeCallback(response) {
              console.log('statusChangeCallback');
              console.log(response);
              // The response object is returned with a status field that lets the
              // app know the current login status of the person.
              // Full docs on the response object can be found in the documentation
              // for FB.getLoginStatus().
              if (response.status === 'connected') {
                // Logged into your app and Facebook.
                testAPI();
              } else if (response.status === 'not_authorized') {
                // The person is logged into Facebook, but not your app.
                document.getElementById('status').innerHTML = 'Please log ' +
                  'into this app.';
              } else {
                // The person is not logged into Facebook, so we're not sure if
                // they are logged into this app or not.
                document.getElementById('status').innerHTML = 'Please log ' +
                  'into Facebook.';
              }
            }

            // This function is called when someone finishes with the Login
            // Button.  See the onlogin handler attached to it in the sample
            // code below.
            function checkLoginState() {
              FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
              });
            }

            window.fbAsyncInit = function() {
            FB.init({
              appId      : '{your-app-id}',
              cookie     : true,  // enable cookies to allow the server to access 
                                  // the session
              xfbml      : true,  // parse social plugins on this page
              version    : 'v2.0' // use version 2.0
            });

            // Now that we've initialized the JavaScript SDK, we call 
            // FB.getLoginStatus().  This function gets the state of the
            // person visiting this page and can return one of three states to
            // the callback you provide.  They can be:
            //
            // 1. Logged into your app ('connected')
            // 2. Logged into Facebook, but not your app ('not_authorized')
            // 3. Not logged into Facebook and can't tell if they are logged into
            //    your app or not.
            //
            // These three cases are handled in the callback function.

            FB.getLoginStatus(function(response) {
              statusChangeCallback(response);
            });

            };

            // Load the SDK asynchronously
            (function(d, s, id) {
              var js, fjs = d.getElementsByTagName(s)[0];
              if (d.getElementById(id)) return;
              js = d.createElement(s); js.id = id;
              js.src = "//connect.facebook.net/en_US/sdk.js";
              fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

            // Here we run a very simple test of the Graph API after login is
            // successful.  See statusChangeCallback() for when this call is made.
            function testAPI() {
              console.log('Welcome!  Fetching your information.... ');
              FB.api('/me', function(response) {
                console.log('Successful login for: ' + response.name);
                document.getElementById('status').innerHTML =
                  'Thanks for logging in, ' + response.name + '!';
              });
            }
        </script>
        <h1>Hello World da login! dopo script</h1>        
        <!--
          Below we include the Login Button social plugin. This button uses
          the JavaScript SDK to present a graphical Login button that triggers
          the FB.login() function when clicked.
        -->        
        
        
        <fb:login-button size="large" scope="public_profile,email" onlogin="checkLoginState();">
            login facebook
        </fb:login-button>

        <div id="status">
        </div>   
        
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
        String str = "https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogle/index.html";
        
        //"C:\Users\marco\AppData\Local\Mozilla Firefox\firefox.exe"
        
        /*
        try {
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.exprova123.appspot.com/");
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://www.facebook.com/dialog/oauth?client_id=250827445119511&redirect_uri=https://www.facebook.com/connect/login_success.html");
            //Desktop.getDesktop().browse(new URI("http://www.lastampa.it"));
        } catch (Exception e) {
            int u = 4;
            
        }
        
        */
        /* 
        URL urlObj = new URL(str);
        HttpURLConnection firstCon = (HttpURLConnection) urlObj.openConnection();
        int responseCodeFirstCon = firstCon.getResponseCode();
        String mess1 = firstCon.toString();
        String code1 = firstCon.getRequestProperty("code");
        */
        /* 
        String url = "https://graph.facebook.com/oauth/authorize?redirect_uri=https://www.exprova123.appspot.com/&client_id=250827445119511";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
        // optional default is GET
        con.setRequestMethod("GET");
 
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
 
        int responseCode = con.getResponseCode(); 
        String code = con.getRequestProperty("code");
        String codet = con.getRequestProperty("code&token");
        String mess2 = con.toString();
        String newUrl = con.getHeaderField("Location");
        int u = 8;
        
        */
        
        /*
        try {
            //Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=https://www.exprova123.appspot.com/&client_id=250827445119511");
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_id=250827445119511");
        } catch (Exception e) {
            int d = 4;
            
        }
        */
        
        
        //scambio il code per l'access token
        try {
            Runtime.getRuntime().exec("C:\\Users\\marco\\AppData\\Local\\Mozilla Firefox\\firefox.exe https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/prima.html&client_secret=a2d124f9892d000aadbb0d83925251c6&code=AQDUNSnGx3tPBo0Vk7VRbXIyiOeh1G3FgClAsu3YllthKhXWgVFPIhPVotG1IPztqFjdpZmdaL5gKrVGT3VulSv07vTXZtdhjclsk_Stq1Fbn1Ll8UrPjkJ50j05sjqZ_WPsERYf8Huao-dNvJEZQRYYWuv3_Jry4p7ivkH3_Lsd477pA8dIe8yNSlHWAWmd4_dTThBh6o2bPXE-HafSy3PXendV8Qrrguru_IDxfmfXDTYDBXXPmiJDEktweNwDwgc8WC6Gi2P2eAtgRL0lELBa8sY19IkTE5_H9aoqEB6FDxh1Yx5EXZ8ogWtQL8a-E_I#_=_");
        } catch (Exception e) {
            int dd = 4;            
        }        
        
        
        %>
        <h1>Hello World2!</h1>
    </body>
</html>
