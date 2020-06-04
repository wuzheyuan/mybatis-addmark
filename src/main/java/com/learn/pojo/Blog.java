package com.learn.pojo;

import java.util.List;

public class Blog {
    private Integer bid;

    private String name;

    private Integer authorId;

    private List<Integer> flags;

    public List<Integer> getFlags() {
        return flags;
    }

    public void setFlags(List<Integer> flags) {
        this.flags = flags;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", flags=" + flags +
                '}';
    }
}