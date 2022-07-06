package com.stepik.javabasecourse.postalsystem.roles;

import com.stepik.javabasecourse.postalsystem.structure.MailService;
import com.stepik.javabasecourse.postalsystem.structure.RealMailService;
import com.stepik.javabasecourse.postalsystem.structure.Sendable;
/*
Класс, моделирующий ненадежного работника почты, который вместо того, чтобы
передать почтовый объект непосредственно в сервис почты,
последовательно передает этот объект набору третьих лиц,
а затем, в конце концов, передает получившийся объект непосредственно
экземпляру RealMailService.
 */
public class UntrustworthyMailWorker implements MailService
{
    private final MailService[] thirdParties;
    private final MailService realMailService;

    public UntrustworthyMailWorker(MailService[] thirdParties)
    {
        this.thirdParties = thirdParties;
        realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail)
    {
        Sendable compromisedMail = thirdParties[0].processMail(mail);
        for (int i = 1; i < thirdParties.length; i++) {
            compromisedMail = thirdParties[i].processMail(compromisedMail);
        }
        return getRealMailService().processMail(compromisedMail);
    }

    public MailService getRealMailService()
    {
        return realMailService;
    }
}
