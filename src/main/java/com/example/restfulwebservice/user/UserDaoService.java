package com.example.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static long usersCount = 0;

    static {
        users.add(new User(++usersCount, "hojoon", new Date()));
        users.add(new User(++usersCount, "joonho", new Date()));
        users.add(new User(++usersCount, "sangjin", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(long id){
        for (User user : findAll()) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void save(User user){
        users.add(user);
    }




}
