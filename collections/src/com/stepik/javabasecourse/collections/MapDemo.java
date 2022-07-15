package com.stepik.javabasecourse.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// отображение или ассоциативный массив
// не наследует Collection, но идеологически относится к Collections
// В отличие от массивов, где элементы индексируются числами,
// Map позволяет индексировать элементы произвольными объектами
// Map не расширяет Iterable
public interface MapDemo<K, V>
{
    int size();
    boolean isEmpty();

    boolean containsKey(Object key);
    boolean containsValue(Object value);

    V get(Object key);
    V put(K key, V value);      // возвращает значение

    V remove(Object key);       // возвращает значение, перед удалением
    void clear();

    Set<K> keySet();                    // Возвращает множество ключей (дубликаты запрещены)
    Collection<V> values();             // Возвращает коллекцию значений (дубликаты могут быть)
    Set<Map.Entry<K, V>> entrySet();    // Возвращает множесто Entry интерфейс, вложенный в Map, содержащий ключ, значение
                                        // Элементами entrySet'а являются экземпляры Map.Entry
                                        // Он параметризован так же, как и Map: типом ключа и типом значения.

    // Примеры обхода отображения:
    // Map<A, B> map = new HashMap<>();
    // for (A key : map.keySet()) { ... }
    // for (B value : map.values()) { ... }
    // for (Map.Entry<A, B> entry : map.entrySet()) {
    //     System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
    // }

    // forEach принимает java.util.BiConsumer<T,U> с методом accept(T, U)
    // map.forEach((k, v) -> System.out.printf("%s => %s\n", k, v));


    // Реализации Map
    // HashMap<>, LinkedHashMap<> и TreeMap<>()
}
