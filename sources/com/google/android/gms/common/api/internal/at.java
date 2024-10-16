package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements IBinder.DeathRecipient, au {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<BasePendingResult<?>> f1345a;
    private final WeakReference<com.google.android.gms.common.api.zac> b;
    private final WeakReference<IBinder> c;

    private at(BasePendingResult<?> basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder) {
        this.b = new WeakReference<>(zacVar);
        this.f1345a = new WeakReference<>(basePendingResult);
        this.c = new WeakReference<>(iBinder);
    }

    @Override // com.google.android.gms.common.api.internal.au
    public final void a(BasePendingResult<?> basePendingResult) {
        a();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        a();
    }

    private final void a() {
        BasePendingResult<?> basePendingResult = this.f1345a.get();
        com.google.android.gms.common.api.zac zacVar = this.b.get();
        if (zacVar != null && basePendingResult != null) {
            zacVar.remove(basePendingResult.zam().intValue());
        }
        IBinder iBinder = this.c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ at(BasePendingResult basePendingResult, com.google.android.gms.common.api.zac zacVar, IBinder iBinder, as asVar) {
        this(basePendingResult, null, iBinder);
    }
}
