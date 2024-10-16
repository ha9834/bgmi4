package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzkj {
    public static final byte[] zzaqt = {0, 0, 0, 1};

    public static byte[] zzc(zzkm zzkmVar) {
        int readUnsignedShort = zzkmVar.readUnsignedShort();
        int position = zzkmVar.getPosition();
        zzkmVar.zzac(readUnsignedShort);
        return zzki.zza(zzkmVar.data, position, readUnsignedShort);
    }
}
