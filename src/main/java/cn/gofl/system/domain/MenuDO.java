package cn.gofl.system.domain;

import lombok.Data;

@Data
public class MenuDO {

    private String menuId;

    private String menuName;

    private String parentId;

    private String type;

    private String href;

    private String icon;

    private Integer order;

    private String prems;

    private String creator;

    private long createTime;

    private String modifier;

    private long modifyTime;
}
