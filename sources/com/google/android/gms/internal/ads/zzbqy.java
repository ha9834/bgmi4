package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class zzbqy {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3020a;
    private final zzcxv b;

    @Nullable
    private final String c;
    private Bundle d;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private Context f3021a;
        private zzcxv b;
        private Bundle c;

        @Nullable
        private String d;

        public final zza zzbt(Context context) {
            this.f3021a = context;
            return this;
        }

        public final zza zza(zzcxv zzcxvVar) {
            this.b = zzcxvVar;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.c = bundle;
            return this;
        }

        public final zza zzfg(String str) {
            this.d = str;
            return this;
        }

        public final zzbqy zzagh() {
            return new zzbqy(this);
        }
    }

    private zzbqy(zza zzaVar) {
        this.f3020a = zzaVar.f3021a;
        this.b = zzaVar.b;
        this.d = zzaVar.c;
        this.c = zzaVar.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza a() {
        return new zza().zzbt(this.f3020a).zza(this.b).zzfg(this.c).zze(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcxv b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Bundle c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String d() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a(Context context) {
        return this.c != null ? context : this.f3020a;
    }
}
