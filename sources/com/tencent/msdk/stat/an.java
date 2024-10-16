package com.tencent.msdk.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.msdk.stat.a.d f6309a;
    final /* synthetic */ j b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ aj e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar, com.tencent.msdk.stat.a.d dVar, j jVar, boolean z, boolean z2) {
        this.e = ajVar;
        this.f6309a = dVar;
        this.b = jVar;
        this.c = z;
        this.d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.b(this.f6309a, this.b, this.c, this.d);
    }
}
