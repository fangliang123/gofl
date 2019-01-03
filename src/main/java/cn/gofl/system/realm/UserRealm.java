package cn.gofl.system.realm;

import cn.gofl.common.config.ApplicationContextRegister;
import cn.gofl.system.dao.UserMapper;
import cn.gofl.system.domain.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义用户realm
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String ((char[]) token.getCredentials());
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        UserMapper userMapper = ApplicationContextRegister.getBean(UserMapper.class);
        //查询用户信息
        UserDO user = userMapper.list(param).get(0);
        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        //账号、密码不匹配
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或者密码不正确");
        }
        //账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
