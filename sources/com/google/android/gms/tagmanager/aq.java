package com.google.android.gms.tagmanager;

import android.content.Context;

/* loaded from: classes2.dex */
final class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ an f5079a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;
    private final /* synthetic */ ao d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, an anVar, long j, String str) {
        this.d = aoVar;
        this.f5079a = anVar;
        this.b = j;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ar arVar;
        ar arVar2;
        Context context;
        arVar = this.d.e;
        if (arVar == null) {
            df a2 = df.a();
            context = this.d.f;
            a2.a(context, this.f5079a);
            this.d.e = a2.b();
        }
        arVar2 = this.d.e;
        arVar2.a(this.b, this.c);
    }
}
