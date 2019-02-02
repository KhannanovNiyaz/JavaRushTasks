package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        Path fileName = Paths.get(downloadDirectory.toString(), urlString.substring(urlString.lastIndexOf("/")));
        URL url = new URL(urlString);
        InputStream stream = url.openStream();
        Path tempFile = Files.createTempFile("", "");
        Files.copy(stream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.move(tempFile, fileName, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
        // implement this method
    }
}
