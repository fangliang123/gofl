package cn.gofl.common.utils;

import cn.gofl.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.security.Principal;
import java.util.List;

/**
 * shiro工具类
 */
public class ShiroUtil {

    /**
     * subject
     * @return
     */
    public static Subject getSubject () {
        return SecurityUtils.getSubject();
    }

    /**
     * subject--userDO
     * @return
     */
    public static UserDO getUser () {
        Object obj = getSubject().getPrincipal();
        return (UserDO) obj;
    }

    /**
     * 获取user-id
     * @return
     */
    public static String getUid () {
        String uid = getUser().getUserId();
        return uid;
    }

    /**
     * 获取principal
     * @return
     */
    public static List<Principal> getPrincipals () {
        return null;
    }
}
