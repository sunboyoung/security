
package com.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class shiroTest {

    @Test
    public void runMyReam1() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1");
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            System.out.print("用户名为【" + token.getPrincipal() + "】不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.print("用户名为【 " + token.getPrincipal() + " 】密码错误！");
        } catch (LockedAccountException lae) {
            System.out.print("用户名为【" + token.getPrincipal() + " 】的账户锁定，请联系管理员。");
        } catch (DisabledAccountException dax) {
            System.out.print("用户名为:【" + token.getHost() + "】用户已经被禁用.");
        } catch (ExcessiveAttemptsException eae) {
            System.out.print("用户名为:【" + token.getHost() + "】的用户登录次数过多，有暴力破解的嫌疑.");
        } catch (ExpiredCredentialsException eca) {
            System.out.print("用户名为:【" + token.getHost() + "】用户凭证过期.");
        } catch (AuthenticationException ae) {
            System.out.print("用户名为:【" + token.getHost() + "】用户验证失败.");
        } catch (Exception e) {
            System.out.print("别的异常信息。。。。具体查看继承关系");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6.退出
        subject.logout();
    }


    @Test
    public void runMyReam2() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro/shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xz", "123");
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            System.out.print("用户名为【" + token.getPrincipal() + "】不存在");
        } catch (IncorrectCredentialsException ice) {
            System.out.print("用户名为【 " + token.getPrincipal() + " 】密码错误！");
        } catch (LockedAccountException lae) {
            System.out.print("用户名为【" + token.getPrincipal() + " 】的账户锁定，请联系管理员。");
        } catch (DisabledAccountException dax) {
            System.out.print("用户名为:【" + token.getHost() + "】用户已经被禁用.");
        } catch (ExcessiveAttemptsException eae) {
            System.out.print("用户名为:【" + token.getHost() + "】的用户登录次数过多，有暴力破解的嫌疑.");
        } catch (ExpiredCredentialsException eca) {
            System.out.print("用户名为:【" + token.getHost() + "】用户凭证过期.");
        } catch (AuthenticationException ae) {
            System.out.print("用户名为:【" + token.getHost() + "】用户验证失败.");
        } catch (Exception e) {
            System.out.print("别的异常信息。。。。具体查看继承关系");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6.退出
        subject.logout();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
