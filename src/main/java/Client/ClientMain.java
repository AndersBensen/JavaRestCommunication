/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;


/**
 *
 * @author ander
 */
public class ClientMain {
    public static void main(String[] args) throws UnirestException {
        int port = 8000; 
        String ipAddress = "localhost";
        APIcaller apiCaller = new APIcaller(port, ipAddress);
        
        String s = apiCaller.getData(); 
        System.out.println(s);
        apiCaller.addData(5000); 
        String s2 = apiCaller.getData();
        System.out.println(s2);
    }  
}
