package cn.gofl.system.domain;

import lombok.Data;

import java.util.List;

/**
 * 用户信息
 */
@Data
public class UserDO {

    private String userId;

    private String username;

    private String realname;

    private char sex;

    private Long birth;

    private String password;

    private String email;

    private String mobile;

    private String mobile2;

    private String liveAddr;

    private String province;

    private String city;

    private String district;

    private String deptId;

    private String picUrl;

    /**
     * 用户状态
     * 0:禁用 1：正常
     */
    private char status;

    private long createTime;

    private long modifyTime;

}
