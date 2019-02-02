package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            boolean hidden = Files.isHidden(Paths.get(pathToFile));
            boolean executable = Files.isExecutable(Paths.get(pathToFile));
            boolean directory = Files.isDirectory(Paths.get(pathToFile));
            boolean writable = Files.isWritable(Paths.get(pathToFile));
            fileData = new ConcreteFileData(hidden, executable, directory, writable);
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}

/*
ConcreteFileData(boolean hidden, boolean executable, boolean directory, boolean writable)

Почитай на вики про паттерн "Null Object".
Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.


Требования:
1. Конструктор Solution должен инициализировать поле fileData объектом ConcreteFileData.
2. Если в конструкторе Solution возникла ошибка, нужно инициализировать поле fileData объектом NullFileData.
3. Конструктор Solution должен корректно устанавливать значение поля hidden у объекта ConcreteFileData.
4. Конструктор Solution должен корректно устанавливать значение поля executable у объекта ConcreteFileData.
5. Конструктор Solution должен корректно устанавливать значение поля directory у объекта ConcreteFileData.
6. Конструктор Solution должен корректно устанавливать значение поля writable у объекта ConcreteFileData.
* */
