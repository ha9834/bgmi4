package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.nearby.messages.internal.zzg f4978a;

    public EddystoneUid(String str) {
        this(com.google.android.gms.nearby.messages.internal.zzc.zzky(str));
    }

    public EddystoneUid(String str, String str2) {
        this.f4978a = new com.google.android.gms.nearby.messages.internal.zzg(str, str2);
    }

    @Hide
    private EddystoneUid(byte[] bArr) {
        zzbq.checkArgument(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.f4978a = new com.google.android.gms.nearby.messages.internal.zzg(bArr);
    }

    public static EddystoneUid from(Message message) {
        boolean zzkx = message.zzkx(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 58);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        zzbq.checkArgument(zzkx, sb.toString());
        return new EddystoneUid(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EddystoneUid) {
            return zzbg.equal(this.f4978a, ((EddystoneUid) obj).f4978a);
        }
        return false;
    }

    public String getHex() {
        return this.f4978a.getHex();
    }

    public String getInstance() {
        byte[] bytes = this.f4978a.getBytes();
        if (bytes.length < 16) {
            return null;
        }
        return com.google.android.gms.nearby.messages.internal.zzc.zzw(Arrays.copyOfRange(bytes, 10, 16));
    }

    public String getNamespace() {
        return com.google.android.gms.nearby.messages.internal.zzc.zzw(Arrays.copyOfRange(this.f4978a.getBytes(), 0, 10));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4978a});
    }

    public String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 17);
        sb.append("EddystoneUid{id=");
        sb.append(hex);
        sb.append('}');
        return sb.toString();
    }
}
