package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class agu implements agi {

    /* renamed from: a, reason: collision with root package name */
    private final zzdpk f1870a;
    private final String b;
    private final Object[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public agu(zzdpk zzdpkVar, String str, Object[] objArr) {
        this.f1870a = zzdpkVar;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.agi
    public final zzdpk c() {
        return this.f1870a;
    }

    @Override // com.google.android.gms.internal.ads.agi
    public final int a() {
        return (this.d & 1) == 1 ? zzdob.zze.zzhhs : zzdob.zze.zzhht;
    }

    @Override // com.google.android.gms.internal.ads.agi
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
