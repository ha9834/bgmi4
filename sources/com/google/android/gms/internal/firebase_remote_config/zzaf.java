package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzaf extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private final transient zzw f4118a;
    private final int statusCode;
    private final String zzbv;
    private final String zzby;

    public zzaf(zzac zzacVar) {
        this(new zzae(zzacVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaf(zzae zzaeVar) {
        super(zzaeVar.e);
        this.statusCode = zzaeVar.f4117a;
        this.zzbv = zzaeVar.b;
        this.f4118a = zzaeVar.c;
        this.zzby = zzaeVar.d;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public static StringBuilder zzc(zzac zzacVar) {
        StringBuilder sb = new StringBuilder();
        int statusCode = zzacVar.getStatusCode();
        if (statusCode != 0) {
            sb.append(statusCode);
        }
        String statusMessage = zzacVar.getStatusMessage();
        if (statusMessage != null) {
            if (statusCode != 0) {
                sb.append(' ');
            }
            sb.append(statusMessage);
        }
        return sb;
    }
}
