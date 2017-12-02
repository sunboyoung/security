package com.shiro.myrealm;

import org.apache.shiro.authc.*;

public class MyRealm2 {
    public String getName() {
        return "myRealm1";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof  AuthenticationToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getCredentials();
        String password = new String((char[])token.getCredentials()); //得到密码
        if(!"zhang".equals(username)) {
            throw new UnknownAccountException(); //如果用户名错误
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username+"@163.com", password, getName());
    }
}
