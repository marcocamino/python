package web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author marco
 */
public class PostToGoogle {
   
    public void postGoogle(){
        try{
            URL url = new URL("http://www.exprova123.appspot.com/web");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String data = "access_token=CAADkIFDEKhcBAKKf7rCT8NkBeGipuiZCq03xHG9HkYg4ZABuC281FLrchsiZAjEH9XprH0ZAlyTB7F6lTmwNZBBALfKZADMDwZArSFhYHwxcoYUKtQf9mbIa3sUOEQpjqeoaxMYHQ7tyEFzVFlip8HsIIir6WouQwZBwExQLbwvx46Qo78mlEttmFalILcZCDuNIZD&chiave1=da java&chiave2=application\r\n";//corpo della richiesta
            connection.setDoOutput(true);//abilita la scrittura
            connection.setRequestMethod("POST");//settaggio del metodo
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(data);//scrittura del content
            wr.flush();
            wr.close();   
            int responseCode = connection.getResponseCode(); 
            int h = 0;

        }catch (MalformedURLException e) {}   
        catch (IOException e) {
            int i = 10;
        } 
    }

    public void postGoogle(String access_token, String msg){
        try{
            URL url = new URL("http://www.exprova123.appspot.com/web");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //String data = access_token + "&chiave1=da servlet java2E&chiave2=Application\r\n";//corpo della richiesta
            String data = access_token + "&chiave1=" + msg + "&chiave2=Application\r\n";//corpo della richiesta
            connection.setDoOutput(true);//abilita la scrittura
            connection.setRequestMethod("POST");//settaggio del metodo
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(data);//scrittura del content
            wr.flush();
            wr.close();   
            int responseCode = connection.getResponseCode(); 
            int h = 0;

        }catch (MalformedURLException e) {}   
        catch (IOException e) {
            int i = 10;
        } 
    }    
}
