package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class f extends d {
    private static final WeakReference<byte[]> b = new WeakReference<>(null);

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<byte[]> f1421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        super(bArr);
        this.f1421a = b;
    }

    protected abstract byte[] b();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.d
    public final byte[] a() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f1421a.get();
            if (bArr == null) {
                bArr = b();
                this.f1421a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
