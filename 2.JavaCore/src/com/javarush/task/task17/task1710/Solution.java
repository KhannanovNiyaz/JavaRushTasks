package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990

Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец
списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по
 формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }


    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);


        //  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //   String s = reader.readLine();
        switch (args[0]) {

            case "-c":
                Date date = format.parse(args[3]);
                //String name = reader.readLine();
                // String sex = reader.readLine();
                // String dateIn = reader.readLine();
                if (args[2].toLowerCase().equals("ж")) {
                    // allPeople.add(Person.createFemale(args[1], inputDate.format(new Date(args[3])));
                    allPeople.add(Person.createFemale(args[1], date));
                    // System.out.println(allPeople.lastIndexOf(allPeople));
                    System.out.println(allPeople.size() - 1);
                } else if (args[2].toLowerCase().equals("м")) {
                    allPeople.add(Person.createMale(args[1], date));
                    //System.out.println(allPeople.lastIndexOf(allPeople));
                    System.out.println(allPeople.size() - 1);
                }
                break;

            case "-u":
                Date dateUpdate = format.parse(args[4]);
                //  int id = Integer.parseInt(reader.readLine());
                //  String nameNew = reader.readLine();
                //  String sexNew = reader.readLine();
                //   String dateInNew = reader.readLine();
                if (args[3].toLowerCase().equals("ж")) {
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], dateUpdate));
                } else if (args[3].toLowerCase().equals("м")) {
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], dateUpdate));
                }
                break;

            case "-d":
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
                //  allPeople.set(Integer.parseInt(args[1]), person);
                // int idDel = Integer.parseInt(reader.readLine());
                //  allPeople.set(Integer.parseInt(args[1]), Person.createFemale(null, null));
                //  allPeople.set(Integer.parseInt(args[1]), null);
                break;

            case "-i":
                SimpleDateFormat outDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                //int idPrint = Integer.parseInt(reader.readLine());
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                        + (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE) ? "ж" : "м") + " " +
                        outDate.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
                break;
        }

    }
}
