/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author ander
 */
public class ServerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 8000; 
        API api = new API(port); 
        api.start();
    }
    
}
