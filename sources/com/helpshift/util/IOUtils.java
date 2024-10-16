package com.helpshift.util;

import java.io.Closeable;

/* loaded from: classes2.dex */
public class IOUtils {
    public static void closeQuitely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
