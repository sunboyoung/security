package com.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @Author zms
 * @CreateTime 2017年11月30日下午5:31:32
 * @Description 此处是继承于hashed的方法 默认实现了shiro的权限管理
 *
 */

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String,AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {

        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
        System.out.println("缓存初始化成功");
        // TODO: handle exception

    }

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = token.getPrincipal().toString();
        System.out.println("获取token中的用户名称:");
        System.out.println(userName);
        System.out.println("获取判断成功的次数:");
        AtomicInteger retryCount = passwordRetryCache.get(userName);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(userName,retryCount);
        }

        if (retryCount.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);

        if (matches){
            passwordRetryCache.remove(userName);
        }

        return matches;
    }
}