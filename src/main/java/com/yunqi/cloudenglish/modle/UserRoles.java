package com.yunqi.cloudenglish.modle;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 13:52 2018/5/16
 * @版本 v1.0
 */
public enum  UserRoles {
    ADMIN(10,"ROLE_ADMIN"),USER(20,"ROLE_USER");

    private int id;
    private String name;

    UserRoles(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static UserRoles fromId(int id){
        for (UserRoles userRoles : UserRoles.values()) {
            if (userRoles.getId()==id){
                return userRoles;
            }

        }
        return null;
    }
}
