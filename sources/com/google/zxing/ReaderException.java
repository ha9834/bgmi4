package com.google.zxing;

/* loaded from: classes2.dex */
public abstract class ReaderException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    protected static final boolean f5393a;
    protected static final StackTraceElement[] b;

    static {
        f5393a = System.getProperty("surefire.test.class.path") != null;
        b = new StackTraceElement[0];
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
