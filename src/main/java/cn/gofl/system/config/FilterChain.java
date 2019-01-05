package cn.gofl.system.config;

import java.util.LinkedHashMap;

/**
 * shiro过滤链
 */
public class FilterChain  {

    private static final String ANON = "anon";
    private static final String AUTHC = "authc";
    private static final String LOGOUT = "logout";

    private static LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    public static LinkedHashMap<String, String> getChain (){
        filterChainDefinitionMap.put("/test",ANON); // 测试
        filterChainDefinitionMap.put("/bower_components/**",ANON);
        filterChainDefinitionMap.put("/build/**",ANON);
        filterChainDefinitionMap.put("/dist/**",ANON);
        filterChainDefinitionMap.put("/plugins/**",ANON);
        filterChainDefinitionMap.put("/logout",LOGOUT);
        filterChainDefinitionMap.put("/**", AUTHC);
        return filterChainDefinitionMap;
    }

}
