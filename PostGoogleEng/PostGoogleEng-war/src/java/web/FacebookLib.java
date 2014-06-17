/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient.AccessToken;
import static java.lang.System.out;

/**
 *
 * @author marco
 */
public class FacebookLib extends DefaultFacebookClient{
    
    String FACEBOOK_APP_ID = "250827445119511";
    String FACEBOOK_APP_SECRET = "a2d124f9892d000aadbb0d83925251c6";
    
    public void postGoogle() {
        //AccessToken accessToken =new DefaultFacebookClient().obtainAppAccessToken(FACEBOOK_APP_ID, FACEBOOK_APP_SECRET);
        //AccessToken accessToken = new DefaultFacebookClient().obtainExtendedAccessToken(FACEBOOK_APP_ID, FACEBOOK_APP_SECRET);
        //out.println("My application access token: " + accessToken);
        //out.println("Scadenza: " + accessToken.getExpires().toString());
        
        AccessToken accessToken = this.obtainAppAccessToken(FACEBOOK_APP_ID, FACEBOOK_APP_SECRET);
        this.accessToken = accessToken.getAccessToken();
        out.println("My application access token: " + accessToken);
        
        int i = 6;
        //http://www.exprova123.appspot.com/web?access=250827445119511|HtVIZSD8mbJFA1pN4dUUPJCWQuQ
    }//http://www.exprova123.appspot.com/web?access=CAACEdEose0cBADwR0j1PiSTzToeHYZClXeltDRntSPWjqEzSdOBhtkYNde98P9ybYz2teP3TyfnyYvPO8zkrgqjuvYlwLIfq6MAvRugZBygPoLKjRYoYZCxxEXZADIyeDvjC4l089DJz66R1FqJ9BDXQ9Hsl5XRaimRryHYqBBQremn7c6UNWH1rahCZBkcuxwhLXhn9rWgZDZD
}//http://www.exprova123.appspot.com/web?access=CAADkIFDEKhcBACEKhJaFyuRvevAKvc6tVFXE3NWQrNQvAeM7erxFJZB7k60dAkzFOW7iEzuC2wrZCXW2qCMabfW4YxSrFPRF3cWfYr1NuYArtncmZBlsB47zByM9ZAiD41xLrnmztry2HVFEu8whsTzksUzWciYVtEhlRMqFcZCNhNOQsDzSTfbNcysrh5ysaLkHaHC7vPQZDZD
