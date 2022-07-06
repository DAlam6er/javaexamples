package com.grokkingalgorithms.chap06.graph;

public class Edge
{
    private Integer weight;
    private boolean directed;
    private boolean weighted;

    public Edge(boolean directed, Integer weight)
    {
        setDirected(directed);
        setWeight(weight);
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
        setWeighted(weight != null);
    }

    public boolean isDirected()
    {
        return directed;
    }

    public void setDirected(boolean directed)
    {
        this.directed = directed;
    }

    public boolean isWeighted()
    {
        return weighted;
    }

    private void setWeighted(boolean weighted)
    {
        this.weighted = weighted;
    }
}
