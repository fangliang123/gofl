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

    /**
     * 过滤链
     * @return
     */
    public static LinkedHashMap<String, String> getChain (){
        filterChainDefinitionMap.put("/admin",ANON); // 主页
        filterChainDefinitionMap.put("/sys/user/listData",ANON); // 主页
        filterChainDefinitionMap.put("/test",ANON); // 测试
        //css js文件位置
        filterChainDefinitionMap.put("/common/bootstrap/**",ANON);
        filterChainDefinitionMap.put("/common/dist/**",ANON);
        filterChainDefinitionMap.put("/common/plugins/**",ANON);
        // logout path
        filterChainDefinitionMap.put("/logout",LOGOUT);
        filterChainDefinitionMap.put("/**", AUTHC);
        return filterChainDefinitionMap;
    }

}
