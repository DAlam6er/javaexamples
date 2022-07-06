package com.stepik.javabasecourse.postalsystem.structure;

public class StolenPackageException extends RuntimeException
{
    public StolenPackageException() { }

    public StolenPackageException(String message)
    {
        super(message);
    }
}
