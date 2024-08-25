package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.javarush.task.task20.task2002.User.Country.RUSSIA;
import static com.javarush.task.task20.task2002.User.Country.UKRAINE;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/filinnimac/Documents/JavaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/file");
            InputStream inputStream = new FileInputStream("/Users/filinnimac/Documents/JavaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/file");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Donov");
            user1.setMale(true);
            user1.setBirthDate(new Date());
            user1.setCountry(RUSSIA);

            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (!users.isEmpty()) {
                for (User user : this.users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getBirthDate().getTime());
                    printWriter.println(user.isMale() ? "true" : "false");
                    printWriter.println(user.getCountry());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader( new InputStreamReader(inputStream));
            while (br.ready()) {
                User user = new User();
                user.setFirstName(br.readLine());
                user.setLastName(br.readLine());
                user.setBirthDate(new Date(Long.parseLong(br.readLine())));
                user.setMale(br.readLine().equals("true"));
                user.setCountry(User.Country.valueOf(br.readLine()));
                users.add(user);
            }
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
