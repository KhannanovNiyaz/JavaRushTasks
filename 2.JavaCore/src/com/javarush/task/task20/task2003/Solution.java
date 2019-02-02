package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties proper = new Properties();


    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);

        FileOutputStream outputStream = new FileOutputStream(fileName);
        save(outputStream);
//        Solution solution = new Solution();
//        solution.load(inputStream);
      //  solution.save(outputStream);
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
       // Properties prop = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            proper.put(entry.getKey(), entry.getValue());
        }
        proper.store(outputStream, null);
        outputStream.flush();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        proper.load(inputStream);
        Set<String> set = proper.stringPropertyNames();
        for (String s : set) {
            properties.put(s, proper.getProperty(s));
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
