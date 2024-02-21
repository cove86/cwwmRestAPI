package com.cwwm.cwwmapi.mappers;

public interface Mapper<A,B> {

    B mapTo(A a);

    A mapFrom(B b);

}
