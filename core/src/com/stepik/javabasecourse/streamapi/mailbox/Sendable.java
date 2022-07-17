package com.stepik.javabasecourse.streamapi.mailbox;

public interface Sendable<T>
{
    String getFrom();
    String getTo();
    T getContent();
}
