package com.example.administrador.pvsegalmex.api;

import android.content.Context;

import com.example.administrador.pvsegalmex.utils.ReferencesDB;

public class User {
    private Integer user = null;
    private static final String LOGIN_DATA = "user_info";
    private ReferencesDB rDB;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
        update();
    }

    public User(Context context) {
        rDB = new ReferencesDB(context);
    }

    public User() {
    }

    public void update() {
        rDB.putObject(LOGIN_DATA, this);
    }

    public void clear() {
      user = null;
    }

    public static User build(Context context) {
        ReferencesDB rDB = new ReferencesDB(context);
        String LOGIN_DATA = "user_info";
        try {
            return (User) rDB.getObject(LOGIN_DATA, User.class);
        } catch (NullPointerException e) {
            return new User(context);
        }
    }
}
