package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzlr {
    public static final zzlr zzaum = new ala();

    public abstract zzlt zza(int i, zzlt zzltVar, boolean z);

    public abstract zzlu zza(int i, zzlu zzluVar, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzhf();

    public abstract int zzhg();

    public final boolean isEmpty() {
        return zzhf() == 0;
    }

    public final zzlu zza(int i, zzlu zzluVar, boolean z) {
        return zza(i, zzluVar, false, 0L);
    }

    public final int zza(int i, zzlt zzltVar, zzlu zzluVar, int i2) {
        zza(i, zzltVar, false);
        zza(0, zzluVar, false);
        int i3 = 1;
        if (i != 0) {
            return i + 1;
        }
        switch (i2) {
            case 0:
                if (zzhf() - 1 == 0) {
                    i3 = -1;
                    break;
                }
                break;
            case 1:
                i3 = 0;
                break;
            case 2:
                if (zzhf() - 1 == 0) {
                    i3 = 0;
                    break;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        if (i3 == -1) {
            return -1;
        }
        zza(i3, zzluVar, false);
        return 0;
    }
}
