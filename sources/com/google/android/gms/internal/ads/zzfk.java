package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public abstract class zzfk implements Callable {

    /* renamed from: a, reason: collision with root package name */
    protected final zzdy f3634a;
    protected final zzbp.zza.C0092zza b;
    protected Method c;
    private final String d = getClass().getSimpleName();
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    public zzfk(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2) {
        this.f3634a = zzdyVar;
        this.e = str;
        this.f = str2;
        this.b = c0092zza;
        this.g = i;
        this.h = i2;
    }

    protected abstract void a() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: zzcz, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        long nanoTime;
        try {
            nanoTime = System.nanoTime();
            this.c = this.f3634a.zzc(this.e, this.f);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (this.c == null) {
            return null;
        }
        a();
        zzda zzcm = this.f3634a.zzcm();
        if (zzcm != null && this.g != Integer.MIN_VALUE) {
            zzcm.zza(this.h, this.g, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
