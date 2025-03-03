package com.rest.webservices.restful.web.webservices.controller.hello.world.controller;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean() {
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
