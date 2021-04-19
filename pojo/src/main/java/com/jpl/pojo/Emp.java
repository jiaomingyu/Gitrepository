package com.jpl.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer id;
    private Integer did;
    private String name;
    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
