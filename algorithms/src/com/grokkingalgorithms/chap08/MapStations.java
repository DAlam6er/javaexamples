package com.grokkingalgorithms.chap08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

// Реализация жадного алгоритма
public class MapStations
{
    final HashSet<State> statesNeeded;
    final HashMap<Station, HashSet<State>> stations;

    public MapStations()
    {
        statesNeeded = new HashSet<>();
        stations = new HashMap<>();
    }

    public State getByName(String stateName) throws StateNotFoundException
    {
        return statesNeeded.stream()
            .filter(vertex -> vertex.getName().equals(stateName))
            .findFirst()
            .orElseThrow(() -> new StateNotFoundException(
                "State not found: ", stateName));
    }

    public HashSet<Station> getBestStations()
    {
        HashSet<State> statesForStation;
        HashSet<State> covered;
        HashSet<Station> finalStations = new HashSet<>();
        // Пока множество не станет пустым
        while (!statesNeeded.isEmpty()) {
            // Станция, обслуживающая больше всего штатов,
            // не входящих в текущее покрытие
            Station bestStation = null;
            // Множество, содержащее все штаты, обслуживаемые этой станцией,
            // которые еще не входят в текущее покрытие
            HashSet<State> statesCovered = new HashSet<>();
            // Поиск наилучшей станции
            for (Station curStation : stations.keySet()) {
                // Множество штатов, привязанных к текущей станции
                statesForStation = stations.get(curStation);
                // Находим пересечение множеств statesNeeded и statesForStation
                // Оно будет содержать в себе множество штатов,
                // не входящих в покрытие, которые покрываются текущей станцией
                // сохраняем результат в covered
                covered = new HashSet<>(statesNeeded);
                covered.retainAll(statesForStation);
                // Проверяем, покрывает ли эта станция больше штатов,
                // чем текущая станция bestStation
                if (covered.size() > statesCovered.size()) {
                    bestStation = curStation;
                    statesCovered = covered;
                }
            }
            // Обновляем содержимое statesNeeded: те штаты,
            // которые входят в зону покрытия станции, больше не нужны
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        return finalStations;
    }

    private void initialize()
    {
        statesNeeded.add(new State("mt"));
        statesNeeded.add(new State("wa"));
        statesNeeded.add(new State("or"));
        statesNeeded.add(new State("id"));
        statesNeeded.add(new State("nv"));
        statesNeeded.add(new State("ut"));
        statesNeeded.add(new State("ca"));
        statesNeeded.add(new State("az"));

        populateStations("kOne", "id", "nv", "ut");
        populateStations("kTwo", "wa", "id", "mt");
        populateStations("kThree", "or", "nv", "ca");
        populateStations("kFour", "nv", "ut");
        populateStations("kFive", "ca", "az");
    }

    // Отображение станции (ключ) на множество штатов (значение)
    private void populateStations(String stationName, String... stateName)
    {
        HashSet<State> statesOfStation = new HashSet<>();

        try {
            for (String s : stateName) {
                statesOfStation.add(getByName(s));
            }
        } catch (StateNotFoundException e) {
            System.out.println(e.getMessage());
        }
        stations.put(
            new Station(stationName), new HashSet<>(statesOfStation));
    }

    private static class StateNotFoundException extends Exception
    {
        private final String name;

        public String getName()
        {
            return name;
        }

        public StateNotFoundException(String message, String name)
        {
            super(String.format("%s: %s", message, name));
            this.name = name;
        }
    }

    public static void main(String[] args)
    {
        MapStations ms = new MapStations();
        ms.initialize();
        System.out.println(ms.getBestStations());
    }
}

class Station
{
    String name;

    public Station(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}

class State
{
    String name;

    public State(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return name.equals(state.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
