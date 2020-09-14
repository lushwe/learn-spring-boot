package com.lushwe.spring.boot.diagnostics;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

/**
 * 说明：UnknownErrorFailureAnalyzer
 *
 * @author Jack Liu
 * @date 2019-06-16 17:41
 * @since 1.0
 */
public class UnknownErrorFailureAnalyzer implements FailureAnalyzer {


    @Override
    public FailureAnalysis analyze(Throwable failure) {
        if (failure instanceof UnknownError) {
            return new FailureAnalysis("未知错误", "请重启尝试", failure);
        }
        return null;
    }
}
