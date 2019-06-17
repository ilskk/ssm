package com.kk.entity;

import java.util.*;

public class CollectionType {
    private List<String> list;
    private String[] arr;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    @Override
    public String toString() {
        return "CollectionType{" +
                "list=" + list +
                ", arr=" + Arrays.toString(arr) +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
