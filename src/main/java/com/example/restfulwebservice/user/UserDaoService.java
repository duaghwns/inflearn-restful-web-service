package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "hojoon", LocalDateTime.now() ,"pass1","999999-9999999"));
        users.add(new User(++usersCount, "joonho", LocalDateTime.now(),"pass2","888888-8888888"));
        users.add(new User(++usersCount, "sangjin", LocalDateTime.now(), "pass3", "777777-7777777"));
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

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }
}
