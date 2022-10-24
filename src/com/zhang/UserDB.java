package com.zhang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zph
 * @version 1.0
 */
public class UserDB {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"zhangsan","123",23));
        users.add(new User(2,"lisi","123",23));
        users.add(new User(3,"wuwang","123",43));
        users.add(new User(4,"hello","123",19));
        users.add(new User(5,"lican","123",25));
        users.add(new User(6,"xiehan","123",30));
    }
}
