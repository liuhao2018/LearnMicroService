package com.example.microservice.demo.model;

public class CommonAPIResponse<T> {
    private T data;
    private int statusCode = 200;
    private String message = "success";

    public CommonAPIResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonAPIResponse{" +
                "data=" + data +
                ", statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}
