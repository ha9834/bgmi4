package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzir extends akc {
    public final long zzalz;
    public final List<zzis> zzama;
    public final List<zzir> zzamb;

    public zzir(int i, long j) {
        super(i);
        this.zzama = new ArrayList();
        this.zzamb = new ArrayList();
        this.zzalz = j;
    }

    public final zzis zzv(int i) {
        int size = this.zzama.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzis zzisVar = this.zzama.get(i2);
            if (zzisVar.type == i) {
                return zzisVar;
            }
        }
        return null;
    }

    public final zzir zzw(int i) {
        int size = this.zzamb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzir zzirVar = this.zzamb.get(i2);
            if (zzirVar.type == i) {
                return zzirVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.akc
    public final String toString() {
        String zzu = zzu(this.type);
        String valueOf = String.valueOf(Arrays.toString(this.zzama.toArray(new zzis[0])));
        String valueOf2 = String.valueOf(Arrays.toString(this.zzamb.toArray(new zzir[0])));
        StringBuilder sb = new StringBuilder(String.valueOf(zzu).length() + 22 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append(zzu);
        sb.append(" leaves: ");
        sb.append(valueOf);
        sb.append(" containers: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
