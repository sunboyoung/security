package com.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import sun.rmi.runtime.Log;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 *
 * @Author zms
 * @CreateTime 2017年11月30日下午5:31:32
 * @Description 此处是继承于hashed的方法 默认实现了shiro的权限管理
 *
 */

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String,AtomicInteger> passwordRetryCache;
    private Logger logger = Logger.getLogger(RetryLimitHashedCredentialsMatcher.class.getName());
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {

        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
        // TODO: handle exception

    }

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = token.getPrincipal().toString();
        AtomicInteger retryCount = passwordRetryCache.get(userName);
        if (null == retryCount) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(userName,retryCount);

        }
        if (retryCount.incrementAndGet() > 5) {
            logger.info("userName: " + userName + " tried to login more than ");
            throw new ExcessiveAttemptsException("userName: " + userName + " tried to login more than ");
        }

        boolean matches = super.doCredentialsMatch(token, info);

        if (matches){
            passwordRetryCache.remove(userName);
        }

        return matches;
    }
}