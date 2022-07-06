package com.stepik.javabasecourse.postalsystem.structure;

public class RealMailService implements MailService
{
    @Override
    public Sendable processMail(Sendable mail)
    {
        // Здесь описан код настоящей системы отправки почты
        System.out.println("Почтовое отправление доставлено " + mail.getTo());
        return mail;
    }
}
