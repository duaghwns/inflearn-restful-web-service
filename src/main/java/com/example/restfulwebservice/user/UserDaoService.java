package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

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
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
    }
}
