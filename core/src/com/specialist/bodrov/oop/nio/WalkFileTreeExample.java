package com.specialist.bodrov.oop.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class WalkFileTreeExample {

    public static void main(String[] args) {
        Path path = Paths.get(".");
        try {
            Files.walkFileTree(path, Collections.emptySet(), 8, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
