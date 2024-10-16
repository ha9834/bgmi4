package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class zzbjn {

    /* renamed from: a, reason: collision with root package name */
    private final zzbai f2884a;
    private final Context b;
    private final WeakReference<Context> c;

    /* loaded from: classes2.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private zzbai f2885a;
        private Context b;
        private WeakReference<Context> c;

        public final zza zza(zzbai zzbaiVar) {
            this.f2885a = zzbaiVar;
            return this;
        }

        public final zza zzbo(Context context) {
            this.c = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.b = context;
            return this;
        }
    }

    private zzbjn(zza zzaVar) {
        this.f2884a = zzaVar.f2885a;
        this.b = zzaVar.b;
        this.c = zzaVar.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context b() {
        if (this.c.get() != null) {
            return this.c.get();
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbai c() {
        return this.f2884a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return zzk.zzlg().zzq(this.b, this.f2884a.zzbsx);
    }
}
