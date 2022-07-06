package com.stepik.javabasecourse.postalsystem.roles;

import com.stepik.javabasecourse.postalsystem.structure.*;

/*
Инспектор, который следит за запрещенными и украденными посылками
и бьет тревогу в виде исключения, если была обнаружена подобная посылка.
Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException.
Если он находит посылку, состоящую из камней (содержит слово "stones"),
то тревога прозвучит в виде StolenPackageException.
Оба исключения вы должны объявить самостоятельно в виде непроверяемых исключений.
 */
public class Inspector implements MailService
{
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException
    {
        if (!(mail instanceof MailPackage inspectedPackage)) return mail;
        if ((WEAPONS.equals(inspectedPackage.getContent().getContent()))
            || (BANNED_SUBSTANCE.equals(inspectedPackage.getContent().getContent())))
        {
            throw new IllegalPackageException("Illegal content detected!");
        }
        if (inspectedPackage.getContent().getContent().contains("stones"))
        {
            throw new StolenPackageException("Theft detected!");
        }
        return mail;
    }
}
