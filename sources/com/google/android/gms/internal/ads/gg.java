package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gg extends zzax {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ byte[] f2191a;
    private final /* synthetic */ Map b;
    private final /* synthetic */ zzazx c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg(zzayu zzayuVar, int i, String str, zzaa zzaaVar, zzz zzzVar, byte[] bArr, Map map, zzazx zzazxVar) {
        super(i, str, zzaaVar, zzzVar);
        this.f2191a = bArr;
        this.b = map;
        this.c = zzazxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final byte[] zzg() throws zza {
        byte[] bArr = this.f2191a;
        return bArr == null ? super.zzg() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final Map<String, String> getHeaders() throws zza {
        Map<String, String> map = this.b;
        return map == null ? super.getHeaders() : map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzax
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(String str) {
        this.c.zzek(str);
        super.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzax, com.google.android.gms.internal.ads.zzr
    public final /* synthetic */ void a(String str) {
        a(str);
    }
}
