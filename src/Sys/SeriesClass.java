/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys;

import java.util.ArrayList;

/**
 *
 * @author asksoft
 */
public class SeriesClass {

    public static ArrayList<String> seriesTemp;//= new ArrayList<String>();

    public static ArrayList<ArrayList<String>> series = new ArrayList<ArrayList<String>>();

    public SeriesClass() {
        int offset = 99;
        int total_series = 90;
        int start = 1000;
        int ip = 1;
        seriesTemp = new ArrayList<String>();
        for (int i = 1; i <= total_series; i++) {
            String s = "" + start + "-";
            start = start + offset;
            s = s + "" + start;
            start++;
            seriesTemp.add(s);
            if (ip == 10) {
                ip = 0;
                series.add(seriesTemp);
                seriesTemp = new ArrayList<String>();
            }
            ip++;
        }
    }

//    public static void main(String[] arg) {
//        try {
//            SeriesClass sc = new SeriesClass();
//            int i = 0;
//            ArrayList<String> temp = new ArrayList<String>();
//            for (int j = 0; j < sc.series.size(); j++) {
//                temp = sc.series.get(j);
//                System.out.println(temp.size());
//                String t = temp.get(3);
//                Iterator litr = temp.listIterator();
//
//                System.out.println("\n Using list iterator");
//                while (litr.hasNext()) {
//                    System.out.println(litr.next());
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}
