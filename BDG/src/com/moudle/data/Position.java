package com.moudle.data;

import org.springframework.stereotype.Component;

@Component
public class Position {
    private String name="商务员";
    private int grade=1;

    public String getPosition(){
        return name+"\t等级"+grade;
    }
}
