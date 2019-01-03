package cn.gofl.system.domain;

import lombok.Data;

/**
 * 角色信息
 */
@Data
public class RoleDO {

    private String roleId;

    private String roleName;

    private String roleSign;

    private Integer roleSort;

    private char isAdmin;

    private char status;

    private String dataScope;

    private String remarks;

    private String creator;

    private long createTime;

    private String modifier;

    private long modifyTime;
}
