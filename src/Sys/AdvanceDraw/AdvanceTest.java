/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.AdvanceDraw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class AdvanceTest {

    public static void main(String[] args) {

        try {
            // Get Gson object
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // read JSON file data as String
            String fileData = "{\"status\":\"1\",\"message\":\"Success\",\"data\":[{\"id\":\"20\",\"stime\":\"14:45:00\",\"etime\":\"15:00:00\",\"status\":\"0\"},{\"id\":\"21\",\"stime\":\"15:00:00\",\"etime\":\"15:15:00\",\"status\":\"0\"},{\"id\":\"22\",\"stime\":\"15:15:00\",\"etime\":\"15:30:00\",\"status\":\"0\"},{\"id\":\"23\",\"stime\":\"15:30:00\",\"etime\":\"15:45:00\",\"status\":\"0\"},{\"id\":\"24\",\"stime\":\"15:45:00\",\"etime\":\"16:00:00\",\"status\":\"0\"},{\"id\":\"25\",\"stime\":\"16:00:00\",\"etime\":\"16:15:00\",\"status\":\"0\"},{\"id\":\"26\",\"stime\":\"16:15:00\",\"etime\":\"16:30:00\",\"status\":\"0\"},{\"id\":\"27\",\"stime\":\"16:30:00\",\"etime\":\"16:45:00\",\"status\":\"0\"},{\"id\":\"28\",\"stime\":\"16:45:00\",\"etime\":\"17:00:00\",\"status\":\"0\"},{\"id\":\"29\",\"stime\":\"17:00:00\",\"etime\":\"17:15:00\",\"status\":\"0\"},{\"id\":\"30\",\"stime\":\"17:15:00\",\"etime\":\"17:30:00\",\"status\":\"0\"},{\"id\":\"31\",\"stime\":\"17:30:00\",\"etime\":\"17:45:00\",\"status\":\"0\"},{\"id\":\"32\",\"stime\":\"17:45:00\",\"etime\":\"18:00:00\",\"status\":\"0\"},{\"id\":\"33\",\"stime\":\"18:00:00\",\"etime\":\"18:15:00\",\"status\":\"0\"},{\"id\":\"34\",\"stime\":\"18:15:00\",\"etime\":\"18:30:00\",\"status\":\"0\"},{\"id\":\"35\",\"stime\":\"18:30:00\",\"etime\":\"18:45:00\",\"status\":\"0\"},{\"id\":\"36\",\"stime\":\"18:45:00\",\"etime\":\"19:00:00\",\"status\":\"0\"},{\"id\":\"37\",\"stime\":\"19:00:00\",\"etime\":\"19:15:00\",\"status\":\"0\"},{\"id\":\"38\",\"stime\":\"19:15:00\",\"etime\":\"19:30:00\",\"status\":\"0\"},{\"id\":\"39\",\"stime\":\"19:30:00\",\"etime\":\"19:45:00\",\"status\":\"0\"},{\"id\":\"40\",\"stime\":\"19:45:00\",\"etime\":\"20:00:00\",\"status\":\"0\"},{\"id\":\"41\",\"stime\":\"20:00:00\",\"etime\":\"20:15:00\",\"status\":\"0\"},{\"id\":\"42\",\"stime\":\"20:15:00\",\"etime\":\"20:30:00\",\"status\":\"0\"},{\"id\":\"43\",\"stime\":\"20:30:00\",\"etime\":\"20:45:00\",\"status\":\"0\"},{\"id\":\"44\",\"stime\":\"20:45:00\",\"etime\":\"21:00:00\",\"status\":\"1\"},{\"id\":\"45\",\"stime\":\"21:00:00\",\"etime\":\"21:15:00\",\"status\":\"0\"},{\"id\":\"46\",\"stime\":\"21:15:00\",\"etime\":\"21:30:00\",\"status\":\"0\"},{\"id\":\"47\",\"stime\":\"21:30:00\",\"etime\":\"21:45:00\",\"status\":\"0\"},{\"id\":\"48\",\"stime\":\"21:45:00\",\"etime\":\"22:00:00\",\"status\":\"0\"},{\"id\":\"49\",\"stime\":\"22:00:00\",\"etime\":\"22:15:00\",\"status\":\"0\"}]}";
//            String fileData = new String(Files.readAllBytes(Paths
//                    .get("employee.txt")));
            // parse json string to object
            AdvanceData series = gson.fromJson(fileData, AdvanceData.class);

            // print object data
            //System.out.println("\n\nEmployee Object\n\n" + series);
            ArrayList<Map> test = series.getProperties();
            Iterator<Map> itr = test.iterator();
            while (itr.hasNext()) {
                Map<String, String> temp = itr.next();
                System.out.println(temp.get("id")+"="+temp.get("etime"));
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
