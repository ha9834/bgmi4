package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes2.dex */
public final class zzlw {

    /* renamed from: a, reason: collision with root package name */
    private static final zzlw f3682a = new zzlw(new int[]{2}, 2);
    private final int[] b;
    private final int c;

    private zzlw(int[] iArr, int i) {
        this.b = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.b);
        this.c = 2;
    }

    public final boolean zzaf(int i) {
        return Arrays.binarySearch(this.b, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlw)) {
            return false;
        }
        zzlw zzlwVar = (zzlw) obj;
        return Arrays.equals(this.b, zzlwVar.b) && this.c == zzlwVar.c;
    }

    public final int hashCode() {
        return this.c + (Arrays.hashCode(this.b) * 31);
    }

    public final String toString() {
        int i = this.c;
        String arrays = Arrays.toString(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
