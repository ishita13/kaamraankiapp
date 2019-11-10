package com.example.contacts_app;

public class ModelClass
{
    private String name,number,duration;
    public ModelClass(String n, String num, String du)
    {
        name=n;
        number=num;
        duration=du;

    }

    public void setNumber(String num) {
        this.number = num;
    }
    public String getNumber() {
        return number;
    }

    public void setDuration(String dura) {
        this.duration = dura;
    }
    public String getDuration() {
        return duration;
    }
    public void setName(String na) {
        this.name = na;
    }
    public String getName() {
        return name;
    }





}
