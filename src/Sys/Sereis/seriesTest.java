/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Sereis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class seriesTest {

    public static void main(String[] args) {

        try {
            // Get Gson object
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // read JSON file data as String
            //String fileData = "{\"status\":\"1\",\"message\":\"Success\",\"data\":[{\"id\":\"1\",\"series\":\"1000-1900\"},{\"id\":\"2\",\"series\":\"2000-2900\"},{\"id\":\"3\",\"series\":\"3000-3900\"}]}";
            String fileData = new String(Files.readAllBytes(Paths
                    .get("employee.txt")));
            // parse json string to object
            seriesData series = gson.fromJson(fileData, seriesData.class);

            // print object data
            //System.out.println("\n\nEmployee Object\n\n" + series);
            ArrayList<Map> test = series.getProperties();
            Iterator<Map> itr = test.iterator();
            while (itr.hasNext()) {
                Map<String, String> temp = itr.next();
                System.out.println(temp.get("series"));
            }
            //Map<String, String> tests = test.get(0);
            //System.out.println(tests.get("series"));
            System.exit(0);
            // create JSON String from Object
//		String jsonEmp = gson.toJson(emp);
//		System.out.print(jsonEmp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
