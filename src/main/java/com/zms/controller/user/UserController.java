package com.zms.controller.user;


import com.zms.pojo.user.User;
import com.zms.service.user.UserService;
import com.zms.to.page.Page;
import com.zms.to.responseBean.ResponseBean;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
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
    @ResponseBody
    public ResponseBean login(User user) {
        System.out.println(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(Boolean.TRUE);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            logger.info(e.toString());
            return new ResponseBean(ResponseBean.FAIL, "用户名/密码错误");
        } catch (IncorrectCredentialsException e) {
            logger.info(e.toString());
            return new ResponseBean(ResponseBean.FAIL, "用户名/密码错误");
        } catch (ExcessiveAttemptsException e) {
            // TODO: handle exception
            logger.info(e.toString());
            return new ResponseBean(ResponseBean.FAIL, "您的账户已被锁定十分钟,请稍后再试");
        } catch (AuthenticationException e) {
            // 其他错误，比如锁定，如果想单独处理请单独catch处理
            logger.info(e.toString());
        }

        return new ResponseBean(ResponseBean.SUCCESS, "登录成功");
    }

    @RequestMapping(value = "getUserList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getUserList(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        List<Map<String, Object>> list = userService.getUserListByPage(page);
        return new ResponseBean(ResponseBean.SUCCESS, "查询成功", list, page.getTotalCount());
    }

    @RequestMapping("/hello2")
    public String hello2() {
        SecurityUtils.getSubject().checkRoles("admin");
        return "success";
    }

}
