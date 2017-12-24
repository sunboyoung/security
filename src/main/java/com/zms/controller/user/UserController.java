package com.zms.controller.user;


import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

//类上面使用@Api
@Api(value = "用户controller", tags = "用户操作接口")
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(UserController.class.toString());

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(User user) {
        userService.createUser(user);
        return user.toString();
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(user.getUsername());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(Boolean.TRUE);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            logger.info(e.toString());
        } catch (IncorrectCredentialsException e) {
            logger.info(e.toString());
        } catch (ExcessiveAttemptsException e) {
            // TODO: handle exception
            logger.info(e.toString());
            System.out.println("您的账号被锁定了");
        } catch (AuthenticationException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            logger.info(e.toString());
        }
        return subject.isAuthenticated() ? "redirect:/index.jsp" : "/b";
    }

    @RequiresRoles("admin")
    @RequiresAuthentication
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }

}
