/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

/**
 *
 * @author marco
 */
public class Esempio {
    
    /*
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    HttpSession session = httpRequest.getSession();
 
    if (session.getAttribute(FacebookAuthConfig.OAUTH_TOKEN)==null) {
            FacebookAuthConfig facebookConfig = session.getFacebookConfiguration();
 
            String redirectURL = httpRequest.getRequestURL().toString();
            String code = StringUtils.noNullAndTrim(request.getParameter("code"));
            if (code.length()==0) {
                String tokenReqUrl = "https://graph.facebook.com/oauth/authorize?client_id="+facebookConfig.getAppID()+
                                     "&redirect_uri="+redirectURL;
                httpResponse.sendRedirect(tokenReqUrl);
                return;
            }
 
            String tokenUrl = "https://graph.facebook.com/oauth/access_token?client_id="+facebookConfig.getAppID()+
                             "&redirect_uri="+redirectURL+"&code="+code+"&client_secret="+facebookConfig.getAppSecret();
 
            DefaultWebRequestor webRequestor = new DefaultWebRequestor();
            Response fbresponse = webRequestor.executeGet(tokenUrl);
            String rawAccessToken = new String(fbresponse.getBody());
 
            String accessToken;
            if (rawAccessToken.indexOf("&") > -1) {
                rawAccessToken = rawAccessToken.split("&")[0];
            }
            accessToken = rawAccessToken.split("=")[1];
            session.setAttribute(FacebookAuthConfig.OAUTH_TOKEN, accessToken);
            User user = null;
 
            FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
            int attempt = 0;
            do {
                attempt++;
                log.info("* Fetching single objects *");
                try {
                    user = facebookClient.fetchObject("me", User.class);
                    logger.info("User name: " + user.getName());
                } catch (Exception e) {
                     if (attempt==1) {
                        log.warn("Error while quering data to Facebook service. Try again..");
                        continue;
                     } else {
                        log.info("Request error. Can't retrieve data from facebook service.");
                        httpResponse.sendRedirect(errorPage);
                        return;	
                    }
                }
                break;
            } while (true);
 
            session.setAttribute(FACEBOOK_USER_OBJ, user);
            session.setAttribute(OAUTH_TOKEN, accessToken);                    
    }
}
    */
}
