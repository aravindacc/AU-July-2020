package com.au.spring.beans;

public interface Shape {
    default String getType() {
        return null;
    }
}

