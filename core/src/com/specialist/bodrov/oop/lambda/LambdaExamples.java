package com.specialist.bodrov.oop.lambda;

import com.specialist.bodrov.oop.inheritance.Rectangle;
import com.specialist.bodrov.oop.inheritance.Square;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExamples {

    public static void main(String[] args) {
        List<Square> squares = new ArrayList<>();
        squares.add(new Square(2));
        squares.add(new Square(19));
        squares.add(new Square(1));
        squares.add(new Square(5));

/*        Collections.sort(squares, new Comparator<Square>() {
            @Override
            public int compare(Square s1, Square s2) {
                return (int)(s1.getSide() - s2.getSide());
            }
        });*/

        Collections.sort(squares,
                (s1, s2) -> (int) (s1.getSide() - s2.getSide()));

        System.out.println(squares);

        Rectangle rectangle = new Rectangle(0, 0, 20, 30);
        Function<Rectangle, Double> perimeter = r -> 2 * (r.getW() + r.getH());
        Function<Rectangle, Double> square = r -> r.getW() * r.getH();

        System.out.println(calc(perimeter, rectangle));
        System.out.println(calc(r -> r.getW() * r.getH(), rectangle));

        System.out.println(calc(getOperation(OperationType.PERIMITER), rectangle));
        System.out.println(calc(getOperation(OperationType.SQUARE), rectangle));

        Predicate<String> predicate = s -> s == null || s.isEmpty();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test(null));
        System.out.println(predicate.test("Hello"));
    }

    public static double calc(Function<Rectangle, Double> function, Rectangle r) {
        return function.apply(r);
    }

    public static Function<Rectangle, Double> getOperation(OperationType type) {
        if (type == OperationType.PERIMITER) {
            return r -> 2 * (r.getW() + r.getH());
        } else if (type == OperationType.SQUARE) {
            return r -> r.getW() * r.getH();
        } else {
            throw new NoSuchElementException("No operation found");
        }
    }

    public enum OperationType {
        SQUARE, PERIMITER
    }
}