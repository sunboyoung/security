package com.zms.dao.user;

import com.zms.pojo.user.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public boolean addUser(User  user);//添加用户
    public boolean delUser(String name);//删除用户
    public boolean addUserList();//批量添加用户
}
