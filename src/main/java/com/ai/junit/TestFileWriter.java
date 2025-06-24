package com.ai.junit;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void writeTestFile(String className, String content) throws IOException {
        String fileName = "test/" + className + "Test.java";
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(content);
        }
    }
}
