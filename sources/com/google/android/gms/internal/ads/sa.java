package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class sa<T> implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<T> f2482a;
    private final String b;
    private final zzaho<T> c;
    private final /* synthetic */ zzccj d;

    private sa(zzccj zzccjVar, WeakReference<T> weakReference, String str, zzaho<T> zzahoVar) {
        this.d = zzccjVar;
        this.f2482a = weakReference;
        this.b = str;
        this.c = zzahoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.f2482a.get();
        if (t == null) {
            this.d.zzb(this.b, this);
        } else {
            this.c.zza(t, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ sa(zzccj zzccjVar, WeakReference weakReference, String str, zzaho zzahoVar, ru ruVar) {
        this(zzccjVar, weakReference, str, zzahoVar);
    }
}
