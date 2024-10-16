package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes2.dex */
public class IBeaconId {
    public static final int LENGTH = 20;

    /* renamed from: a, reason: collision with root package name */
    private final zzl f4979a;

    public IBeaconId(UUID uuid, short s, short s2) {
        this.f4979a = new zzl(uuid, Short.valueOf(s), Short.valueOf(s2));
    }

    @Hide
    private IBeaconId(byte[] bArr) {
        zzbq.checkArgument(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        this.f4979a = new zzl(bArr);
    }

    public static IBeaconId from(Message message) {
        boolean zzkx = message.zzkx(Message.MESSAGE_TYPE_I_BEACON_ID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 55);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_I_BEACON_ID");
        zzbq.checkArgument(zzkx, sb.toString());
        return new IBeaconId(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IBeaconId) {
            return zzbg.equal(this.f4979a, ((IBeaconId) obj).f4979a);
        }
        return false;
    }

    public short getMajor() {
        return this.f4979a.zzbdv().shortValue();
    }

    public short getMinor() {
        return this.f4979a.zzbdw().shortValue();
    }

    public UUID getProximityUuid() {
        return this.f4979a.getProximityUuid();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4979a});
    }

    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        short major = getMajor();
        short minor = getMinor();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
        sb.append("IBeaconId{proximityUuid=");
        sb.append(valueOf);
        sb.append(", major=");
        sb.append((int) major);
        sb.append(", minor=");
        sb.append((int) minor);
        sb.append('}');
        return sb.toString();
    }
}
