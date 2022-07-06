package com.stepik.javabasecourse.postalsystem.roles;

import com.stepik.javabasecourse.postalsystem.structure.MailMessage;
import com.stepik.javabasecourse.postalsystem.structure.MailService;
import com.stepik.javabasecourse.postalsystem.structure.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Шпион, который логгирует о всей почтовой переписке,
 которая проходит через его руки.
 Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
 Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения
 (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
     Если в качестве отправителя или получателя указан "Austin Powers",
     то нужно написать в лог сообщение с уровнем WARN:
     Detected target mail correspondence: from {from} to {to} "{message}"

     Иначе, необходимо написать в лог сообщение с уровнем INFO:
     Usual correspondence: from {from} to {to}
 */
public class Spy implements MailService
{
    public static Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(Logger logger)
    {
        Spy.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail)
    {
        if (!(mail instanceof MailMessage message)) return mail;
        String logEntry;
        String messageFrom = message.getFrom();
        String messageTo = message.getTo();
        if (AUSTIN_POWERS.equals(messageFrom)
            || AUSTIN_POWERS.equals(messageTo)) {
            logEntry = String.format(
                "Detected target mail correspondence: from %s to %s \"%s\"",
                messageFrom, messageTo, message.getMessage());
            logger.log(Level.WARNING, logEntry);
        } else {
            logEntry = String.format("Usual correspondence: from %s to %s",
                messageFrom, messageTo);
            logger.log(Level.INFO, logEntry);
        }
        return mail;
    }
}
