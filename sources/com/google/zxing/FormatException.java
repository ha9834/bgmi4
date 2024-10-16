package com.google.zxing;

/* loaded from: classes2.dex */
public final class FormatException extends ReaderException {
    private static final FormatException c;

    static {
        FormatException formatException = new FormatException();
        c = formatException;
        formatException.setStackTrace(b);
    }

    private FormatException() {
    }

    public static FormatException a() {
        return f5393a ? new FormatException() : c;
    }
}
