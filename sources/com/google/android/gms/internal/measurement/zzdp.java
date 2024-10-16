package com.google.android.gms.internal.measurement;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzdp implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    private static final bo f4552a;
    private static final Comparator<zzdp> b;
    public static final zzdp zzadh = new zzdz(zzez.zzair);
    private int zzadj = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte b2) {
        return b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte a(int i);

    protected abstract int a(int i, int i2, int i3);

    protected abstract String a(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(zzdm zzdmVar) throws IOException;

    public abstract boolean equals(Object obj);

    public abstract int size();

    public abstract zzdp zza(int i, int i2);

    public abstract byte zzaq(int i);

    public abstract boolean zzsb();

    public static zzdp zzb(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new zzdz(f4552a.a(bArr, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdp a(byte[] bArr) {
        return new zzdz(bArr);
    }

    public static zzdp zzdq(String str) {
        return new zzdz(str.getBytes(zzez.f4562a));
    }

    public final String zzsa() {
        return size() == 0 ? "" : a(zzez.f4562a);
    }

    public final int hashCode() {
        int i = this.zzadj;
        if (i == 0) {
            int size = size();
            i = a(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzadj = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bp b(int i) {
        return new bp(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        return this.zzadj;
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
        return new bk(this);
    }

    static {
        bk bkVar = null;
        f4552a = bf.a() ? new bq(bkVar) : new bn(bkVar);
        b = new bm();
    }
}
