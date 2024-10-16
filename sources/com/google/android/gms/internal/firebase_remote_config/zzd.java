package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class zzd {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f4151a = Logger.getLogger(zzd.class.getName());
    private final zzaa b;
    private final zzi c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final zzci h;
    private final boolean i;
    private final boolean j;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzd(zza zzaVar) {
        zzaa zza2;
        this.c = zzaVar.b;
        this.d = a(zzaVar.e);
        this.e = b(zzaVar.f);
        this.f = zzaVar.g;
        if (zzdy.zzbc(null)) {
            f4151a.logp(Level.WARNING, "com.google.api.client.googleapis.services.AbstractGoogleClient", "<init>", "Application name is not set. Call Builder#setApplicationName.");
        }
        this.g = null;
        if (zzaVar.c == null) {
            zza2 = zzaVar.f4152a.zza(null);
        } else {
            zza2 = zzaVar.f4152a.zza(zzaVar.c);
        }
        this.b = zza2;
        this.h = zzaVar.d;
        this.i = false;
        this.j = false;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza {

        /* renamed from: a, reason: collision with root package name */
        final zzag f4152a;
        zzi b;
        zzad c;
        final zzci d;
        String e;
        String f;
        String g;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(zzag zzagVar, String str, String str2, zzci zzciVar, zzad zzadVar) {
            this.f4152a = (zzag) zzdt.checkNotNull(zzagVar);
            this.d = zzciVar;
            zzc(str);
            zzd(str2);
            this.c = zzadVar;
        }

        public zza zzc(String str) {
            this.e = zzd.a(str);
            return this;
        }

        public zza zzd(String str) {
            this.f = zzd.b(str);
            return this;
        }

        public zza zze(String str) {
            this.g = str;
            return this;
        }

        public zza zza(zzi zziVar) {
            this.b = zziVar;
            return this;
        }
    }

    public final String zzc() {
        String valueOf = String.valueOf(this.d);
        String valueOf2 = String.valueOf(this.e);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final zzaa zzd() {
        return this.b;
    }

    public zzci zze() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzf<?> zzfVar) throws IOException {
        zzi zziVar = this.c;
        if (zziVar != null) {
            zziVar.zza(zzfVar);
        }
    }

    static String a(String str) {
        if (str != null) {
            return !str.endsWith("/") ? String.valueOf(str).concat("/") : str;
        }
        throw new NullPointerException(String.valueOf("root URL cannot be null."));
    }

    static String b(String str) {
        if (str == null) {
            throw new NullPointerException(String.valueOf("service path cannot be null"));
        }
        if (str.length() == 1) {
            if ("/".equals(str)) {
                return "";
            }
            throw new IllegalArgumentException(String.valueOf("service path must equal \"/\" if it is of length 1."));
        }
        if (str.length() <= 0) {
            return str;
        }
        if (!str.endsWith("/")) {
            str = String.valueOf(str).concat("/");
        }
        return str.startsWith("/") ? str.substring(1) : str;
    }
}
