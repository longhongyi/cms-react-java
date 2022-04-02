package com.datasource.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Staff {
    private String name;
    //private Company company;
    @Autowired
    private Position position;

    @Override
    public String toString(){
        return "姓名："+name+"\n"+"职务："+position.getPosition();
    }

    public void setName(String name){
        this.name=name;
    }
}
