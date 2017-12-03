package com.zms.controller.user;


import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
                user.getPassword());
        String error = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
            System.out.println(error);
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
            System.out.println(error);

        } catch (ExcessiveAttemptsException e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println("你被抓住了");
        } catch (AuthenticationException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }
        return user.toString();
    }

}
