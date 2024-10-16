package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

/* loaded from: classes2.dex */
final class aki implements akl {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1933a = new byte[8];
    private final Stack<akk> b = new Stack<>();
    private final akn c = new akn();
    private akm d;
    private int e;
    private int f;
    private long g;

    @Override // com.google.android.gms.internal.ads.akl
    public final void a(akm akmVar) {
        this.d = akmVar;
    }

    @Override // com.google.android.gms.internal.ads.akl
    public final void a() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.akl
    public final boolean a(zzie zzieVar) throws IOException, InterruptedException {
        double longBitsToDouble;
        long j;
        int i;
        zzkh.checkState(this.d != null);
        while (true) {
            if (!this.b.isEmpty()) {
                long position = zzieVar.getPosition();
                j = this.b.peek().b;
                if (position >= j) {
                    akm akmVar = this.d;
                    i = this.b.pop().f1934a;
                    akmVar.b(i);
                    return true;
                }
            }
            if (this.e == 0) {
                long a2 = this.c.a(zzieVar, true, false);
                if (a2 == -1) {
                    return false;
                }
                this.f = (int) a2;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(zzieVar, false, true);
                this.e = 2;
            }
            int a3 = this.d.a(this.f);
            switch (a3) {
                case 0:
                    zzieVar.zzr((int) this.g);
                    this.e = 0;
                case 1:
                    long position2 = zzieVar.getPosition();
                    this.b.add(new akk(this.f, this.g + position2));
                    this.d.a(this.f, position2, this.g);
                    this.e = 0;
                    return true;
                case 2:
                    long j2 = this.g;
                    if (j2 > 8) {
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j2);
                        throw new IllegalStateException(sb.toString());
                    }
                    this.d.a(this.f, a(zzieVar, (int) j2));
                    this.e = 0;
                    return true;
                case 3:
                    long j3 = this.g;
                    if (j3 > 2147483647L) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j3);
                        throw new IllegalStateException(sb2.toString());
                    }
                    akm akmVar2 = this.d;
                    int i2 = this.f;
                    int i3 = (int) j3;
                    byte[] bArr = new byte[i3];
                    zzieVar.readFully(bArr, 0, i3);
                    akmVar2.a(i2, new String(bArr, Charset.forName("UTF-8")));
                    this.e = 0;
                    return true;
                case 4:
                    this.d.a(this.f, (int) this.g, zzieVar);
                    this.e = 0;
                    return true;
                case 5:
                    long j4 = this.g;
                    if (j4 != 4 && j4 != 8) {
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j4);
                        throw new IllegalStateException(sb3.toString());
                    }
                    akm akmVar3 = this.d;
                    int i4 = this.f;
                    int i5 = (int) this.g;
                    long a4 = a(zzieVar, i5);
                    if (i5 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) a4);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(a4);
                    }
                    akmVar3.a(i4, longBitsToDouble);
                    this.e = 0;
                    return true;
                default:
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a3);
                    throw new IllegalStateException(sb4.toString());
            }
        }
    }

    private final long a(zzie zzieVar, int i) throws IOException, InterruptedException {
        zzieVar.readFully(this.f1933a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f1933a[i2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        }
        return j;
    }
}
