package com.google.android.gms.internal.firebase_remote_config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
final class ax extends ThreadLocal<DateFormat> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ DateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    }
}
