package com.stepik.javabasecourse.logging;

import java.util.Arrays;
import java.util.logging.*;

public class ConfigureLogging
{
    public static void main(String[] args)
    {
        configureLogging();
    }

    private static void configureLogging() {
        Logger parent = Logger.getLogger("org.stepic.java");
        Logger logger1 = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger logger2 = Logger.getLogger("org.stepic.java.logging.ClassB");

        parent.setLevel(Level.ALL);
        logger1.setLevel(Level.ALL);
        logger2.setLevel(Level.WARNING);

        Handler handler = new ConsoleHandler();
        Formatter formatter = new XMLFormatter();

        handler.setFormatter(formatter);
        handler.setLevel(Level.ALL);
        parent.addHandler(handler);

        parent.setUseParentHandlers(false);
        logger1.setUseParentHandlers(true);
        logger2.setUseParentHandlers(true);

        //parent.getParent().info("root");
        parent.info("msg:");
        logger1.info("msg: 1");
        logger2.warning("msg: 2");
    }
}
