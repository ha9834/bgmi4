package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ zzcq f3843a;
    private /* synthetic */ zzcon b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzcon zzconVar, zzcq zzcqVar) {
        this.b = zzconVar;
        this.f3843a = zzcqVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Set set;
        synchronized (this.b) {
            set = this.b.c;
            set.remove(this.f3843a.zzakx());
        }
    }
}
