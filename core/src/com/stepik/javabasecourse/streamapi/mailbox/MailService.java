package com.stepik.javabasecourse.streamapi.mailbox;

import java.util.*;
import java.util.function.Consumer;

//  Почтовому сервису необходимо использовать методы Sendable,
//  используя Consumer<Sendable<T>> мы даём ему такую возможность,
//  ведь все принимаемые объекты реализуют Sendable.
//  а используя просто Consumer<T> о принимаемом объекте ничего неизвестно.
// forEachOrdered и forEach ожидают в качестве аргумента класс,
// реализующий интерфейс Consumer.
// Судя по исходному коду, Consumer потребляет письма с содержимым,
// соответствующим параметру класса MailService.
public class MailService<T> implements Consumer<Sendable<T>>
{
    private final Map<String, List<T>> messagesMap;

    public MailService()
    {
        messagesMap = new HashMap<String, List<T>>() {
            // Возвращать изменяемый список во внешний мир
            // – не очень хорошая идея по причине того,
            // что его изменение может испортить внутреннее состояние
            // словаря. Лучше оборачивать подобный вывод в
            // Collections.unmodifiableList.
            // Однако здесь мы не можем так поступить по причине того,
            // что добавлять новые элементы в списки из accept будет неудобно.
            // Нужно реализовать дополнительный метод getMutable, который
            // возвращал бы изменяемый список, удобный для модификации.
            // Но добавить новый метод мы можем только в именованный класс.
            @Override
            public List<T> get(Object key)
            {
                // Collections.emptyList()
                // возвращает один и тот же экземпляр неизменяемого списка.
                // Если бы мы возвращали здесь new ArrayList<>(),
                // то множество вызовов get по отсутвующему элементу
                // создавало бы множество лишних объектов.
                return super.getOrDefault(key, Collections.emptyList());
            }
        };
    }

    public Map<String, List<T>> getMessagesMap()
    {
        return messagesMap;
    }

    @Override
    public void accept(Sendable<T> sendable)
    {
        List<T> list = messagesMap.get(sendable.getTo()); // получатель сообщения
        if (list.size() == 0) {
            list = new ArrayList<>();
        }
        list.add(sendable.getContent());                  // содержание сообщения
        messagesMap.put(sendable.getTo(), list);
    }
}
