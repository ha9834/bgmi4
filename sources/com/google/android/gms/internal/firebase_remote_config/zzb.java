package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public final class zzb {
    public static final String VERSION;
    public static final Integer zzb = 1;
    public static final Integer zzc = 26;

    /* renamed from: a, reason: collision with root package name */
    private static final Integer f4127a = 0;

    static {
        String valueOf = String.valueOf(zzb);
        String valueOf2 = String.valueOf(zzc);
        String valueOf3 = String.valueOf(f4127a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 11 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        sb.append(".");
        sb.append(valueOf3);
        sb.append("-SNAPSHOT");
        VERSION = sb.toString().toString();
    }
}
