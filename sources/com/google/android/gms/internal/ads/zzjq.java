package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes2.dex */
public final class zzjq {
    public final int flags;
    public final Uri uri;
    public final long zzahv;
    public final long zzapg;
    public final String zzcc;
    public final long zzcd;

    public zzjq(Uri uri) {
        this(uri, 0);
    }

    private zzjq(Uri uri, int i) {
        this(uri, 0L, -1L, null, 0);
    }

    public zzjq(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, null, 0);
    }

    private zzjq(Uri uri, long j, long j2, String str, int i) {
        this(uri, 0L, 0L, -1L, null, 0);
    }

    public zzjq(Uri uri, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzkh.checkArgument(j >= 0);
        zzkh.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzkh.checkArgument(z);
        this.uri = uri;
        this.zzapg = j;
        this.zzahv = j2;
        this.zzcd = j3;
        this.zzcc = str;
        this.flags = i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        long j = this.zzapg;
        long j2 = this.zzahv;
        long j3 = this.zzcd;
        String str = this.zzcc;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91 + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
