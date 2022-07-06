package com.stepik.javabasecourse.postalsystem.structure;

import java.util.Objects;
/*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
public class MailPackage extends AbstractSendable
{
    private final Package content;


    public MailPackage(String from, String to, Package content)
    {
        super(from, to);
        this.content = content;
    }

    public Package getContent()
    {
        return content;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        MailPackage that = (MailPackage) obj;
        return content.equals(that.content);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(from, to, content);
    }
}
