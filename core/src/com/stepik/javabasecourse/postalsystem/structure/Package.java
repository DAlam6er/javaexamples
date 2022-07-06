package com.stepik.javabasecourse.postalsystem.structure;

import java.util.Objects;

/*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
public class Package
{
    private final String content;
    private final int price;

    public Package(String content, int price)
    {
        this.content = content;
        this.price = price;
    }

    public String getContent()
    {
        return content;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Package aPackage = (Package) obj;
        if (price != aPackage.getPrice()) return false;
        if (!content.equals(aPackage.content)) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getContent(), getPrice());
    }
}
