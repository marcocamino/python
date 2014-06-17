/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;







import java.awt.Desktop;
import java.net.URI;


/**
 *
 * @author marco
 */
public class UserAgent {
    
    public void postGoogle() {
        try {
            Desktop.getDesktop().browse(new URI("http://www.lastampa.it"));
        } catch (Exception e) {
            System.out.println("eccezione dalla classe desktop");
        }
    }
    
}
