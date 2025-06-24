package com.ai.junit;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class JavaMethodExtractor {
    public static List<String> extractMethods(String filePath) throws Exception {
        com.github.javaparser.ast.CompilationUnit cu = StaticJavaParser.parse(new File(filePath));
        return cu.findAll(MethodDeclaration.class).stream()
            .map(MethodDeclaration::toString)
            .collect(Collectors.toList());
    }
}