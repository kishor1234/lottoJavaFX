/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author asksoft
 */
public class singleResult {

    public static ArrayList<Map> singleResultJSONPrint(String data) throws Exception {
        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(data);
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj;
        String printPage = "";
        // getting firstName and lastName 
        String status = (String) jo.get("status");
        String Msg = (String) jo.get("message");
        //System.out.println(jo.get("data"));
        //System.exit(0);
        ArrayList<Map> wPoint = null;
        if (status.equals("1")) {
             wPoint = (ArrayList<Map>) jo.get("data");
            
        }
        return wPoint;
    }

    public static void main(String args[]) {
        try {
            String data = "{\"status\":\"1\",\"message\":\"Success\",\"data\":[{\"series\":\"1000-1900\",\"0\":\"38\",\"1\":\"2\",\"2\":\"7\",\"3\":\"91\",\"4\":\"46\",\"5\":\"71\",\"6\":\"70\",\"7\":\"18\",\"8\":\"63\",\"9\":\"84\"},{\"series\":\"2000-2900\",\"0\":\"91\",\"1\":\"3\",\"2\":\"16\",\"3\":\"37\",\"4\":\"99\",\"5\":\"97\",\"6\":\"25\",\"7\":\"36\",\"8\":\"19\",\"9\":\"20\"},{\"series\":\"3000-3900\",\"0\":\"76\",\"1\":\"47\",\"2\":\"16\",\"3\":\"29\",\"4\":\"5\",\"5\":\"61\",\"6\":\"13\",\"7\":\"68\",\"8\":\"67\",\"9\":\"30\"},{\"series\":\"4000-4900\",\"0\":\"77\",\"1\":\"72\",\"2\":\"29\",\"3\":\"59\",\"4\":\"14\",\"5\":\"81\",\"6\":\"10\",\"7\":\"43\",\"8\":\"19\",\"9\":\"95\"}]}";
            singleResult.singleResultJSONPrint(data);
        } catch (Exception ex) {
            Logger.getLogger(singleResult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
