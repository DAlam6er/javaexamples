package com.stepik.javabasecourse.postalsystem.structure;

public class IllegalPackageException extends RuntimeException
{
    public IllegalPackageException() { }

    public IllegalPackageException(String message)
    {
        super(message);
    }
}
