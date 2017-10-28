package com.example.wangweijun.glide_config_test.model;

/**
 * Created by wangweijun on 2017/10/22.
 */

public class Repo {
    int id;
    String name;
    Owner owner;

    @Override
    public String toString() {
        return "id:"+id+", name:"+name;
    }

    class Owner {
        int id;
        String login;
    }
}
