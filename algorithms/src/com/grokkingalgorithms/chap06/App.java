package com.grokkingalgorithms.chap06;

import com.grokkingalgorithms.chap06.graph.Graph;
import com.grokkingalgorithms.chap06.graph.Vertex;

import java.util.ArrayList;

public class App
{
    // TODO: переделать алгоритм поиска в ширину - работает некорректно
    public static void main(String[] args)
    {
        // Граф моделирует набор связей
        Graph graph = new Graph();
        graph.makeStarLink(false, "1", "2", "7", "8");
        graph.makeStarLink(false, "2", "3", "6");
        graph.makeStarLink(false, "3", "4", "5");
        graph.makeStarLink(false, "8", "9", "12");
        graph.makeStarLink(false, "9", "10", "11");

        System.out.println("Vertices of the graph: " + graph);

        Graph graph2 = new Graph();
        graph2.makeStarLink(
            true, "Me", "Alice", "Bob", "Claire");
        graph2.makeStarLink(
            true, "Alice", "Peggy");
        graph2.makeStarLink(
            true, "Bob", "Peggy", "Anuj");
        graph2.makeStarLink(
            true, "Claire", "Tom", "Johny");

        System.out.println("Vertices of the graph: " + graph2);
        Vertex v = graph2.getVertices().keySet().stream()
            .filter(vertex -> vertex.getName().equals("Alice"))
            .findFirst().orElse(null);
        if (v != null) {
            System.out.println(v.getName());
            v.setVisited(true);
            System.out.println(graph2.getVertices().get(v));
            Vertex me = graph2.getByName("Me");
            ArrayList<Vertex> list = graph2.getVertices().get(me);
            for (Vertex vertex : list) {
                System.out.printf("%s: %s\n", vertex.getName(), vertex.isVisited());
            }
        }
        graph2.getMatrix();

        Graph graph3 = new Graph();
        graph3.makeStarLink(
            true, "Twin Peaks", "Town1", "Town3");
        graph3.makeStarLink(
            true, "Town1", "Town5", "Town2");
        graph3.makeStarLink(
            true, "Town2", "Town4");
        graph3.makeStarLink(
            true, "Town3", "Town4");
        graph3.makeStarLink(
            true, "Town4", "Golden Gate Bridge");
        graph3.makeStarLink(
            true, "Town5", "Town4");

        System.out.println("Vertices of the graph: " + graph3);
    }
}