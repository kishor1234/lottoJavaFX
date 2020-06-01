/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.api;

/**
 *
 * @author asksoft
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class Send_HTTP_Post_Request {

    public static void main(String[] args) {
        try {
            Send_HTTP_Post_Request.call_me();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void call_me() throws Exception {
        URL url = new URL("http://server.newloto.lcl/?r=CAddUser");
        Map params = new LinkedHashMap<>();
        params.put("action", "adminBalance");
//        params.put("email", "helloworld@gmail.com");
//        params.put("CODE", 1111);
//        params.put("message", "Hello Post Test success");
        StringBuilder postData = new StringBuilder();
        for (Iterator it = params.entrySet().iterator(); it.hasNext();) {
            Map.Entry param = (Map.Entry) it.next();
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode((String) param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            sb.append((char) c);
        }
        String response = sb.toString();
        System.out.println(response);
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("origin- " + myResponse.getString("3"));
//        System.out.println("url- " + myResponse.getString("url"));
//        JSONObject form_data = myResponse.getJSONObject("form");
//        System.out.println("CODE- " + form_data.getString("CODE"));
//        System.out.println("email- " + form_data.getString("email"));
//        System.out.println("message- " + form_data.getString("message"));
//        System.out.println("name" + form_data.getString("name"));
    }
}
