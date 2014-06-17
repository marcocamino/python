package web;

//import com.sun.xml.rpc.processor.util.StringUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restfb.DefaultWebRequestor;
import com.restfb.WebRequestor.Response;

public class MainServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String clientId = "250827445119511";
        String clientSecret = "a2d124f9892d000aadbb0d83925251c6";
        
        //Richiede il code.
        String redirectURL = request.getRequestURL().toString();
        String code = request.getParameter("code");
        if ((code == null)) {
            //String tokenReqUrl = "https://graph.facebook.com/oauth/authorize?redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_id=250827445119511";
            //String tokenReqUrl = "https://graph.facebook.com/oauth/authorize?redirect_uri=" + redirectURL + "&client_id=250827445119511";
            String tokenReqUrl = "https://graph.facebook.com/oauth/authorize?redirect_uri=" + redirectURL + "&client_id=" + clientId;
            response.sendRedirect(tokenReqUrl);
            return;
        } 
        System.out.println("Sono nella servlet code:");
        System.out.println(code);
        
        // scambia il code con l'access token
        String str = "https://graph.facebook.com/oauth/access_token?client_id=" + clientId + "&redirect_uri=" + redirectURL + "&client_secret=" + clientSecret + "&code=" + code; 
        //String str = "https://graph.facebook.com/oauth/access_token?client_id=" + clientId + "&redirect_uri=" + redirectURL + "&client_secret=a2d124f9892d000aadbb0d83925251c6&code=" + code; 
        //String str = "https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=" + redirectURL + "&client_secret=a2d124f9892d000aadbb0d83925251c6&code=" + code; 
        //String str = "https://graph.facebook.com/oauth/access_token?client_id=250827445119511&redirect_uri=http://localhost:8080/PostGoogleEng-war/MainServlet&client_secret=a2d124f9892d000aadbb0d83925251c6&code=" + code; 
        DefaultWebRequestor webRequestor = new DefaultWebRequestor();
        Response fbresponse = webRequestor.executeGet(str);
        String rawAccessToken = new String(fbresponse.getBody());
        String accessToken = rawAccessToken.split("&")[0];
        System.out.println("Sono nella servlet access token:");
        System.out.println(accessToken);

        String msg = "Io sono il msg javaEE";
        PostToGoogle postToGoogle = new PostToGoogle();
        postToGoogle.postGoogle(accessToken,msg);
        
        int i = 4;
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainServlet PostGoogleEengine at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
