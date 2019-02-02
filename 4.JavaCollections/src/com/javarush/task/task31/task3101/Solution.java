package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File dest = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, dest);
//        TreeSet<Path> set = new TreeSet<Path>(Comparator.comparing(Path::getFileName));
        ArrayList<File> set = new ArrayList<>();

        try (FileOutputStream fileWriter = new FileOutputStream(dest)) {
            Files.walkFileTree(path.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!Files.isDirectory(file) && (attrs.size() <= 50)) {
                        set.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            set.sort(new Comparator<File>() {
                @Override
                public int compare(File first, File second) {
                    return first.getName().compareTo(second.getName());
                }
            });

            for (File setPath : set) {
                FileReader fileReader = new FileReader(setPath);
                while (fileReader.ready()) {
                    fileWriter.write(fileReader.read());
                }
                fileWriter.write(System.lineSeparator().getBytes());
                fileReader.close();
            }
        }
    }
}

/*
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и, если понадобится,
 FileUtils.isExist).
2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".

Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по
 имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
* */