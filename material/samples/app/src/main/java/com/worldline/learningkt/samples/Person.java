package com.worldline.learningkt.samples;

import javax.annotation.Nonnull;

public class Person {
    @Nonnull
    private String name;

    public Person(@Nonnull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        // ...
        return true;
    }

    @Override
    public int hashCode() {
        // ***
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}