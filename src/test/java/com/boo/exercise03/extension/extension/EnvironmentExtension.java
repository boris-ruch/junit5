package com.boo.exercise03.extension.extension;

import lombok.val;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentExtension implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        val props = new Properties();
        try {
            props.load(EnvironmentExtension.class.getResourceAsStream("/application.properties"));
        } catch (IOException e) {
            throw new IllegalStateException("failed to load env properties", e);
        }
        val env = props.getProperty("env");
        if ("qa".equalsIgnoreCase(env)) {
            return ConditionEvaluationResult.disabled("Test disabled on QA environment");
        }
        return ConditionEvaluationResult.enabled("Test enabled on QA environment");
    }

}
