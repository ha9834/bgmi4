package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzae {

    /* renamed from: a, reason: collision with root package name */
    int f4117a;
    String b;
    zzw c;
    String d;
    String e;

    public zzae(int i, String str, zzw zzwVar) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException();
        }
        this.f4117a = i;
        this.b = str;
        this.c = (zzw) zzdt.checkNotNull(zzwVar);
    }

    public zzae(zzac zzacVar) {
        this(zzacVar.getStatusCode(), zzacVar.getStatusMessage(), zzacVar.zzx());
        try {
            this.d = zzacVar.zzae();
            if (this.d.length() == 0) {
                this.d = null;
            }
        } catch (IOException e) {
            zzea.zza(e);
        }
        StringBuilder zzc = zzaf.zzc(zzacVar);
        if (this.d != null) {
            zzc.append(zzcl.zzgh);
            zzc.append(this.d);
        }
        this.e = zzc.toString();
    }

    public final zzae zzx(String str) {
        this.e = str;
        return this;
    }

    public final zzae zzy(String str) {
        this.d = str;
        return this;
    }
}
