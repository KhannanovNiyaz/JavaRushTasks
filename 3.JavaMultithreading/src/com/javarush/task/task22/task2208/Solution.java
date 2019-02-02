package com.javarush.task.task22.task2208;

import java.util.*;

/* 
{name=Ivanov, country=Ukraine, city=Kiev, age=null}
*/
public class Solution {
    public static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
//        Solution.getQuery(map);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder("");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                s.append(String.format("%s = '%s'", entry.getKey(), entry.getValue()));
                s.append(" and ");
//            s = s.append(entry.getKey()+ "'" + entry.getValue() + "'" + " and ");
            }
        }
        if(s.length()>=5)
            s.setLength(s.length()-5);
//        s.substring(0, s.lastIndexOf(" and "));
        return s.toString();
    }
}
