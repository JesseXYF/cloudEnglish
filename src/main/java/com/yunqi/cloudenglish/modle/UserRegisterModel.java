package com.yunqi.cloudenglish.modle;

/**
 * @描述:
 * @版权: Copyright (c) 2018
 * @创建人 Jesse Xue
 * @创建时间 17:36 2018/5/14
 * @版本 v1.0
 */
public class UserRegisterModel {
    private String identity;

    private String username;

    private String password;

    private String grade;

    public UserRegisterModel() {
    }

    private UserRegisterModel(Builder builder) {
        setIdentity(builder.identity);
        setUsername(builder.username);
        setPassword(builder.password);
        setGrade(builder.grade);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserRegisterModel copy) {
        Builder builder = new Builder();
        builder.identity = copy.getIdentity();
        builder.username = copy.getUsername();
        builder.password = copy.getPassword();
        builder.grade = copy.getGrade();
        return builder;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public static final class Builder {
        private String identity;
        private String username;
        private String password;
        private String grade;

        private Builder() {
        }

        public Builder identity(String val) {
            identity = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder grade(String val) {
            grade = val;
            return this;
        }

        public UserRegisterModel build() {
            return new UserRegisterModel(this);
        }
    }
}
