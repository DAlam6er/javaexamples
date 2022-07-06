package com.grokkingalgorithms.chap07;

import com.grokkingalgorithms.chap06.graph.Vertex;
import com.grokkingalgorithms.chap06.graph.VertexNotFoundException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class DijkstraAlgorithm
{
    final HashSet<Vertex> vertices;
    // хеш-таблица для хранения стоимости вершин
    final HashMap<Vertex, Double> costs;
    // хеш-таблица для хранения родителей вершин
    final HashMap<Vertex, Vertex> parents;
    // хеш-таблица для хранения графа
    // (вершин с соседями и стоимостями перехода)
    final HashMap<Vertex, HashMap<Vertex, Integer>> graph;

    public DijkstraAlgorithm()
    {
        this.vertices = new HashSet<>();
        this.costs = new HashMap<>();
        this.parents = new HashMap<>();
        this.graph = new HashMap<>();
    }

    public void findShortestPath()
    {
        // Находим вершину с наименьшей стоимостью в хеш-таблице costs
        Vertex vertex = findLowestCostVertex();
        // Если обработаны все вершины - цикл завершается
        Double cost;
        Double newCost;
        HashMap<Vertex, Integer> neighbors;
        while (vertex != null) {
            // Получаем стоимость обрабатываемой вершины
            // (с наименьшей среди необработанных вершин стоимостью)
            cost = costs.get(vertex);
            // Получаем соседей обрабатываемой вершины
            neighbors = graph.get(vertex);
            // Перебираем всех соседей обрабатываемой вершины
            for (Vertex curNeighbor : neighbors.keySet()) {
                // Получаем стоимость очередного соседа обрабатываемой вершины
                newCost = cost + Optional.ofNullable(
                    neighbors.get(curNeighbor)).orElse(0);
                // Если к соседу можно быстрее добраться
                // через обрабатываемую вершину
                // то обновляем стоимость этого соседа
                // и обрабатываемая вершина становится
                // новым родителем для соседа
                if (costs.get(curNeighbor) > newCost) {
                    costs.put(curNeighbor, newCost);
                    parents.put(curNeighbor, vertex);
                }
            }
            // Помечаем обрабатываемую вершину как обработанную
            vertex.setVisited(true);
            // Ищем следующую вершину с наименьшей стоимостью
            // среди необработанных вершин графа
            vertex = findLowestCostVertex();
        }
    }

    public Vertex getByName(String vertexName) throws VertexNotFoundException
    {
        return vertices.stream()
            .filter(vertex -> vertex.getName().equals(vertexName))
            .findFirst()
            .orElseThrow(() -> new VertexNotFoundException(
                "Vertex not found: ", vertexName));
    }

    public void printShortestPath()
    {
        for (Map.Entry<Vertex, Vertex> entry : parents.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args)
    {
        DijkstraAlgorithm da = new DijkstraAlgorithm();
        try {
            da.initialize();
        } catch (VertexNotFoundException e) {
            System.out.println(e.getMessage());
        }
        da.findShortestPath();
        da.printShortestPath();
    }

    // Поиск вершины с наименьшей стоимостью
    private Vertex findLowestCostVertex()
    {
        Double lowestCost = Double.POSITIVE_INFINITY;
        // вершина с наименьшей стоимостью
        Vertex lowestCostVertex = null;

        for (Vertex vertex : costs.keySet()) {
            // в cost хранится стоимость перебираемой вершины
            Double cost = costs.get(vertex);
            // Если это вершина с наименьшей стоимостью из уже виденных
            // и она еще не была обработана,
            // то она назначается новой вершиной с наименьшей стоимостью
            //if ((cost < lowestCost) && (!processed.contains(vertex))) {
            if ((cost < lowestCost) && (!vertex.isVisited())) {
                lowestCost = cost;
                lowestCostVertex = vertex;
            }
        }
        return lowestCostVertex;
    }

    private void initialize() throws VertexNotFoundException
    {
        vertices.add(new Vertex("start"));
        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("fin"));

        // стоимость вершины определяет, сколько времени потребуется
        // для перехода к этой вершине от начальной вершине
        // если стоимость перехода к вершине неизвестна
        // - она считается бесконечной
        Double inf = Double.POSITIVE_INFINITY;
        costs.put(getByName("A"), 6.);
        costs.put(getByName("B"), 2.);
        costs.put(getByName("fin"), inf);

        // родительская хеш-таблица
        parents.put(getByName("A"), getByName("start"));
        parents.put(getByName("B"), getByName("start"));
        parents.put(getByName("fin"), null);

        HashMap<Vertex, Integer> neighbors = new HashMap<>();
        neighbors.put(getByName("A"), 6);
        neighbors.put(getByName("B"), 2);
        graph.put(getByName("start"), new HashMap<>(neighbors));

        neighbors.clear();
        neighbors.put(getByName("fin"), 1);
        graph.put(getByName("A"), new HashMap<>(neighbors));

        neighbors.clear();
        neighbors.put(getByName("A"), 3);
        neighbors.put(getByName("fin"), 5);
        graph.put(getByName("B"), new HashMap<>(neighbors));

        neighbors.clear();
        neighbors.put(getByName("fin"), null);
        graph.put(getByName("fin"), new HashMap<>(neighbors));
        neighbors.clear();
    }
}
