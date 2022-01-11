package com.moudle.data;

import java.util.Date;

public class Company {
    private String name;
    private Date creationDate;
    private int numOfMember;

    public Company(){}
    public Company(String name,Date creationDate,int numOfMember){
        this.name=name;
        this.creationDate=creationDate;
        this.numOfMember=numOfMember;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setNumOfMember(int numOfMember) {
        this.numOfMember = numOfMember;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getNumOfMember() {
        return numOfMember;
    }

    @Override
    public String toString(){
        return "name:"+name+";creationDate:"+creationDate+";numOfMember"+numOfMember;
    }
}
