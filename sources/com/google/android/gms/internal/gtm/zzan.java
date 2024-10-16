package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
public abstract class zzan extends zzam {

    /* renamed from: a, reason: collision with root package name */
    private boolean f4386a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzan(zzap zzapVar) {
        super(zzapVar);
    }

    protected abstract void a();

    public final boolean isInitialized() {
        return this.f4386a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzag() {
        a();
        this.f4386a = true;
    }
}
