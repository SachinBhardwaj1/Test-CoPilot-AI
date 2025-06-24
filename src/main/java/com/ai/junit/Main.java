package com.ai.junit;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        String path = "example/Calculator.java";
        String className = "Calculator";
        List<String> methods = JavaMethodExtractor.extractMethods(path);

        for (String method : methods) {
            String test = OpenAIAgent.generateTest(method, className);
            TestFileWriter.writeTestFile(className, test);
        }
        
        logger.info("✅ Test generation complete!");
    }
}
