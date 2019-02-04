package com.xjf.springboot.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author xjf
 * @date 2019/1/28 11:57
 */
@Entity     //实体
public class User {
    /**
     * 实体的唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //自增策略
    private Long id;

    private String name;

    private String email;

    protected User() {  //无参构造，设为protected，防止直接使用
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
