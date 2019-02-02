package com.javarush.task.task31.task3110;
/*
0 - упаковать файлы в архив
1 - добавить файл в архив
2 - удалить файл из архива
3 - распаковать архив
4 - просмотреть содержимое архива
5 - выход
* */
public enum Operation {
    CREATE("упаковать файлы в архив"),
    ADD("добавить файл в архив"),
    REMOVE("удалить файл из архива"),
    EXTRACT("распаковать архив"),
    CONTENT("просмотреть содержимое архива"),
    EXIT("выход");

    private String comment;

    Operation(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
