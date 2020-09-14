package com.lushwe.spring.boot.diagnostics;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;

/**
 * 说明：ConsoleFailureAnalyzerReporter
 *
 * @author Jack Liu
 * @date 2019-06-16 17:44
 * @since 1.0
 */
public class ConsoleFailureAnalyzerReporter implements FailureAnalysisReporter {

    @Override
    public void report(FailureAnalysis analysis) {
        System.out.printf("故障描述：%s \n执行动作：%s \n异常堆栈：%s \n",
                analysis.getDescription(), analysis.getAction(), analysis.getCause());
    }
}
