package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gr implements cw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4891a;
    private final /* synthetic */ zzjg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(zzjg zzjgVar, String str) {
        this.b = zzjgVar;
        this.f4891a = str;
    }

    @Override // com.google.android.gms.measurement.internal.cw
    public final void a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.b.a(i, th, bArr, this.f4891a);
    }
}
