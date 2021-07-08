package com.edts.tdlib.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Collections of exception utility functions.
 */
public final class ExceptionUtil {
    private static final String[] PACKAGE_NAME_PREFIX = {"com.sgedts"};

    /**
     * Get stack traces by filter PACKAGE_NAME_PREFIX.
     *
     * @param stackTraceElements {@link StackTraceElement}[]
     * @return className.methodName(lineNumber)
     */
    public static String filterStackTraceElements(StackTraceElement[] stackTraceElements) {
        return Arrays.stream(stackTraceElements)
                .filter(Objects::nonNull)
                .filter(stackTraceElement -> StringUtils.isNotBlank(stackTraceElement.getClassName()) &&
                        StringUtils.isNotBlank(stackTraceElement.getFileName()) &&
                        !"<generated>".equals(stackTraceElement.getFileName()))
                .filter(stackTraceElement -> Arrays.stream(PACKAGE_NAME_PREFIX).anyMatch(stackTraceElement.getClassName()::startsWith))
                .map(stackTraceElement -> stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")")
                .collect(Collectors.joining(";"));
    }

}
