package com.grokkingalgorithms.chap06.graph;

public class VertexNotFoundException extends Exception
{
    private final String name;

    public String getName()
    {
        return name;
    }

    public VertexNotFoundException(String message, String name)
    {
        super(String.format("%s: %s", message, name));
        this.name = name;
    }
}
