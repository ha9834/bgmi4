package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzln {
    public static final zzln zzaug = new zzln(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    private final int f3679a;
    public final float zzauh;
    public final float zzaui;

    public zzln(float f, float f2) {
        this.zzauh = f;
        this.zzaui = f2;
        this.f3679a = Math.round(f * 1000.0f);
    }

    public final long zzef(long j) {
        return j * this.f3679a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzln zzlnVar = (zzln) obj;
        return this.zzauh == zzlnVar.zzauh && this.zzaui == zzlnVar.zzaui;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzauh) + 527) * 31) + Float.floatToRawIntBits(this.zzaui);
    }
}
