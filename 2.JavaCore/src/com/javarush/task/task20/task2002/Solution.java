package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

            for (User user : users) {
                printWriter.println(user.getFirstName());
                printWriter.println(user.getLastName());
                printWriter.println(sdf.format(user.getBirthDate()));
                printWriter.println(user.isMale());
                printWriter.println(user.getCountry());
            }
            printWriter.flush();
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//            for (User user : users) {
//                writer.write(user.getFirstName() == null ? "null" : user.getFirstName().concat(" "));
//                writer.write(user.getLastName() == null ? "null" : user.getLastName().concat(" "));
//                writer.write(user.getBirthDate() == null ? "null" : Long.toString(user.getBirthDate().getTime()).concat(" "));
//                writer.write(Boolean.toString(user.isMale()).concat(" "));
//                writer.write(user.getCountry() == null ? "null" : user.getCountry().getDisplayedName().concat(System.lineSeparator()));
//            }
//            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

            String firstName;
            while ((firstName = reader.readLine()) != null) {
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(reader.readLine());
                user.setBirthDate(sdf.parse(reader.readLine()));
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                user.setCountry(User.Country.valueOf(reader.readLine()));
                users.add(user);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String fileString;
//            User currentUser;
//            while ((fileString = reader.readLine()) != null) {
//                String[] buf = fileString.split(" ");
//                currentUser = new User();
//                if (!buf[0].equals("null")) currentUser.setFirstName(buf[0]);
//                if (!buf[1].equals("null")) currentUser.setLastName(buf[1]);
//                if (!buf[2].equals("null")) currentUser.setBirthDate(new Date(Long.parseLong(buf[2])));
//                currentUser.setMale(Boolean.parseBoolean(buf[3]));
//                if (!buf[1].equals("null")) currentUser.setLastName(buf[1]);
//                switch (buf[4]) {
//                    case "Ukraine":
//                        currentUser.setCountry(User.Country.UKRAINE);
//                        break;
//                    case "Russia":
//                        currentUser.setCountry(User.Country.RUSSIA);
//                        break;
//                    case "Other":
//                        currentUser.setCountry(User.Country.OTHER);
//                        break;
//                }
//                this.users.add(currentUser);
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
