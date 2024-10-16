package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
final class amg extends amf {
    public final List<amh> aA;
    public final List<amg> aB;
    public final long az;

    public amg(int i, long j) {
        super(i);
        this.az = j;
        this.aA = new ArrayList();
        this.aB = new ArrayList();
    }

    public final amh d(int i) {
        int size = this.aA.size();
        for (int i2 = 0; i2 < size; i2++) {
            amh amhVar = this.aA.get(i2);
            if (amhVar.ay == i) {
                return amhVar;
            }
        }
        return null;
    }

    public final amg e(int i) {
        int size = this.aB.size();
        for (int i2 = 0; i2 < size; i2++) {
            amg amgVar = this.aB.get(i2);
            if (amgVar.ay == i) {
                return amgVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.amf
    public final String toString() {
        String c = c(this.ay);
        String arrays = Arrays.toString(this.aA.toArray());
        String arrays2 = Arrays.toString(this.aB.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(c);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }
}
