package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {
    private static long countOfDIR = 0;
    private static long countOfFiles = 0;
    private static long size = 0;

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(System.in)) {
            Path dir = Paths.get(sc.nextLine());
            if (Files.isDirectory(dir)) {
//                long countOfDIR = Files.walk(dir).filter(Files::isDirectory).count();
//                long countOfFiles = Files.walk(dir).filter(Files::isRegularFile).count();
//                long size = Files.walk(dir).filter(Files::isRegularFile).map(Path::toFile).mapToLong(File::length).sum();

                Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        if (Files.isDirectory(dir)){
                            countOfDIR++;
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        if (Files.isRegularFile(file)) {
                            countOfFiles++;
                            size += attrs.size();
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });


                System.out.println("Всего папок - " + (countOfDIR - 1));
                System.out.println("Всего файлов - " + countOfFiles);
                System.out.println("Общий размер - " + size);
            } else {
                System.out.println(dir + " - не папка");
            }
        }
    }
}

/*
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. Используй только классы и методы из пакета java.nio.
4. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
6. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
* */
