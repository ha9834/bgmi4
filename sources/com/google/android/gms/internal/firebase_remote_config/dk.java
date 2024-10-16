package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dk implements cw {

    /* renamed from: a, reason: collision with root package name */
    private final zzim f4077a;
    private final String b;
    private final Object[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(zzim zzimVar, String str, Object[] objArr) {
        this.f4077a = zzimVar;
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

    @Override // com.google.android.gms.internal.firebase_remote_config.cw
    public final zzim c() {
        return this.f4077a;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cw
    public final int a() {
        return (this.d & 1) == 1 ? zzhh.zzd.zzts : zzhh.zzd.zztt;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.cw
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
