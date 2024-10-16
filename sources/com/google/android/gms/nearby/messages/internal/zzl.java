package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.nio.ByteBuffer;
import java.util.UUID;

@Hide
/* loaded from: classes2.dex */
public final class zzl extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzl(java.util.UUID r5, java.lang.Short r6, java.lang.Short r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = 2
            if (r6 != 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 2
        L7:
            int r2 = r2 + 16
            if (r7 != 0) goto Lc
            goto Ld
        Lc:
            r0 = 2
        Ld:
            int r2 = r2 + r0
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r2)
            long r1 = r5.getMostSignificantBits()
            java.nio.ByteBuffer r1 = r0.putLong(r1)
            long r2 = r5.getLeastSignificantBits()
            r1.putLong(r2)
            if (r6 == 0) goto L2a
            short r5 = r6.shortValue()
            r0.putShort(r5)
        L2a:
            if (r7 == 0) goto L33
            short r5 = r7.shortValue()
            r0.putShort(r5)
        L33:
            byte[] r5 = r0.array()
            r4.<init>(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzl.<init>(java.util.UUID, java.lang.Short, java.lang.Short):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzl(byte[] bArr) {
        super(bArr);
        zzbq.checkArgument(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
    }

    public final UUID getProximityUuid() {
        ByteBuffer wrap = ByteBuffer.wrap(getBytes());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        String valueOf2 = String.valueOf(zzbdv());
        String valueOf3 = String.valueOf(zzbdw());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("IBeaconIdPrefix{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append(valueOf2);
        sb.append(", minor=");
        sb.append(valueOf3);
        sb.append('}');
        return sb.toString();
    }

    public final Short zzbdv() {
        byte[] bytes = getBytes();
        if (bytes.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(16));
        }
        return null;
    }

    public final Short zzbdw() {
        byte[] bytes = getBytes();
        if (bytes.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(bytes).getShort(18));
        }
        return null;
    }
}
