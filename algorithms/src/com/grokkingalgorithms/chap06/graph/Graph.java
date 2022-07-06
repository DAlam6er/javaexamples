package com.grokkingalgorithms.chap06.graph;

import java.util.*;

public class Graph
{
    private final static int MAX_VERTEX = 10;
    // матрица смежности (Adjacency matrix)
    private Edge[][] adjMatrix;
    // current vertex counter
    private int curVertex;
    private final HashMap<Vertex, ArrayList<Vertex>> vertices;
    private final HashMap<Vertex, Integer> indices;
    final com.grokkingalgorithms.chap06.graph.Stack<Vertex> stack;
    final com.grokkingalgorithms.chap06.graph.Queue<Vertex> queue;

    public Graph()
    {
        vertices = new HashMap<>();
        indices = new HashMap<>();
        stack = new Stack<>();
        queue = new Queue<>();
        adjMatrix = new Edge[MAX_VERTEX][MAX_VERTEX];
        curVertex = 0;
    }

    public HashMap<Vertex, ArrayList<Vertex>> getVertices()
    {
        return vertices;
    }

    public Vertex getByName(String vertexName)
    {
        return vertices.keySet().stream()
            .filter(vertex -> vertex.getName().equals(vertexName))
            .findFirst().orElse(new Vertex(vertexName));
    }
    /**
     * Add vertex to graph
     * @param vertex vertex instance
     */
    public boolean addVertex(Vertex vertex)
    {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, null);
            indices.put(vertex, curVertex++);
            return true;
        }
        return false;
    }

    /**
     * Add vertex by its name to graph
     * @param vertexName name of the vertex instance
     */
    public boolean addVertex(String vertexName)
    {

        return addVertex(getByName(vertexName));
    }

    private void resizeMatrix()
    {
        int oldSize = adjMatrix.length;
        int newSize = 2 * adjMatrix.length;

        adjMatrix = Arrays.copyOf(adjMatrix, newSize);
        for (int i = 0; i < oldSize; i++) {
            adjMatrix[i] = Arrays.copyOf(adjMatrix[i], newSize);
        }

        for (int i = oldSize; i < newSize; i++) {
            adjMatrix[i] = new Edge[newSize];
        }
    }

    /**
     * Adding an edge between two vertices of the graph
     * @param line - index of outer adjMatrix
     * @param column - index of inner adjMatrix
     * @param directed - directed or undirected edge
     * @param weight weight of the graph
     */
    private void addEdge(int line, int column, boolean directed,
                         Integer weight)
    {
        Edge edge = new Edge(directed, weight);
        if (line == adjMatrix.length - 1 || column == adjMatrix.length - 1)
        {
            resizeMatrix();
        }
        adjMatrix[line][column] = edge;
        if (!directed) {
            edge.setDirected(false);
            adjMatrix[column][line] = edge;
        }
    }

    /**
     * Adding an unloaded edge between two vertices of the graph
     * @param line - index of outer adjMatrix
     * @param column - index of inner adjMatrix
     */
    private void addEdge(int line, int column, boolean directed)
    {
        addEdge(line, column, directed, null);
    }

    /**
     * Add multiple neighbours for selected centralVertex
     * @param directed directed or undirected edges
     * @param weight weight of the edges
     * @param centralVertex centralVertex instance
     * @param rays Arraylist of the vertices to be added
     */
    public void makeStarLink(boolean directed, Integer weight,
                             Vertex centralVertex, ArrayList<Vertex> rays)
    {
        addVertex(centralVertex);

        for (Vertex v : rays) {
            ArrayList<Vertex> list =
                vertices.putIfAbsent(centralVertex, new ArrayList<>());
            addVertex(v);
            assert list != null;
            list.add(v);
            addEdge(
                indices.get(centralVertex), indices.get(v),
                directed, weight);
        }
    }

    public void makeStarLink(boolean directed, Vertex centralVertex,
                             ArrayList<Vertex> rays)
    {
       makeStarLink(directed, null, centralVertex, rays);
    }

    /**
     * Add multiple neighbours for selected vertex
     * @param directed sign of graph orientation
     * @param centralVertex name of the central vertex
     * @param rays name of the ray vertices to be added
     */
    public void makeStarLink(boolean directed, String centralVertex,
                             String ... rays)
    {
       makeStarLink(directed, null, centralVertex, rays);
    }

    /**
     * Add multiple neighbours for selected vertex
     * @param directed sign of graph orientation
     * @param weight weight of the edge
     * @param cVertexName name of the central vertex
     * @param vNames name of the ray vertices to be added
     */
    public void makeStarLink(boolean directed, Integer weight,
                             String cVertexName, String ... vNames)
    {
        Vertex cVertex = getByName(cVertexName);
        addVertex(cVertexName);
        for (String vName : vNames) {
            ArrayList<Vertex> list =
                vertices.computeIfAbsent(cVertex, k -> new ArrayList<>());
            addVertex(vName);

            list.add(getByName(vName));
            try {
                addEdge(
                    getKey(cVertexName), getKey(vName), directed, weight);
            } catch (VertexNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Integer getKey(String vertexName) throws VertexNotFoundException
    {
        return indices.entrySet().stream()
            .filter(e -> vertexName.equals(e.getKey().getName()))
            .map(Map.Entry::getValue).findFirst()
            .orElseThrow(() -> new VertexNotFoundException(
                "Key matching vertex name not found", vertexName));
    }

    /**
     * Depth pass in graph (обход в глубину)
     */
    public int passInDepth(String startVertexName)
    {
        return passInDepth(startVertexName, null);
    }

    public int passInDepth(String startVertexName, String endVertexName)
    {
        try {
            getKey(startVertexName);
        } catch (VertexNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return -1; // заглушка
    }

    /**
     * Breadth pass in all vertices of the graph (Обход в ширину)
     */
    public int passInBreadth(String startVertexName)
    {
        return passInBreadth(startVertexName, null);
    }


    /**
     * Finding the smallest distance between the specified graph vertices
     */
    public int passInBreadth(String startVertexName, String endVertexName)
    {
        try {
            getKey(startVertexName);
        } catch (VertexNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // при обходе в ширину используется очередь
        return -1; // заглушка
    }

    public void getMatrix()
    {
        for (Edge[] matrix : adjMatrix) {
            for (Edge edge : matrix) {
                System.out.printf("%s ", edge == null ?
                    null : edge.isDirected());
            }
            System.out.println();
        }
    }

    @Override
    public String toString()
    {
        return vertices.entrySet().toString();
    }
}