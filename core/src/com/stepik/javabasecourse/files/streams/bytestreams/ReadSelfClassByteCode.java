package com.stepik.javabasecourse.files.streams.bytestreams;

import java.io.IOException;
import java.io.InputStream;

public class ReadSelfClassByteCode
{
    public static void main(String[] args)
    {
        try (
            InputStream is = ReadSelfClassByteCode.class.getResourceAsStream(
                "ReadSelfClassByteCode.class"))
        {
            int read;
            while ((read = is.read()) >= 0) {
                System.out.printf("%02x ", read);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Exception " + e);
        }
    }
}
