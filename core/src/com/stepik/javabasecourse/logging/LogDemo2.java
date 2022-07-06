package com.stepik.javabasecourse.logging;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogDemo2
{
    public static final Logger LOGGER = Logger.getLogger(LogDemo2.class.getName());

    public static void main(String[] args)
    {
        // по умолчанию логгер настроен на уровень INFO
        LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));

        try {
            randomlyFailingAlgorithm();
        } catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(2);
        }

        LOGGER.fine("Finished successfully");
    }

    private static void randomlyFailingAlgorithm()
    {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }
}
