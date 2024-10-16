package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class zzag {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f4119a = Logger.getLogger(zzag.class.getName());
    private static final String[] b;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzaj a(String str, String str2) throws IOException;

    public final zzaa zza(zzad zzadVar) {
        return new zzaa(this, zzadVar);
    }

    public boolean zzz(String str) throws IOException {
        return Arrays.binarySearch(b, str) >= 0;
    }

    static {
        String[] strArr = {"DELETE", "GET", "POST", "PUT"};
        b = strArr;
        Arrays.sort(strArr);
    }
}
