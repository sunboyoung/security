package com.zms.controller.user;



import org.springframework.web.bind.annotation.RequestMapping;
import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;



@Controller

@RequestMapping(value = "/userAction")
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    @ResponseBody
    public void addUser(User user){
        System.out.println(user.getName());

        boolean isAdd=us.addUser(user);
        if(isAdd){
            System.out.println("添加成功");
            System.out.println(System.getProperty("user.dir"));
        }else{
            System.out.println("添加失败");
        }
    }
    @RequestMapping(value="/addUserList",method = RequestMethod.POST)
    @ResponseBody
    public void addUserList(){
        List<User> user=new ArrayList<User>(3);
        int i=0;
        for (User u:user) {
            i++;
            u.setName("zms"+i);
            u.setAge(12+i);
        }

    }
}
