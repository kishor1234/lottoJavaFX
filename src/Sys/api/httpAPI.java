/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.api;

import Sys.errorLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class httpAPI {

    public static String api_url = "http://api.omlotto.com/";
    //public static String api_url = "http://api.newloto.lcl/";
    public static errorLog erLog = new errorLog();

    public static void main(String[] args) {
        Map params = new LinkedHashMap<>();
        params.put("action", "adminBalance");
        // String data = httpAPI._jsonRequest("?r=CAddUser", params);
        // System.out.println(data);
    }

    private static String _postRequest(String urls, Map params) {
        try {
            URL url = new URL(httpAPI.api_url + urls);
            //params.put("action", "adminBalance");
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
            return response;
            //System.out.println(response);
        } catch (Exception ex) {

            erLog.write(ex);
        }
        return null;
    }

    public static String _jsonRequest(String urls, String jsonInputString) {
        try {
            StringBuilder response;
            URL url = new URL(httpAPI.api_url + urls);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            //String jsonInputString = "{\"3\":\"624321.35\",\"1\":\"1\",\"2\":1,\"0\":\"6\"}";
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                //System.out.println(response.toString());
            }
            return response.toString();

        } catch (Exception e) {
            erLog.write(e);
        }
        return null;
    }
}
