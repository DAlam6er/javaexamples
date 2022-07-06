package com.stepik.javabasecourse.postalsystem.structure;

import java.util.Objects;
/*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
public class AbstractSendable implements Sendable
{

    protected final String from;
    protected final String to;

    public AbstractSendable(String from, String to)
    {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom()
    {
        return from;
    }

    @Override
    public String getTo()
    {
        return to;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        AbstractSendable that = (AbstractSendable) obj;
        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getFrom(), getTo());
    }
}
