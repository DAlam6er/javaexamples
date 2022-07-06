package com.stepik.javabasecourse.postalsystem.structure;

import java.util.Objects;
/*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
public class MailMessage extends AbstractSendable
{

    private final String message;

    public MailMessage(String from, String to, String message)
    {
        super(from, to);
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        MailMessage that = (MailMessage) obj;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getFrom(), getTo(), getMessage());
    }
}
