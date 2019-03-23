package com.example.mongodb.bean;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Author: xz
 * @CreateDate: 2019/3/3 10:28
 * @Version: 1.0
 */
public class User {
    @Id
    private String id;
    //用户名
    private String userName;
    //密码
    private String passWord;
    //邮箱
    private String email;
    //昵称
    private String nickName;
    //年龄
    private Integer age;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
