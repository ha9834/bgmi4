package com.tencent.msdk.stat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f6312a;
    final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(aj ajVar, int i) {
        this.b = ajVar;
        this.f6312a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f6312a, true);
        this.b.b(this.f6312a, false);
    }
}
