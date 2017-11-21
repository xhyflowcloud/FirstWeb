package com.jd.xiahongyun.Dao;

import com.jd.xiahongyun.Base.*;

public interface UserDao {

    void register(User user);

    User validateUser(Login login);
}
