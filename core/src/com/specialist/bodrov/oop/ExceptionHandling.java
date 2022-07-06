package com.specialist.bodrov.oop;

import java.io.IOException;
import java.util.Random;

public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("Before");
        try {
            if (true) {
                return;
//                System.exit(0);
            }
            ioException();
            runtimeException();
            if (new Random().nextBoolean()) {
                sof();
            } else {
                divideByZero();
            }
        } catch (ArithmeticException | NullPointerException e) {
            e.printStackTrace();
        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally!");
        }


//

        System.out.println("After");
    }

    public static void divideByZero() {
        int i = 2 / 0;
    }

    public static void sof() {
        sof();
    }

    public static void runtimeException() {
        throw new RuntimeException();
    }

    public static void ioException() throws IOException {
        if (new Random().nextBoolean()) {
            throw new IOException("Checked exception!");
        }
    }


}
