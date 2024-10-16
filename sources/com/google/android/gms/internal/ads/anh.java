package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class anh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ank f1983a;
    private final /* synthetic */ ane b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anh(ane aneVar, ank ankVar) {
        this.b = aneVar;
        this.f1983a = ankVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        this.f1983a.a();
        sparseArray = this.b.p;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray2 = this.b.p;
            ((zzqt) sparseArray2.valueAt(i)).disable();
        }
    }
}
