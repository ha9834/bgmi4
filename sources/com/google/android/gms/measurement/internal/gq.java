package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class gq extends go {
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gq(zzjg zzjgVar) {
        super(zzjgVar);
        this.f4889a.a(this);
    }

    protected abstract boolean a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (!b()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void initialize() {
        if (this.b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        a();
        this.f4889a.e();
        this.b = true;
    }
}
