package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.UsersView;

/*
* 6. В методе onShowAllUsers() класса Controller должен вызываться метод refresh у объекта usersView
* с параметром model.getModelData() после вызова метода loadUsers().
* */

public class Controller {
    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void setUsersView(UsersView usersView) {
       this.usersView = usersView;
    }
}
