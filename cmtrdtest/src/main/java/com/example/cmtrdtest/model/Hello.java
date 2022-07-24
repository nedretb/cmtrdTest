package com.example.cmtrdtest.model;

import javax.persistence.*;

@Entity
@Table(name = "hello")
public class Hello {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String msg;

    private String lang;

    public Hello(Long id, String msg, String lang) {
        this.id = id;
        this.msg = msg;
        this.lang = lang;
    }

    public Hello(String hello_world, String en) {
        this.msg = hello_world;
        this.lang = en;
    }

    public Hello() {

    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public String getLang() {
        return lang;
    }
}
