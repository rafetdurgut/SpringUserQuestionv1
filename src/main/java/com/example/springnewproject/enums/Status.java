package com.example.springnewproject.enums;

public enum Status {
    OPEN("Açık"),
    CLOSED("Kapali"),
    REPLIED("Cevaplandı"),
    APPROVAL("Onayda");
    public final String name;
    Status(String s)
    {
        this.name = s;
    }
}
