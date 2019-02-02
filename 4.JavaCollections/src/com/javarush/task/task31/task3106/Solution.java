package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        Set<String> set = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            set.add(args[i]);
        }

        List<InputStream> arrayInputStream = new ArrayList<>();
        for (String s : set) {
            try {
                arrayInputStream.add(new FileInputStream(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        /*
        * byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null)
        {
            int count;
            while ((count = zipInStream.read(buf)) != -1)
            {
                fileOutStream.write(buf, 0, count);
            }
        }
        * */

        try (ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(Collections.enumeration(arrayInputStream)));
             OutputStream outZip = new FileOutputStream(args[0])) {
            while ((zipIn.getNextEntry()) != null) {
                byte[] buf = new byte[1024 * 1024];
                int count;
                while ((count = zipIn.read(buf)) != -1) {
                    outZip.write(buf, 0, count);
                }
            }
//            Files.copy(zipIn, Paths.get(args[0]), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/*
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main,
 начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.
* */