package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@zzard
/* loaded from: classes2.dex */
public final class zzbfl {

    /* renamed from: a, reason: collision with root package name */
    private long f2866a;

    public final long zzl(ByteBuffer byteBuffer) {
        zzbg zzbgVar;
        zzbf zzbfVar;
        long j = this.f2866a;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbd> it = new zzbb(new kf(duplicate), kg.f2288a).zzbbd().iterator();
            while (true) {
                zzbgVar = null;
                if (!it.hasNext()) {
                    zzbfVar = null;
                    break;
                }
                zzbd next = it.next();
                if (next instanceof zzbf) {
                    zzbfVar = (zzbf) next;
                    break;
                }
            }
            Iterator<zzbd> it2 = zzbfVar.zzbbd().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbd next2 = it2.next();
                if (next2 instanceof zzbg) {
                    zzbgVar = (zzbg) next2;
                    break;
                }
            }
            this.f2866a = (zzbgVar.getDuration() * 1000) / zzbgVar.zzr();
            return this.f2866a;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
