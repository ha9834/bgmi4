package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

@zzard
/* loaded from: classes2.dex */
public final class zzasp extends zzass {

    /* renamed from: a, reason: collision with root package name */
    private final String f2796a;
    private final int b;

    public zzasp(String str, int i) {
        this.f2796a = str;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final String getType() {
        return this.f2796a;
    }

    @Override // com.google.android.gms.internal.ads.zzasr
    public final int getAmount() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzasp)) {
            return false;
        }
        zzasp zzaspVar = (zzasp) obj;
        return Objects.equal(this.f2796a, zzaspVar.f2796a) && Objects.equal(Integer.valueOf(this.b), Integer.valueOf(zzaspVar.b));
    }
}
