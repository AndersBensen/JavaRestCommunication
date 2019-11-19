/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ander
 */
public class APIcaller {
    private int port; 
    private String ipAddress; 

    public APIcaller(int port, String ipAddress) {
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    
    public void addData(int data) {
        String routeUrl = "add-data/" + data; 
        writeToServer(routeUrl); 
    }
    
    public String getData() throws UnirestException {   
        String url = "get-data";
        String tmp = getFromServer(url); 
        return tmp; 
    }
    
    
    private String getFromServer(String routeUrl) throws UnirestException {
        String ipAddress = this.getIpAddress();
        int port = this.getPort();
        String url = "http://" + ipAddress + ":" + port + "/api/" + routeUrl;
        
        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            if(inet.isReachable(port)){
                HttpResponse res = Unirest.get(url).asString();
                String body = Unirest.get(url).asString().getBody(); 

                if (res.getStatus() == 200) {
                    return body;
                }
            }
            System.out.println("GNode did not respond on url: " + url);
            return "";

        } catch (UnirestException ex) {
            ex.getMessage();
            return "";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    private boolean writeToServer(String routeUrl) {
        String ipAddress = this.getIpAddress();
        int port = this.getPort();
        String url = "http://" + ipAddress + ":" + port + "/api/" + routeUrl;

        try {
            InetAddress inet = InetAddress.getByName(ipAddress);
            if(inet.isReachable(port)){
                HttpResponse res = Unirest.post(url).asString();

                if (res.getStatus() == 200) {
                    return true;
                }
            }
            System.out.println("GNode did not respond on url: " + url);
            return false;

        } catch (UnirestException ex) {
            ex.getMessage();
            return false;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
