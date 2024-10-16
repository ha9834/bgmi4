package com.helpshift.util.concurrent;

/* loaded from: classes2.dex */
public class ApiExecutorFactory {
    public static ApiExecutor getHandlerExecutor() {
        return LazyHolder.HANDLER_EXECUTOR;
    }

    /* loaded from: classes2.dex */
    private static class LazyHolder {
        static final ApiExecutor HANDLER_EXECUTOR = new HandlerThreadExecutor("HS-cm-api-exec");

        private LazyHolder() {
        }
    }
}
