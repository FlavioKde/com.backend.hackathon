package com.hackthon.demo.entity;

import java.util.List;

public class Neighborhood {

    private long id;
    private String name;
    private String district;
    private List<Long> cp;

    public Neighborhood(String name, long id, String district, List<Long> cp) {
        this.name = name;
        this.id = id;
        this.district = district;
        this.cp = cp;
    }
}
