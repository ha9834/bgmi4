package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

@Hide
/* loaded from: classes2.dex */
public final class zzg extends zzc {
    public zzg(String str) {
        this(zzky(str));
    }

    public zzg(String str, String str2) {
        this(zzky(str), zzky(str2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(byte[] bArr) {
        super(bArr);
        zzbq.checkArgument(bArr.length == 10 || bArr.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private zzg(byte[] r8, byte[] r9) {
        /*
            r7 = this;
            r0 = 2
            byte[][] r0 = new byte[r0]
            int r1 = r8.length
            r2 = 1
            r3 = 0
            r4 = 10
            if (r1 != r4) goto Lc
            r1 = 1
            goto Ld
        Lc:
            r1 = 0
        Ld:
            int r4 = r8.length
            r5 = 53
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Namespace length("
            r6.append(r5)
            r6.append(r4)
            java.lang.String r4 = " bytes) must be 10 bytes."
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.common.internal.zzbq.checkArgument(r1, r4)
            r0[r3] = r8
            int r8 = r9.length
            r1 = 6
            if (r8 != r1) goto L30
            r3 = 1
        L30:
            int r8 = r9.length
            r1 = 51
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Instance length("
            r4.append(r1)
            r4.append(r8)
            java.lang.String r8 = " bytes) must be 6 bytes."
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            com.google.android.gms.common.internal.zzbq.checkArgument(r3, r8)
            r0[r2] = r9
            byte[] r8 = com.google.android.gms.common.util.zzb.zza(r0)
            r7.<init>(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzg.<init>(byte[], byte[]):void");
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 26);
        sb.append("EddystoneUidPrefix{bytes=");
        sb.append(hex);
        sb.append('}');
        return sb.toString();
    }
}
