package com.stepik.javabasecourse.postalsystem;

import com.stepik.javabasecourse.postalsystem.roles.*;
import com.stepik.javabasecourse.postalsystem.structure.*;
import com.stepik.javabasecourse.postalsystem.structure.Package;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PostalServiceDemo
{
    public static void main(String[] args)
    {
        Spy spy = new Spy(Logger.getLogger(Spy.class.getName()));
        Thief thief = new Thief(50);
        Inspector inspector = new Inspector();

        MailService[] roles = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker badWorker = new UntrustworthyMailWorker(roles);

        final ArrayList<Sendable> mailings = new ArrayList<>();
        mailings.add(
            new MailMessage("Антон", "Татьяна", "Я тебя люблю"));
        mailings.add(
            new MailMessage("David Lynch", "Austin Powers", "Watch the owls!"));
        mailings.add(
            new MailPackage("ООО Вектор", "ООО Рога и Копыта",
                new Package("Измельчитель бумаги", 100)));
        mailings.add(
            new MailPackage("ООО Глобус", "ООО Ручей",
                new Package("Рецептурные препараты", 20)));
        mailings.add(
            new MailPackage("ЗАО Коза Ностра", "ИП Корлеоне",
                new Package("weapons", 20)));

        for (Sendable mailing : mailings) {
            try {
                badWorker.processMail(mailing);
            } catch (IllegalPackageException | StolenPackageException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Вор украл на сумму: " + thief.getStolenValue());
    }
}
