package com.zms.controller.user;


import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//类上面使用@Api
@Api(value = "用户controller", tags = "用户操作接口")
@Controller
@RequestMapping(value = "/views")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(User user) {
        user.setLocked(false);
        user.setSalt("123");
        userService.createUser(user);
        return user.toString();
    }




}
