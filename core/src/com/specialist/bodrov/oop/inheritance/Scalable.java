package com.specialist.bodrov.oop.inheritance;

public interface Scalable {

    int DEFAULT_FACTOR = 2;

    void scale(double factor);

    default void scale(){
        scale(DEFAULT_FACTOR);
    }
    //16:07
}
