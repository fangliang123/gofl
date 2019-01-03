package cn.gofl.system.config;

import cn.gofl.system.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 权限配置
 * created by fl on 2019-01-02
 */

@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    private static final String LOGIN_URL = "/login";
    private static final String SUCCESS_URL = "/index";
    private static final String UNAUTH_URL = "/403";

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
    /*@Value("${spring.cache.type}")
    private String cacheType ;*/
    /*@Value("${server.session-timeout}")
    private int tomcatTimeout;*/

    @Bean
    public ShiroFilterFactoryBean filterFactory (SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        filterFactory.setSecurityManager(securityManager);
        filterFactory.setLoginUrl(LOGIN_URL);
        filterFactory.setSuccessUrl(SUCCESS_URL);
        filterFactory.setUnauthorizedUrl(UNAUTH_URL);
        filterFactory.setFilterChainDefinitionMap(FilterChain.getChain());
        return filterFactory;
    }


    /**
     * 凭证匹配器
     * @return
     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher () {
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        matcher.setHashAlgorithmName("md5");
//        matcher.setHashIterations(2);
//        return matcher;
//    }

    @Bean
    public UserRealm userRealm () {
        UserRealm userRealm = new UserRealm();
//        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    @Bean
    public SecurityManager securityManager () {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }
}
