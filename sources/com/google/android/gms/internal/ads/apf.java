package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apf extends zzbbr<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzwb f2028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apf(zzwb zzwbVar) {
        this.f2028a = zzwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbr, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.f2028a.a();
        return super.cancel(z);
    }
}
