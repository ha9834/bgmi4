package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzaj {

    /* renamed from: a, reason: collision with root package name */
    private long f4120a = -1;
    private String b;
    private String c;
    private zzcm d;

    public abstract void addHeader(String str, String str2) throws IOException;

    public void zza(int i, int i2) throws IOException {
    }

    public abstract zzai zzaj() throws IOException;

    public final void setContentLength(long j) throws IOException {
        this.f4120a = j;
    }

    public final long getContentLength() {
        return this.f4120a;
    }

    public final void setContentEncoding(String str) throws IOException {
        this.b = str;
    }

    public final String getContentEncoding() {
        return this.b;
    }

    public final void setContentType(String str) throws IOException {
        this.c = str;
    }

    public final String getContentType() {
        return this.c;
    }

    public final void zza(zzcm zzcmVar) throws IOException {
        this.d = zzcmVar;
    }

    public final zzcm zzai() {
        return this.d;
    }
}
