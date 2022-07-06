package com.grokkingalgorithms.chap06.graph;

import java.util.Objects;

// Узел графа
public class Vertex
{
    private String name;
    private boolean isVisited;

    public Vertex(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (name != null && !name.isBlank())
        {
            this.name = name;
        }
    }

    public boolean isVisited()
    {
        return isVisited;
    }

    public void setVisited(boolean visited)
    {
        isVisited = visited;
    }

    @Override
    public String toString()
    {
        return getName();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return name.equals(vertex.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}