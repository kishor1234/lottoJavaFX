/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author asksoft
 */
public class invoceTest {

    public static void main(String[] args) {

        try {
            // Get Gson object
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String fileData = new String(Files.readAllBytes(Paths
                    .get("invoiceData.json")));
            // parse json string to object
            invoiceData inData = gson.fromJson(fileData, invoiceData.class);
            // print object data
            
            System.out.println("\n\nEmployee Object\n\n" + inData);
//            ArrayList<Map> print = inData.getPrintData();
//            Gson g = new Gson();
//            ArrayList<Map> aMap=g.toJson(print.get(0));
//            System.out.println(aMap);
//            for (int i = 0; i < 1; i++) {
//                Map<String, String> s = print.get(0);
//                for (Map.Entry<String, String> finas : s.entrySet()) {
//
//                    if (finas.getKey().equals("point")) {
//                        System.out.println(finas.getValue());
//                    }
//                }
//                //Map<Stir
//
//                //System.out.println(s.get(s2));
//            }

//            ArrayList<Map> test = series.getStatus();
//            Iterator<Map> itr = test.iterator();
//            while (itr.hasNext()) {
//                Map<String, String> temp = itr.next();
//                System.out.println(temp.get("status"));
//            }
            //Map<String, String> tests = test.get(0);
            //System.out.println(tests.get("series"));
            System.exit(0);
            // create JSON String from Object
//		String jsonEmp = gson.toJson(emp);
//		System.out.print(jsonEmp);
        } catch (IOException | JsonSyntaxException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
