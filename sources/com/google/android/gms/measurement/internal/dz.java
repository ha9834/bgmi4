package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class dz extends bu {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(zzfj zzfjVar) {
        super(zzfjVar);
        this.v.a(this);
    }

    protected abstract boolean a();

    protected void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return this.f4823a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void initialize() {
        if (this.f4823a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (a()) {
            return;
        }
        this.v.f();
        this.f4823a = true;
    }

    public final void zzbj() {
        if (this.f4823a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        b();
        this.v.f();
        this.f4823a = true;
    }
}
