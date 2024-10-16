package com.vk.api.sdk.utils.log;

import kotlin.c;

/* loaded from: classes3.dex */
public interface Logger {

    /* loaded from: classes3.dex */
    public enum LogLevel implements Comparable<LogLevel> {
        VERBOSE,
        DEBUG,
        WARNING,
        ERROR,
        NONE
    }

    c<LogLevel> a();

    void a(LogLevel logLevel, String str, Throwable th);

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ void a(Logger logger, LogLevel logLevel, String str, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.a(logLevel, str, th);
        }
    }
}
