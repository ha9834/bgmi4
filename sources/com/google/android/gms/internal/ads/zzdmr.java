package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzdmr implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    private static final aev f3583a;
    private static final Comparator<zzdmr> b;
    public static final zzdmr zzhcr = new zzdnb(zzdod.zzhia);
    private int zzhca = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte b2) {
        return b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte a(int i);

    protected abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzdmq zzdmqVar) throws IOException;

    protected abstract void a(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract int size();

    public abstract boolean zzavo();

    public abstract zzdnd zzavp();

    public abstract byte zzfm(int i);

    public abstract zzdmr zzv(int i, int i2);

    public static zzdmr zzi(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new zzdnb(f3583a.a(bArr, i, i2));
    }

    public static zzdmr zzz(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdmr a(byte[] bArr) {
        return new zzdnb(bArr);
    }

    public static zzdmr zzgv(String str) {
        return new zzdnb(str.getBytes(zzdod.f3593a));
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzdod.zzhia;
        }
        byte[] bArr = new byte[size];
        a(bArr, 0, 0, size);
        return bArr;
    }

    public final String zzavn() {
        return size() == 0 ? "" : a(zzdod.f3593a);
    }

    public final int hashCode() {
        int i = this.zzhca;
        if (i == 0) {
            int size = size();
            i = a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzhca = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static aew b(int i) {
        return new aew(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.zzhca;
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
        return new aer(this);
    }

    static {
        aer aerVar = null;
        f3583a = aen.a() ? new aey(aerVar) : new aeu(aerVar);
        b = new aes();
    }
}
