package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

/*
* 3. Реализуй логику метода refresh:
3.1. Выведи в консоль фразу "All users:".
3.2. Выведи в консоль всех пользователей, которые есть в modelData.
Перед каждым пользователем сделай отступ в виде табуляции.
3.3. В конце выведи визуальный разделитель данных
===================================================


* */

public class UsersView implements View {
    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        List<User> modelUsers = modelData.getUsers();
        System.out.println("All users:");
        for (User modelUser : modelUsers) {
            System.out.println("\t" + modelUser);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
}
