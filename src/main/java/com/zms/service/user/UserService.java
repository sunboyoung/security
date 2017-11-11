package com.zms.service.user;

import com.zms.dao.user.UserDao;
import com.zms.pojo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    private UserDao dao;

    @Transactional
    public boolean addUser(User user){
        boolean isAdd=dao.addUser(user);
        return isAdd;
    }
    @Transactional
    public boolean delUser(String name){
        boolean isDel=dao.delUser(name);
        return isDel;
    }
}
