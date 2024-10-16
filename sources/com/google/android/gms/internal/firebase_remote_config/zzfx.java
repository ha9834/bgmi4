package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzfx implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    private static final bl f4174a;
    private static final Comparator<zzfx> b;
    public static final zzfx zzow = new zzgh(zzhi.zzty);
    private int zziz = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte b2) {
        return b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte a(int i);

    protected abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzfu zzfuVar) throws IOException;

    public abstract boolean equals(Object obj);

    public abstract int size();

    public abstract zzfx zzb(int i, int i2);

    public abstract boolean zzew();

    public abstract byte zzv(int i);

    public static zzfx zzb(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new zzgh(f4174a.a(bArr, i, i2));
    }

    public static zzfx zza(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfx a(byte[] bArr) {
        return new zzgh(bArr);
    }

    public static zzfx zzbj(String str) {
        return new zzgh(str.getBytes(zzhi.f4184a));
    }

    public final String zzb(Charset charset) {
        return size() == 0 ? "" : a(charset);
    }

    public final int hashCode() {
        int i = this.zziz;
        if (i == 0) {
            int size = size();
            i = a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zziz = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bm b(int i) {
        return new bm(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.zziz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new bg(this);
    }

    static {
        bg bgVar = null;
        f4174a = bb.a() ? new bn(bgVar) : new bk(bgVar);
        b = new bi();
    }
}
