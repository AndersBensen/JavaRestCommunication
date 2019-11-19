/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Context;

/**
 *
 * @author ander
 */
public class APIHandler {
    private Data data; 
    public APIHandler() {
        data = new Data(); 
    }
    
    public void getData(Context context) {
        System.out.println("Route called: getData");
        
        ArrayList<Integer> listData = data.getData(); 
        
        ObjectMapper mapper = new ObjectMapper();
        if (listData != null ){
            try {
                context.json(mapper.writeValueAsString(listData));
            } catch (JsonProcessingException e) {
                context.status(500); 
                e.printStackTrace();
            }
        } else {
            context.status(500); 
        }
    }
    
    public void addData(Context context) {
        System.out.println("Route called: addData");
        try {
            Integer val = Integer.parseInt(context.pathParam("value"));
            data.addToList(val);
        } catch(NumberFormatException e) {
            context.status(400);
        }
    }
}
