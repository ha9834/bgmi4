package com.google.android.gms.internal.ads;

import android.webkit.ConsoleMessage;

/* loaded from: classes2.dex */
final /* synthetic */ class lb {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2309a = new int[ConsoleMessage.MessageLevel.values().length];

    static {
        try {
            f2309a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2309a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2309a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2309a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2309a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
