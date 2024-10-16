package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class r<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzacj f2455a;
    private final /* synthetic */ zzacr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zzacr zzacrVar, zzacj zzacjVar) {
        this.b = zzacrVar;
        this.f2455a = zzacjVar;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        SharedPreferences sharedPreferences;
        zzacj zzacjVar = this.f2455a;
        sharedPreferences = this.b.e;
        return (T) zzacjVar.a(sharedPreferences);
    }
}
