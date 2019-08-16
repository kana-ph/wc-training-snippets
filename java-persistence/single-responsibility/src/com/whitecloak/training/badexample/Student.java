package com.whitecloak.training.badexample;

public class Student {

    private String id;
    private String name;
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void processPayment(Payment payment) {
        // omitted
    }

    public void enroll(Subject subject) {
        // omitted
    }
}
