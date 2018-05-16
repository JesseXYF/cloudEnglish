package com.yunqi.cloudenglish.generate.model;

public class RoleUser {
    private String id;

    private String userid;

    private Integer roleid;

    public RoleUser(String id, String userid, Integer roleid) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
    }

    public RoleUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}