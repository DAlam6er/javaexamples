package com.stepik.javabasecourse.postalsystem.roles;

import com.stepik.javabasecourse.postalsystem.structure.MailPackage;
import com.stepik.javabasecourse.postalsystem.structure.MailService;
import com.stepik.javabasecourse.postalsystem.structure.Package;
import com.stepik.javabasecourse.postalsystem.structure.Sendable;

/*
Вор, который ворует самые ценные посылки и игнорирует все остальное.
Вор принимает в конструкторе переменную int – минимальную стоимость посылки,
которую он будет воровать.
Также, в данном классе должен присутствовать метод getStolenValue,
который возвращает суммарную стоимость всех посылок, которые он своровал.
Воровство происходит следующим образом: вместо посылки, которая пришла вору,
он отдает новую, такую же, только с нулевой ценностью и содержимым посылки
"stones instead of {content}".
 */
public class Thief implements MailService
{
    private final int minValue;
    private int stolenValue = 0;

    public Thief(int minValue)
    {
        this.minValue = minValue;
    }

    @Override
    public Sendable processMail(Sendable mail)
    {

        if (!(mail instanceof MailPackage stolenPackage)) return mail;
        int value;
        if ((value = stolenPackage.getContent().getPrice()) >= minValue) {
            stolenValue += value;
            return new MailPackage(stolenPackage.getFrom(),
                stolenPackage.getTo(),
                new Package("stones instead of "
                    + stolenPackage.getContent().getContent(), 0));
        }
        return mail;
    }

    public int getStolenValue()
    {
        return stolenValue;
    }
}
