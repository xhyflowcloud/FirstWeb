package com.jd.xiahongyun.Dao;

import com.jd.xiahongyun.Base.Login;
import com.jd.xiahongyun.Base.User;

import java.util.HashSet;
import java.util.Set;


public class UserDaoImpl implements UserDao {
    public final static Set<User> userSet = new HashSet<User>();
    public void register(User user) {
        userSet.add(user);
    }

    public User validateUser(Login login) {

        for(User user: userSet) {
            if (user.getUsername().equals(login.getUsername()) && user.getPassword().trim().equals(login.getPassword().trim()))
                return user;
        }
        return null;
    }
}
